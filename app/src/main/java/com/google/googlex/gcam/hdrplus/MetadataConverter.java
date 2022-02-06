package com.google.googlex.gcam.hdrplus;

import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.BlackLevelPattern;
import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.Face;
import android.hardware.camera2.params.LensShadingMap;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OisSample;
import android.hardware.camera2.params.RggbChannelVector;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.util.SizeF;

import com.FixBSG;
import com.google.googlex.gcam.AeMetadata;
import com.google.googlex.gcam.AeShotParams;
import com.google.googlex.gcam.AfMetadata;
import com.google.googlex.gcam.AwbInfo;
import com.google.googlex.gcam.AwbMetadata;
import com.google.googlex.gcam.BayerPattern;
import com.google.googlex.gcam.DngColorCalibration;
import com.google.googlex.gcam.DngColorCalibrationVector;
import com.google.googlex.gcam.DngNoiseModel;
import com.google.googlex.gcam.FaceInfo;
import com.google.googlex.gcam.FaceInfoVector;
import com.google.googlex.gcam.FloatVector;
import com.google.googlex.gcam.FrameMetadata;
import com.google.googlex.gcam.FrameRequest;
import com.google.googlex.gcam.GcamModule;
import com.google.googlex.gcam.GyroSampleVector;
import com.google.googlex.gcam.LensFacing;
import com.google.googlex.gcam.NormalizedRect;
import com.google.googlex.gcam.OisMetadata;
import com.google.googlex.gcam.OisPosition;
import com.google.googlex.gcam.OisPositionVector;
import com.google.googlex.gcam.PixelRect;
import com.google.googlex.gcam.PixelRectVector;
import com.google.googlex.gcam.QcColorCalibration;
import com.google.googlex.gcam.QcIlluminantVector;
import com.google.googlex.gcam.SpatialGainMap;
import com.google.googlex.gcam.StaticMetadata;
import com.google.googlex.gcam.WeightedNormalizedRect;
import com.google.googlex.gcam.WeightedNormalizedRectVector;
import com.google.googlex.gcam.WeightedPixelRect;
import com.google.googlex.gcam.WeightedPixelRectVector;
import com.google.googlex.gcam.androidutils.MathUtils;
import com.madnessknight.ProductCharacteristics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import defpackage.kvf;
import defpackage.kvg;
import defpackage.lyb;
import defpackage.lyw;
import defpackage.lyx;
import defpackage.mcs;
import defpackage.mmb;
import defpackage.mms;
import defpackage.mmt;
import defpackage.mnh;
import defpackage.mpj;
import defpackage.mpz;
import defpackage.ohr;

public class MetadataConverter {
    public static final float ANTIBANDING_50HZ_PERIOD_MS = 10.0f;
    public static final float ANTIBANDING_60HZ_PERIOD_MS = 8.333333f;
    public static final float ANTIBANDING_EXPOSURE_TIME_TOLERANCE_MS = 0.05f;
    public static final int COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS = 9;
    public static final int COLOR_SPACE_TRANSFORM_MATRIX_RATIONAL_DENOMINATOR = 10000;
    public static final int CONTROL_POST_RAW_SENSITIVITY_BOOST_UNITY = 100;
    public static final float GCAM_CALCULATES_SHARPNESS = 0.0f;
    public static final float GCAM_METERING_REGION_FRACTION = 0.1225f;
    public static final float GCAM_METERING_REGION_WEIGHT = 45.0f;
    public static final String GCAM_SOFTWARE_TAG = "HDR+";
    public static final float OIS_RAW_2_PIXEL_X_COEFF = -0.007517f;
    public static final float OIS_RAW_2_PIXEL_Y_COEFF = -0.00733f;
    public static final String TAG = MetadataConverter.class.getSimpleName();
    public final mmb characteristics;
    public final mpj deviceProperties = mpj.a();
    public final int[] evenOddIndexMap;
    public final int faceDetectMode;
    public final int maxAnalogIso;
    public final int minIso;
    public final Rect preCorrectionActiveArraySize;
    public final int[] redBlueIndexMap;

    public static final ProductCharacteristics pCharacteristics = ProductCharacteristics.getSef();

    public static class ExtendedFaces {
        private int[] faceLandmarkCounts;
        private byte[] faceLandmarkIds;
        private float[] faceLandmarkXy;
        private final Face[] faces;

        public ExtendedFaces(mpz result) {
            faces = (Face[]) result.a(CaptureResult.STATISTICS_FACES);
            if (kvg.l != null && kvg.m != null && kvg.n != null) {
                faceLandmarkCounts = (int[]) result.a(kvg.l);
                faceLandmarkIds = (byte[]) result.a(kvg.m);
                faceLandmarkXy = (float[]) result.a(kvg.n);
            }
        }

        public ExtendedFaces(Face[] faceArr) {
            faces = faceArr;
        }

        boolean extendedFacesAvailable() {
            int[] iArr = faceLandmarkCounts;
            return facesAvailable() && iArr != null && iArr.length == faces.length;
        }

        public boolean facesAvailable() {
            Face[] faceArr = faces;
            return faceArr != null && faceArr.length > 0;
        }

        int[] getFaceLandmarkCounts() {
            return faceLandmarkCounts;
        }

        byte[] getFaceLandmarkIds() {
            return faceLandmarkIds;
        }

        float[] getFaceLandmarkXy() {
            return faceLandmarkXy;
        }

        Face[] getFaces() {
            return faces;
        }
    }

    enum LandmarkIndex {
        LEFT_EYE(0),
        RIGHT_EYE(1),
        MOUTH_CENTER(45);

        public final int index;

        LandmarkIndex(int i) {
            index = i;
        }

        public final int getIndex() {
            return index;
        }

        final Point getLandmarkLocation(Face face) {
            switch (ordinal()) {
                case 0: return face.getLeftEyePosition();
                case 1: return face.getRightEyePosition();
                case 2: return face.getMouthPosition();
                default: return null;
            }
        }
    }

    public MetadataConverter(mmb mmb) {
        characteristics = mmb;
        minIso = ((Range<Integer>) mmb.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)).getLower();
        maxAnalogIso = (int) mmb.b(CameraCharacteristics.SENSOR_MAX_ANALOG_SENSITIVITY);
        int intValue = (int) mmb.b(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT);
        redBlueIndexMap = getRedBlueSourceIndicesForCfa(intValue);
        evenOddIndexMap = getEvenOddSourceIndicesForCfa(intValue);
        preCorrectionActiveArraySize = (Rect) mmb.b(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        //MetadataConverterMod.metadataConv = this;
        if (deviceProperties.d() || deviceProperties.e()) {
            faceDetectMode = mms.EXTENDED.e;
        } else {
            faceDetectMode = mmb.h().e;
        }
    }

    private void appendMeteringRectanglesAsGcamWeightedPixelRects(MeteringRectangle[] meteringRectangleArr, WeightedPixelRectVector weightedPixelRectVector) {
        if (meteringRectangleArr != null) {
            for (MeteringRectangle meteringRectangle : meteringRectangleArr) {
                if (meteringRectangle.getMeteringWeight() != 0) {
                    WeightedPixelRect weightedPixelRect = new WeightedPixelRect();
                    Rect rect = meteringRectangle.getRect();
                    PixelRect rect2 = weightedPixelRect.getRect();
                    rect2.setX0(rect.left);
                    rect2.setX1(rect.right);
                    rect2.setY0(rect.top);
                    rect2.setY1(rect.bottom);
                    weightedPixelRect.setWeight((float) meteringRectangle.getMeteringWeight());
                    weightedPixelRectVector.add(weightedPixelRect);
                }
            }
        }
    }

    private static int convertToBayerPattern(int cfa) {
        switch (cfa) {
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB: return BayerPattern.kRGGB;
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG: return BayerPattern.kGRBG;
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG: return BayerPattern.kGBRG;
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR: return BayerPattern.kBGGR;
            default:
                Log.w(TAG, "convertToBayerPattern: unsupported color filter arrangement: " + cfa + ", returning kInvalid.");
                return BayerPattern.kInvalid;
        }
    }

    public static ColorSpaceTransform convertToColorSpaceTransform(float[] buff) {
        ohr.a(buff.length == COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS, "ccm must have length %s.", COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS);
        Rational[] rationals = new Rational[COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS];
        for (int i = 0; i < rationals.length; i++)
            rationals[i] = new Rational((int) (buff[i] * 10000.0f), COLOR_SPACE_TRANSFORM_MATRIX_RATIONAL_DENOMINATOR);
        return new ColorSpaceTransform(rationals);
    }

    private static float[] convertToFloatArray(ColorSpaceTransform buff) {
        Rational[] rationals = new Rational[COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS];
        buff.copyElements(rationals, 0);
        float[] data = new float[COLOR_SPACE_TRANSFORM_MATRIX_NUM_ELEMENTS];
        for (int i = 0; i < data.length; i++)
            data[i] = rationals[i].floatValue();
        return data;
    }

    public static StaticMetadata convertToGcamStaticMetadata(mmb characteristics) {
        String vendor;
        String model;
        String codename;
        if (FixBSG.MenuValue("pref_denoise_key") != 0) {
            vendor = "Google";
            codename = "sargo";
            model = "Pixel 3a";
        } else {
            vendor = "Google";
            codename = "marlin";
            model = "Pixel XL";
        }

        var staticMetadata = new StaticMetadata();
        FixBSG.GetLens(characteristics);
        staticMetadata.setMake(vendor);
        staticMetadata.setDevice(codename);
        staticMetadata.setModel(model);

        Log.e(vendor, codename);

        String GetVersion = GcamModule.GetVersion();
        String str3 = GCAM_SOFTWARE_TAG;
        if (GetVersion.length() != 0) {
            str3 = str3.concat(GetVersion);
        }
        staticMetadata.setSoftware(str3);
        staticMetadata.setDevice_os_version(Build.FINGERPRINT);
        staticMetadata.setSensor_id(getGcamSensorId(characteristics));
        staticMetadata.setHas_flash(characteristics.C());
        staticMetadata.setLens_facing(convertToLensFacing(characteristics.b()));

        List<Float> focalLengths = characteristics.i();
        ohr.a(!focalLengths.isEmpty(), "Cameras must have at least one focal length.");
        FloatVector availableFocalLengths = new FloatVector();
        for (Float focalLength : focalLengths)
            availableFocalLengths.add(focalLength);
        staticMetadata.setAvailable_focal_lengths_mm(availableFocalLengths);

        float[] apertures = (float[]) characteristics.b(CameraCharacteristics.LENS_INFO_AVAILABLE_APERTURES);
        ohr.a(apertures.length > 0, "Cameras must have at least one f-number (aperture size).");
        FloatVector apertureSizes = new FloatVector();
        for (float aperture : apertures) {
            apertureSizes.add(aperture);
        }
        staticMetadata.setAvailable_f_numbers(apertureSizes);

        staticMetadata.setWhite_level((int) characteristics.a(CameraCharacteristics.SENSOR_INFO_WHITE_LEVEL));

        var opticalBlackRegions = (Rect[]) characteristics.a(CameraCharacteristics.SENSOR_OPTICAL_BLACK_REGIONS);
        if (opticalBlackRegions != null) {
            var pixelRectVector = new PixelRectVector();
            for (Rect rect : opticalBlackRegions) {
                PixelRect pixelRect = new PixelRect();
                pixelRect.setX0(rect.left);
                pixelRect.setX1(rect.right);
                pixelRect.setY0(rect.top);
                pixelRect.setY1(rect.bottom);
                pixelRectVector.add(pixelRect);
            }
            staticMetadata.setOptically_black_regions(pixelRectVector);
        }

        if (pCharacteristics.isJ7Y17() ||
            pCharacteristics.isA3Y17())
            staticMetadata.setBayer_pattern(BayerPattern.kRGGB);

        else
            staticMetadata.setBayer_pattern(convertToBayerPattern((int) characteristics.b(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT)));

        int[] isoRange = {
                ((Range<Integer>) characteristics.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)).getLower(),
                ((Range<Integer>) characteristics.b(CameraCharacteristics.SENSOR_INFO_SENSITIVITY_RANGE)).getUpper()
        };
        int maxAnalogSensitivity = (Integer) characteristics.b(CameraCharacteristics.SENSOR_MAX_ANALOG_SENSITIVITY);
        staticMetadata.setIso_range(isoRange);
        staticMetadata.setMax_analog_iso(maxAnalogSensitivity);

        var dngColorCalibrationVector = new DngColorCalibrationVector();
        var referenceIlluminant1 = (Integer) characteristics.a(CameraCharacteristics.SENSOR_REFERENCE_ILLUMINANT1);
        if (referenceIlluminant1 != null) {
            float[] colorTransform1 = convertToFloatArray((ColorSpaceTransform) characteristics.b(CameraCharacteristics.SENSOR_COLOR_TRANSFORM1));
            float[] calibTransform1 = convertToFloatArray((ColorSpaceTransform) characteristics.b(CameraCharacteristics.SENSOR_CALIBRATION_TRANSFORM1));
            var dngColorCalibration = new DngColorCalibration();
            dngColorCalibration.setIlluminant(referenceIlluminant1);
            dngColorCalibration.setXyz_to_model_rgb(colorTransform1);
            dngColorCalibration.setModel_rgb_to_device_rgb(calibTransform1);
            dngColorCalibrationVector.add(dngColorCalibration);
        }
        var referenceIlluminant2 = (Byte) characteristics.a(CameraCharacteristics.SENSOR_REFERENCE_ILLUMINANT2);
        if (referenceIlluminant2 != null) {
            float[] colorTransform2 = convertToFloatArray((ColorSpaceTransform) characteristics.b(CameraCharacteristics.SENSOR_COLOR_TRANSFORM2));
            float[] calibTransform2 = convertToFloatArray((ColorSpaceTransform) characteristics.b(CameraCharacteristics.SENSOR_CALIBRATION_TRANSFORM2));
            var dngColorCalibration2 = new DngColorCalibration();
            dngColorCalibration2.setIlluminant(referenceIlluminant2);
            dngColorCalibration2.setXyz_to_model_rgb(colorTransform2);
            dngColorCalibration2.setModel_rgb_to_device_rgb(calibTransform2);
            dngColorCalibrationVector.add(dngColorCalibration2);
        }
        staticMetadata.setDng_color_calibration(dngColorCalibrationVector);

        staticMetadata.setQc_color_calibration(getQcColorCalibration());

        SizeF physicalSize = (SizeF) characteristics.b(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
        staticMetadata.setSensor_physical_width_mm(physicalSize.getWidth());
        staticMetadata.setSensor_physical_height_mm(physicalSize.getHeight());

        Size pixelArraySize = (Size) characteristics.b(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
        staticMetadata.setPixel_array_width(pixelArraySize.getWidth());
        staticMetadata.setPixel_array_height(pixelArraySize.getHeight());

        Rect preCorrectionActiveArraySize = (Rect) characteristics.b(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        /*
        var pixelRect2 = new PixelRect();
        pixelRect2.setX0(preCorrectionActiveArraySize.left);
        pixelRect2.setY0(preCorrectionActiveArraySize.top);
        var gcamRawFormat = getGcamRawFormat(characteristics);
        int i2 = gcamRawFormat.b.a;
        staticMetadata.setFrame_raw_max_width(i2);
        pixelRect2.setX1(i2);
        int i3 = gcamRawFormat.b.b;
        staticMetadata.setFrame_raw_max_height(i3);
        pixelRect2.setY1(i3);
        staticMetadata.setActive_area(pixelRect2);
         */

        var gcamRawFormat = getGcamRawFormat(characteristics);
        int rawMaxWidth = gcamRawFormat.b.a;
        int rawMaxHeight = gcamRawFormat.b.b;

        var activeArea = new PixelRect();
        activeArea.setX0(preCorrectionActiveArraySize.left);
        activeArea.setY0(preCorrectionActiveArraySize.top);
        activeArea.setX1(rawMaxWidth);
        activeArea.setY1(rawMaxHeight);
        staticMetadata.setActive_area(activeArea);

        staticMetadata.setFrame_raw_max_width(rawMaxWidth);
        staticMetadata.setFrame_raw_max_height(rawMaxHeight);

        staticMetadata.setRaw_bits_per_pixel(ImageFormat.getBitsPerPixel(gcamRawFormat.a));
        staticMetadata.setFrame_readout_time_ms(nsToMsFloat(getReadoutTimeNs(characteristics)));
        return staticMetadata;
    }

    private static int convertToLensFacing(mmt facingEnum) {
        switch (facingEnum.ordinal()) {
            case CameraCharacteristics.LENS_FACING_FRONT: return LensFacing.kFront;
            case CameraCharacteristics.LENS_FACING_BACK: return LensFacing.kBack;
            case CameraCharacteristics.LENS_FACING_EXTERNAL: return LensFacing.kExternal;
            default: return LensFacing.kUnknown;
        }
    }

    private NormalizedRect convertToNormalizedRect(Rect rect) {
        NormalizedRect normalizedRect = new NormalizedRect();
        float width = 1.0f / preCorrectionActiveArraySize.width();
        float height = 1.0f / preCorrectionActiveArraySize.height();
        normalizedRect.setX0(rect.left * width);
        normalizedRect.setY0(rect.top * height);
        normalizedRect.setX1(rect.right * width);
        normalizedRect.setY1(rect.bottom * height);
        return normalizedRect;
    }

    private float[] getAnalogAndDigitalGain(mpz capture) {
        float analog, digital;
        float iso = (float) (int) capture.a(CaptureResult.SENSOR_SENSITIVITY);
        if (iso > maxAnalogIso) {
            analog = (float) maxAnalogIso / minIso;
            digital = Math.max(iso / maxAnalogIso, 1.0f);
        } else {
            analog = iso / minIso;
            digital = 1.0f;
        }
        return new float[]{analog, digital};
    }


    private static float[] getAwbGains(mpz mpz, int[] iArr) {
        float[] fArr = new float[4];
        RggbChannelVector rggbChannelVector = (RggbChannelVector) mpz.a(CaptureResult.COLOR_CORRECTION_GAINS);
        if (rggbChannelVector != null) {
            for (int i = 0; i < 4; i++)
                fArr[i] = rggbChannelVector.getComponent(iArr[i]);
            return fArr;
        }
        Log.w(TAG, "CaptureResult missing COLOR_CORRECTION_GAINS.");
        Arrays.fill(fArr, 1.0f);
        return fArr;
    }

    private static float[] getAwbGainsAlt(mpz mpz, int[] iArr) {
        float[] fArr = new float[4];
        Rational[] rationalArr = (Rational[]) mpz.a(CaptureResult.SENSOR_NEUTRAL_COLOR_POINT);
        if (rationalArr != null) {
            fArr[0] = 1.0f / rationalArr[0].floatValue();
            fArr[1] = 1.0f;
            fArr[2] = 1.0f;
            fArr[3] = 1.0f / rationalArr[2].floatValue();
            return fArr;
        }
        Log.w(TAG, "CaptureResult missing COLOR_CORRECTION_GAINS.");
        Arrays.fill(fArr, 1.0f);
        return fArr;
    }

    private static float[] getAwbRgb2Rgb(mpz mpz) {
        ColorSpaceTransform colorSpaceTransform = (ColorSpaceTransform) mpz.a(CaptureResult.COLOR_CORRECTION_TRANSFORM);
        if (colorSpaceTransform != null)
            return convertToFloatArray(colorSpaceTransform);

        Log.w(TAG, "CaptureResult missing COLOR_CORRECTION_TRANSFORM.");
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    private static int[] getEvenOddSourceIndicesForCfa(int cfa) {
        switch (cfa) {
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_RGGB:
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GRBG:
                return new int[]{0, 1 ,2 ,3};

            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_GBRG:
            case CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT_BGGR:
                return new int[]{0, 2, 1, 3};
            default:
                throw new IllegalArgumentException("CameraCharacteristics: unsupported colorFilterArrangment");
        }
    }

    public static float getExposureTimeMs(mpz result) {
        return nsToMsFloat((long) result.a(CaptureResult.SENSOR_EXPOSURE_TIME));
    }

    public static mnh getGcamRawFormat(mmb characteristics) {
        List<lyw> RAW10 = characteristics.a(ImageFormat.RAW10);
        List<lyw> RAW_SENSOR = characteristics.a(ImageFormat.RAW_SENSOR);
        List<lyw> YUV_420_888 = characteristics.a(ImageFormat.YUV_420_888);
        if (!RAW10.isEmpty())
            return new mnh(ImageFormat.RAW10, lyx.a(RAW10));
        if (!RAW_SENSOR.isEmpty())
            return new mnh(ImageFormat.RAW_SENSOR, lyx.a(RAW_SENSOR));
        if (!YUV_420_888.isEmpty())
            return new mnh(ImageFormat.YUV_420_888, lyx.a(YUV_420_888));
        throw new IllegalArgumentException("No HDR+ compatible raw format supported.");
    }

    private static int getGcamSensorId(mmb characteristics) {
        mmt facing = characteristics.b();
        List<Float> focalLengths = characteristics.D();
        boolean hasAux = characteristics.y() || focalLengths.size() > 1;
        if (facing != mmt.b) {
            if (hasAux)
                return 3;
            if (focalLengths.size() != 1 || focalLengths.get(0).doubleValue() >= 2.1d) {
                if (focalLengths.size() != 1 || focalLengths.get(0).doubleValue() <= 4.3d)
                    return 1;
                else
                    return 6;
            } else
                return 2;
        } else if (!hasAux) {
            if (focalLengths.size() != 1 || focalLengths.get(0).doubleValue() <= 5.0d)
                return 0;
            else
                return 4;
        } else
            return 5;
    }

    public static int getImageRotation(int i) {
        switch (i) {
            case 0: return 3;
            case 90: return 0;
            case 180: return 1;
            case 270: return 2;
            default:
                throw new IllegalArgumentException("Rotation must be one of {0, 90, 180, 270}.");
        }
    }

    private static Optional<OisMetadata> getOisMetadata(mpz result) {
        return oisMetadataFromCamera2(result);
    }

    private static OisMetadata getOisMetadataFromRawShifts(long j, long[] jArr, int[] iArr, int[] iArr2) {
        OisMetadata oisMetadata = new OisMetadata();
        oisMetadata.setTimestamp_ois_clock_ns(j);
        OisPositionVector ois_positions = oisMetadata.getOis_positions();
        for (int i = 0; i < jArr.length; i++) {
            OisPosition oisPosition = new OisPosition();
            oisPosition.setTimestamp_ns(jArr[i]);
            oisPosition.setShift_pixel_x(((float) iArr[i]) * -OIS_RAW_2_PIXEL_X_COEFF);
            oisPosition.setShift_pixel_y(((float) iArr2[i]) * -OIS_RAW_2_PIXEL_Y_COEFF);
            ois_positions.add(oisPosition);
        }
        return oisMetadata;
    }

    private static QcColorCalibration getQcColorCalibration() {
        float[] fArr;
        float[] fArr2;
        try {
            if (FixBSG.sCam != 0) {
                fArr2 = new float[]{
                        0.4789849f, 0.442842f, 0.88774407f, 0.64594114f, 0.58401686f, 1.1131755f, 0.55829304f, 0.64594114f,
                        0.5381625f, 0.4789849f, 0.96712637f, 0.8674805f, 0.4789849f, 0.4789849f, 0.64594114f, 0.64594114f
                };
                fArr = new float[]{
                        0.6864161f, 0.76931924f, 0.34084547f, 0.44676545f, 0.3976252f, 0.26975086f, 0.55698436f, 0.44676545f,
                        0.5921095f, 0.6864161f, 0.25033233f, 0.34084547f, 0.6864161f, 0.6864161f, 0.44676545f, 0.44676545f
                };
            } else {
                fArr2 = new float[]{
                        0.45419505f, 0.4423781f, 0.8008711f, 0.59523225f, 0.55316937f, 1.0265143f, 0.5231485f, 0.59523225f,
                        0.5231485f, 0.45419505f, 0.8008711f, 0.7823376f, 0.45419505f, 0.45419505f, 0.59523225f, 0.59523225f
                };
                fArr = new float[]{
                        0.72146124f, 0.7592262f, 0.3752295f, 0.45897773f, 0.44465324f, 0.28412443f, 0.5940661f, 0.45897773f,
                        0.5940661f, 0.72146124f, 0.3752295f, 0.3747195f, 0.72146124f, 0.72146124f, 0.45897773f, 0.45897773f
                };
            }
            QcIlluminantVector qcIlluminantVector = new QcIlluminantVector();
            for (int i = 0; i < 16; i++) {
                QcColorCalibration.IlluminantData illuminantData = new QcColorCalibration.IlluminantData();
                illuminantData.setRg_ratio(fArr2[i]);
                illuminantData.setBg_ratio(fArr[i]);
                qcIlluminantVector.add(illuminantData);
            }
            QcColorCalibration qcColorCalibration = new QcColorCalibration();
            qcColorCalibration.setIlluminant_data(qcIlluminantVector);
            qcColorCalibration.setGrgb_ratio(FixBSG.sCam != 0 ? 1.0019569f : 1.00098f);
            Log.v(TAG, "PIXEL_TWO_AWB worked");
            return qcColorCalibration;
        } catch (Throwable unused) {
            Log.w(TAG, "PIXEL_TWO_AWB didn't work");
            return new QcColorCalibration();
        }
    }

    public static long getReadoutTimeNs(mmb characteristics) {
        mnh gcamRawFormat = getGcamRawFormat(characteristics);
        return characteristics.a(gcamRawFormat.a, gcamRawFormat.b);
    }

    public static int[] getRedBlueSourceIndicesForCfa(int cfa) {
        return getEvenOddSourceIndicesForCfa(cfa);
    }

    private static boolean isProbablyUsingAntibanding(float f, float f2) {
        if (f < -ANTIBANDING_EXPOSURE_TIME_TOLERANCE_MS + f2)
            return false;
        float f3 = f / f2;
        return Math.abs(f3 - Math.round(f3)) * f2 < ANTIBANDING_EXPOSURE_TIME_TOLERANCE_MS;
    }

    private static long msFloatToNs(float milliseconds) {
        return (long) (milliseconds * 1000000);
    }

    private static float nsToMsFloat(long nanoseconds) {
        return nanoseconds / 1000000.0f;
    }

    private static Optional<OisMetadata> oisMetadataFromCamera2(mpz result) {
        Integer num = (Integer) result.a(CaptureResult.STATISTICS_OIS_DATA_MODE);
        if (num == null || num == 0)
            return Optional.empty();
        Long l = (Long) result.a(CaptureResult.SENSOR_TIMESTAMP);
        OisSample[] oisSampleArr = (OisSample[]) result.a(CaptureResult.STATISTICS_OIS_SAMPLES);
        if (l == null || oisSampleArr == null)
            return Optional.empty();
        OisMetadata oisMetadata = new OisMetadata();
        oisMetadata.setTimestamp_ois_clock_ns(l);
        OisPositionVector ois_positions = oisMetadata.getOis_positions();
        for (OisSample oisSample : oisSampleArr) {
            OisPosition oisPosition = new OisPosition();
            oisPosition.setTimestamp_ns(oisSample.getTimestamp());
            oisPosition.setShift_pixel_x(oisSample.getXshift());
            oisPosition.setShift_pixel_y(oisSample.getYshift());
            ois_positions.add(oisPosition);
        }
        return Optional.of(oisMetadata);
    }

    /*private static Optional oisMetadataFromExperimental(mpz mpz) {
        int length;
        int length2;
        if (kvf.h == null || kvf.i == null) {
            return Optional.empty();
        }
        Long l = (Long) mpz.a(kvf.h);
        long[] jArr = (long[]) mpz.a(kvf.i);
        if (l == null || jArr == null) {
            return Optional.empty();
        }
        if (kvf.l != null && kvf.m != null) {
            float[] fArr = (float[]) mpz.a(kvf.l);
            float[] fArr2 = (float[]) mpz.a(kvf.m);
            if (fArr != null && fArr2 != null && fArr.length == (length2 = jArr.length) && fArr2.length == length2) {
                return Optional.of(oisMetadataFromPixelShifts(l.longValue(), jArr, fArr, fArr2));
            }
        } else if (!(kvf.j == null || kvf.k == null)) {
            int[] iArr = (int[]) mpz.a(kvf.j);
            int[] iArr2 = (int[]) mpz.a(kvf.k);
            if (iArr != null && iArr2 != null && iArr.length == (length = jArr.length) && iArr2.length == length) {
                return Optional.of(getOisMetadataFromRawShifts(l.longValue(), jArr, iArr, iArr2));
            }
        }
        return Optional.empty();
    }*/

    private static OisMetadata oisMetadataFromPixelShifts(long j, long[] jArr, float[] fArr, float[] fArr2) {
        OisMetadata oisMetadata = new OisMetadata();
        oisMetadata.setTimestamp_ois_clock_ns(j);
        OisPositionVector ois_positions = oisMetadata.getOis_positions();
        for (int i = 0; i < jArr.length; i++) {
            OisPosition oisPosition = new OisPosition();
            oisPosition.setTimestamp_ns(jArr[i]);
            oisPosition.setShift_pixel_x(fArr[i]);
            oisPosition.setShift_pixel_y(fArr2[i]);
            ois_positions.add(oisPosition);
        }
        return oisMetadata;
    }

    private static boolean setChoiseAwbGains() {
        return (Build.DEVICE.equals("dipper") ||
                Build.DEVICE.equals("perseus") ||
                Build.DEVICE.equals("beryllium") ||
                Build.DEVICE.equals("polaris") ||
                Build.DEVICE.equals("equuleus") ||
                Build.DEVICE.equals("ursa") ||
                Build.DEVICE.equals("grus") ||
                Build.DEVICE.equals("violet") ||
                Build.DEVICE.equals("sirius"));
    }

    public static void updateFaceInfo(mmb characteristics, ExtendedFaces extendedFaces, FaceInfoVector faceInfoVector) {
        int landmarkCount;
        var preCorrectionActiveArrSize = (Rect) characteristics.b(CameraCharacteristics.SENSOR_INFO_PRE_CORRECTION_ACTIVE_ARRAY_SIZE);
        int correctionWidth = preCorrectionActiveArrSize.width();
        int correctionHeight = preCorrectionActiveArrSize.height();
        var faces = extendedFaces.getFaces();
        if (faces != null) {
            int i2 = 0;
            for (int index = 0; index < faces.length; index++) {
                var face = faces[index];
                var faceBounds = face.getBounds();
                float exactCenterX = faceBounds.exactCenterX() / correctionWidth;
                float exactCenterY = faceBounds.exactCenterY() / correctionHeight;
                float boundsHalf = (faceBounds.width() + faceBounds.height()) / 2.0f;
                float size = correctionHeight > boundsHalf ? boundsHalf : boundsHalf / correctionHeight;
                float confidence = (face.getScore() - 1) / 99.0f;
                if (exactCenterX >= 0.0f && exactCenterX <= 1.0f &&
                    exactCenterY >= 0.0f && exactCenterY <= 1.0f &&
                    size >= 0.0f && size <= 1.0f &&
                    confidence >= 0.0f && confidence <= 1.0f) {

                    var faceInfo = new FaceInfo();
                    faceInfo.setPos_x(exactCenterX);
                    faceInfo.setPos_y(exactCenterY);
                    faceInfo.setSize(size);
                    faceInfo.setConfidence(confidence);

                    if (!extendedFaces.facesAvailable()) {
                        for (LandmarkIndex landmarkIndex : LandmarkIndex.values()) {
                            updateNormalizedLandmark(face, landmarkIndex, correctionWidth, correctionHeight, faceInfo);
                        }
                    } else {
                        float[] landmarkPoint = extendedFaces.getFaceLandmarkXy();
                        byte[] landmarkIds = extendedFaces.getFaceLandmarkIds();
                        int[] landmarkCounts = extendedFaces.getFaceLandmarkCounts();

                        if (landmarkPoint != null &&
                            landmarkIds != null &&
                            landmarkCounts != null) {

                            int index2 = 0;
                            while (true) {
                                landmarkCount = landmarkCounts[index];
                                if (index2 >= landmarkCount) break;
                                var landmark = new FaceInfo.Landmark();
                                int id = i2 + index2;
                                int pIndex = id * 2;
                                landmark.setX(landmarkPoint[pIndex] / correctionWidth);
                                landmark.setX(landmarkPoint[pIndex + 1] / correctionHeight);
                                faceInfo.getLandmarks().set(landmarkIds[id], landmark);
                                index2++;
                            }
                            i2 += landmarkCount;
                        }
                    }
                    faceInfoVector.add(faceInfo);
                }
                Log.w(TAG, String.format("Face data is bad: (%d, %d) - (%d, %d), score %d",
                        faceBounds.left, faceBounds.top, faceBounds.right, faceBounds.bottom, face.getScore()));
            }
        }
    }

    private static void updateNormalizedLandmark(Face face, LandmarkIndex landmarkIndex, int xPoint, int yPoint, FaceInfo faceInfo) {
        Point landmarkLocation = landmarkIndex.getLandmarkLocation(face);
        if (landmarkLocation != null) {
            FaceInfo.Landmark landmark = new FaceInfo.Landmark();
            landmark.setX((float) (landmarkLocation.x / xPoint));
            landmark.setY((float) (landmarkLocation.y / yPoint));
            faceInfo.getLandmarks().set(landmarkIndex.getIndex(), landmark);
        }
    }

    public void appendMeteringRectanglesAsGcamWeightedNormalizedRects(MeteringRectangle[] meteringRectangleArr, Rect rect, WeightedNormalizedRectVector weightedNormalizedRectVector) {
        WeightedNormalizedRect weightedNormalizedRect = new WeightedNormalizedRect();
        weightedNormalizedRect.setWeight(1.0f);
        weightedNormalizedRect.setRect(new NormalizedRect());
        weightedNormalizedRectVector.add(weightedNormalizedRect);
        if (meteringRectangleArr != null) {
            for (MeteringRectangle meteringRectangle : meteringRectangleArr) {
                if (meteringRectangle.getMeteringWeight() != 0) {
                    WeightedNormalizedRect weightedNormalizedRect2 = new WeightedNormalizedRect();
                    Rect rect2 = meteringRectangle.getRect();
                    float exactCenterX = rect2.exactCenterX();
                    float exactCenterY = rect2.exactCenterY();
                    float min = ((float) Math.min(rect.width(), rect.height())) * 0.06125f;
                    float clamp = MathUtils.clamp((exactCenterX - min) / ((float) preCorrectionActiveArraySize.width()), 0.0f, 1.0f);
                    float clamp2 = MathUtils.clamp((exactCenterY - min) / ((float) preCorrectionActiveArraySize.height()), 0.0f, 1.0f);
                    float clamp3 = MathUtils.clamp((exactCenterX + min) / ((float) preCorrectionActiveArraySize.width()), 0.0f, 1.0f);
                    float clamp4 = MathUtils.clamp((exactCenterY + min) / ((float) preCorrectionActiveArraySize.height()), 0.0f, 1.0f);
                    NormalizedRect rect3 = weightedNormalizedRect2.getRect();
                    rect3.setX0(clamp);
                    rect3.setY0(clamp2);
                    rect3.setX1(clamp3);
                    rect3.setY1(clamp4);
                    weightedNormalizedRect2.setWeight(GCAM_METERING_REGION_WEIGHT);
                    weightedNormalizedRectVector.add(weightedNormalizedRect2);
                }
            }
        }
    }

    public FrameMetadata convertToGcamFrameMetadata(mpz mpz) {
        return convertToGcamFrameMetadata(mpz, null, null);
    }

    public FrameMetadata convertToGcamFrameMetadata(mpz capture, Face[] faceArr, GyroSampleVector gyroSampleVector) {
        var frameMetadata = new FrameMetadata();
        frameMetadata.setSensor_id(getGcamSensorId(characteristics));
        float exposureTimeMs = getExposureTimeMs(capture);
        float[] analogAndDigitalGain = getAnalogAndDigitalGain(capture);
        float analogGain = analogAndDigitalGain[0];
        float digitalGain = analogAndDigitalGain[1];
        float rawDigitalGain = 1.0f;
        Integer rawDigitalGainVal = (Integer) capture.a(CaptureResult.CONTROL_POST_RAW_SENSITIVITY_BOOST);
        if (rawDigitalGainVal != null)
            rawDigitalGain = (float) (rawDigitalGainVal / CONTROL_POST_RAW_SENSITIVITY_BOOST_UNITY);

        if (FixBSG.sPhotoFrames != FixBSG.sPhotoFramesCount) {
            FixBSG.sGetActual_exposure_time_ms = exposureTimeMs;
            FixBSG.sGetActual_analog_gain = analogGain;
            FixBSG.sGetApplied_digital_gain = digitalGain;
            FixBSG.sGetPost_raw_digital_gain = rawDigitalGain;
        }
        float actualExposureTimeMs = FixBSG.sGetActual_exposure_time_ms;
        float actualAnalogGain = FixBSG.sGetActual_analog_gain;
        float appliedDigitalGain = FixBSG.sGetApplied_digital_gain;
        float postRawDigitalGain = FixBSG.sGetPost_raw_digital_gain;
        frameMetadata.setActual_exposure_time_ms(actualExposureTimeMs);
        frameMetadata.setActual_analog_gain(actualAnalogGain);
        frameMetadata.setApplied_digital_gain(appliedDigitalGain);
        frameMetadata.setPost_raw_digital_gain(postRawDigitalGain);
        Log.e("setActual_exposure_time_ms", String.valueOf(actualExposureTimeMs));
        Log.e("setActual_analog_gain", String.valueOf(actualAnalogGain));
        Log.e("setApplied_digital_gain", String.valueOf(appliedDigitalGain));
        Log.e("setPost_raw_digital_gain", String.valueOf(postRawDigitalGain));
        FixBSG.sPhotoFrames++;
        int flashMode = (Integer) capture.a(CaptureResult.FLASH_MODE);
        if (flashMode == CaptureResult.FLASH_MODE_SINGLE || flashMode == CaptureResult.FLASH_MODE_TORCH)
            frameMetadata.setFlash(1);
        else
            frameMetadata.setFlash(0);
        frameMetadata.setSharpness(GCAM_CALCULATES_SHARPNESS);
        frameMetadata.setWb(getAwbInfoCaptured(capture));
        Rational[] rationalArr = (Rational[]) capture.a(CaptureResult.SENSOR_NEUTRAL_COLOR_POINT);
        frameMetadata.setNeutral_point(new float[]{rationalArr[0].floatValue(), rationalArr[1].floatValue(), rationalArr[2].floatValue()});
        Boolean bool = (Boolean) capture.a(CaptureResult.BLACK_LEVEL_LOCK);
        if (bool == null)
            bool = false;
        frameMetadata.setWas_black_level_locked(bool);
        frameMetadata.setTimestamp_ns((Long) capture.a(CaptureResult.SENSOR_TIMESTAMP));
        MetadataConverter.ExtendedFaces extendedFaces = new MetadataConverter.ExtendedFaces(capture);
        if (!extendedFaces.facesAvailable()) {
            extendedFaces = new MetadataConverter.ExtendedFaces(faceArr);
        }
        updateFaceInfo(characteristics, extendedFaces, frameMetadata.getFaces());
        frameMetadata.setSensor_temp(GcamModule.getKSensorTempUnknown());
        if (deviceProperties.d() || deviceProperties.e()) {
            float exposureTimeMs2 = getExposureTimeMs(capture);
            if (isProbablyUsingAntibanding(exposureTimeMs2, ANTIBANDING_60HZ_PERIOD_MS)) {
                frameMetadata.setScene_flicker(CameraMetadata.STATISTICS_SCENE_FLICKER_NONE);
            } else if (isProbablyUsingAntibanding(exposureTimeMs2, ANTIBANDING_50HZ_PERIOD_MS)) {
                frameMetadata.setScene_flicker(CameraMetadata.STATISTICS_SCENE_FLICKER_60HZ);
            } else {
                frameMetadata.setScene_flicker(CameraMetadata.STATISTICS_SCENE_FLICKER_50HZ);
            }
        } else {
            var sceneFlicker = (Integer) capture.a(CaptureResult.STATISTICS_SCENE_FLICKER);
            if (sceneFlicker != null) {
                switch (sceneFlicker) {
                    case 0: frameMetadata.setScene_flicker(CaptureResult.STATISTICS_SCENE_FLICKER_50HZ);
                    case 1: frameMetadata.setScene_flicker(CaptureResult.STATISTICS_SCENE_FLICKER_60HZ);
                    case 2: frameMetadata.setScene_flicker(CaptureResult.STATISTICS_SCENE_FLICKER_NONE);
                    default: Log.e(TAG, "Unexpected STATISTICS_SCENE_FLICKER type!");
                }
            }
        }
        var dngNoiseModelArr = new DngNoiseModel[4];
        var noiseModel = (Pair<Double, Double>[]) capture.a(CaptureResult.SENSOR_NOISE_PROFILE);
        for (int i = 0; i < 4; i++) {
            dngNoiseModelArr[i] = new DngNoiseModel();
            dngNoiseModelArr[i].setScale(noiseModel[i].first.floatValue());
            dngNoiseModelArr[i].setOffset(noiseModel[i].second.floatValue());
        }
        frameMetadata.setDng_noise_model_bayer(dngNoiseModelArr);

        if (!pCharacteristics.isExynos()) {

            float[] dynBl = (float[]) capture.a(CaptureResult.SENSOR_DYNAMIC_BLACK_LEVEL);
            if (dynBl == null) {
                var blackLevelPattern = (BlackLevelPattern) characteristics.a(CameraCharacteristics.SENSOR_BLACK_LEVEL_PATTERN);
                if (blackLevelPattern != null) {
                    float[] blPattern = new float[4];
                    for (int cfa = 0; cfa < 4; cfa++)
                        blPattern[cfa] = (float) blackLevelPattern.getOffsetForIndex(cfa % 2, cfa / 2);
                    frameMetadata.setBlack_levels_bayer(blPattern);
                }
            } else {
                frameMetadata.setBlack_levels_bayer(dynBl);
            }

        } else {

            if (pCharacteristics.isExynos9610() ||
                pCharacteristics.isExynos9611() ||
                pCharacteristics.isExynos9820() ||
                pCharacteristics.isExynos9825())
                frameMetadata.setBlack_levels_bayer(new float[]{0.0f, 0.0f, 0.0f, 0.0f});

            else // Fallback if it is Exynos
                frameMetadata.setBlack_levels_bayer(new float[]{64.0f, 64.0f, 64.0f, 64.0f});

        }
        var focusDistance = (Float) capture.a(CaptureResult.LENS_FOCUS_DISTANCE);
        var focusDistanceCalib = (Integer) characteristics.a(CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION);
        if (focusDistanceCalib == CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION_CALIBRATED ||
            focusDistanceCalib == CameraCharacteristics.LENS_INFO_FOCUS_DISTANCE_CALIBRATION_APPROXIMATE)
            frameMetadata.setFocus_distance_diopters(focusDistance);

        var focalLength = (Float) capture.a(CaptureResult.LENS_FOCAL_LENGTH);
        if (focalLength != null)
            frameMetadata.setFocal_length_mm(focalLength);

        var lensAperture = (Float) capture.a(CaptureResult.LENS_APERTURE);
        if (lensAperture != null)
            frameMetadata.setF_number(lensAperture);

        frameMetadata.setControl_mode((int) capture.a(CaptureResult.CONTROL_MODE));

        var aeMetadata = new AeMetadata();
        aeMetadata.setMode((int) capture.a(CaptureResult.CONTROL_AE_MODE));
        aeMetadata.setLock((boolean) capture.a(CaptureResult.CONTROL_AE_LOCK));
        aeMetadata.setState((int) capture.a(CaptureResult.CONTROL_AE_STATE));
        Integer preCaptureTrigger = (Integer) capture.a(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        if (preCaptureTrigger != null)
            aeMetadata.setPrecapture_trigger(preCaptureTrigger);

        aeMetadata.setExposure_compensation(getExposureCompensationStops((int) capture.a(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION) + 1));
        appendMeteringRectanglesAsGcamWeightedPixelRects((MeteringRectangle[]) capture.a(CaptureResult.CONTROL_AE_REGIONS),
                aeMetadata.getMetering_rectangles());
        frameMetadata.setAe(aeMetadata);

        var awbMetadata = new AwbMetadata();
        awbMetadata.setMode((int) capture.a(CaptureResult.CONTROL_AWB_MODE));
        awbMetadata.setLock((boolean) capture.a(CaptureResult.CONTROL_AWB_LOCK));
        awbMetadata.setState((int) capture.a(CaptureResult.CONTROL_AWB_STATE));
        appendMeteringRectanglesAsGcamWeightedPixelRects((MeteringRectangle[]) capture.a(CaptureResult.CONTROL_AWB_REGIONS),
                awbMetadata.getMetering_rectangles());
        frameMetadata.setAwb(awbMetadata);

        var afMetadata = new AfMetadata();
        afMetadata.setMode((int) capture.a(CaptureResult.CONTROL_AF_MODE));
        afMetadata.setState((int) capture.a(CaptureResult.CONTROL_AF_STATE));
        afMetadata.setTrigger((int) capture.a(CaptureResult.CONTROL_AF_TRIGGER));
        appendMeteringRectanglesAsGcamWeightedPixelRects((MeteringRectangle[]) capture.a(CaptureResult.CONTROL_AF_REGIONS),
                afMetadata.getMetering_rectangles());
        frameMetadata.setAf(afMetadata);

        var lensState = (Integer) capture.a(CaptureResult.LENS_STATE);
        if (lensState != null)
            frameMetadata.setLens_state(lensState);

        Optional<OisMetadata> oisMetadata = getOisMetadata(capture);
        frameMetadata.getClass();
        oisMetadata.ifPresent(frameMetadata::setOis_metadata);

        if (kvf.n != null)
            frameMetadata.setExposure_time_boost((Float) capture.a(kvf.n));
        if (gyroSampleVector != null)
            frameMetadata.setGyro_samples(gyroSampleVector);

        return frameMetadata;
    }

    public SpatialGainMap convertToSpatialGainMap(mpz mpz) {
        var lensShadingMap = (LensShadingMap) mpz.a(CaptureResult.STATISTICS_LENS_SHADING_CORRECTION_MAP);
        if (lensShadingMap == null) {
            Log.w(TAG, "android.statistics.lensShadingMap was null, returning the empty SpatialGainMap()");
            return new SpatialGainMap();
        } else {
            int columnCount = lensShadingMap.getColumnCount();
            int rowCount = lensShadingMap.getRowCount();
            var spatialGainMap2 = new SpatialGainMap(columnCount, rowCount, true, false);
            int[] evenOddSourceIndicesForCfa =
                    getEvenOddSourceIndicesForCfa((Integer) characteristics.b(CameraCharacteristics.SENSOR_INFO_COLOR_FILTER_ARRANGEMENT));
            for (int i4 = 0; i4 < 4; i4++) {
                int i5 = evenOddSourceIndicesForCfa[i4];
                for (int i6 = 0; i6 < rowCount; i6++) {
                    for (int i7 = 0; i7 < columnCount; i7++) {
                        spatialGainMap2.WriteRggb(i7, i6, i4, lensShadingMap.getGainFactor(i5, i7, i6));
                    }
                }
            }
            return spatialGainMap2;
        }
    }

    public AwbInfo getAwbInfoCaptured(mpz mpz) {
        var awbInfo = new AwbInfo();
        var iArr = evenOddIndexMap;
        awbInfo.setGains(!setChoiseAwbGains() ? getAwbGains(mpz, iArr) : getAwbGainsAlt(mpz, iArr));
        awbInfo.setRgb2rgb(getAwbRgb2Rgb(mpz));
        return awbInfo;
    }

    public float getExposureCompensationStops(int i) {
        Rational rational = (Rational) characteristics.b(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP);
        return new Rational(i * rational.getNumerator(), rational.getDenominator()).floatValue();
    }

    public float getTotalExposureTime(mpz capture) {
        float exposureTimeMs = nsToMsFloat((long) capture.a(CaptureResult.SENSOR_EXPOSURE_TIME));
        int sensitivity = (int) capture.a(CaptureResult.SENSOR_SENSITIVITY);
        return exposureTimeMs * (float) (sensitivity / minIso);
    }

    public void updateAeShotParams(AeShotParams aeShotParams, Rect rect, MeteringRectangle[] meteringRectangleArr, lyw lyw) {
        Rect a = lyb.a(lyw).a(rect);
        aeShotParams.setCrop(convertToNormalizedRect(a));
        appendMeteringRectanglesAsGcamWeightedNormalizedRects(meteringRectangleArr, a, aeShotParams.getWeighted_metering_areas());
    }

    public void updateFromFrameRequest(FrameRequest frameRequest, mcs mcs) {
        float desired_exposure_time_ms = frameRequest.getDesired_exposure_time_ms();
        float desired_analog_gain = frameRequest.getDesired_analog_gain();
        float desired_digital_gain = frameRequest.getDesired_digital_gain();
        mcs.a(CaptureRequest.CONTROL_MODE, 1);
        mcs.a(CaptureRequest.CONTROL_AE_MODE, 0);
        mcs.a(CaptureRequest.SENSOR_EXPOSURE_TIME, msFloatToNs(desired_exposure_time_ms));
        mcs.a(CaptureRequest.SENSOR_FRAME_DURATION, 0L);
        mcs.a(CaptureRequest.SENSOR_SENSITIVITY, desired_digital_gain * desired_analog_gain * minIso);
        mcs.a(CaptureRequest.BLACK_LEVEL_LOCK, frameRequest.getTry_to_lock_black_level());
        mcs.a(CaptureRequest.CONTROL_AWB_MODE, 0);
        mcs.a(CaptureRequest.COLOR_CORRECTION_MODE, 0);
        AwbInfo awb = frameRequest.getAwb();
        if (!awb.Check())
            Log.w(TAG, "updateFromFrameRequest - invalid AwbInfo");
        float[] gains = awb.getGains();
        int[] iArr = redBlueIndexMap;
        mcs.a(CaptureRequest.COLOR_CORRECTION_GAINS, new RggbChannelVector(gains[iArr[0]], gains[iArr[1]], gains[iArr[2]], gains[iArr[3]]));
        mcs.a(CaptureRequest.COLOR_CORRECTION_TRANSFORM, convertToColorSpaceTransform(awb.getRgb2rgb()));
        mcs.a(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, 1);
        mcs.a(CaptureRequest.STATISTICS_OIS_DATA_MODE, 1);
        mcs.a(CaptureRequest.STATISTICS_FACE_DETECT_MODE, faceDetectMode);
        mcs.a(CaptureRequest.EDGE_MODE, 0);
        mcs.a(CaptureRequest.NOISE_REDUCTION_MODE, 0);
    }
}