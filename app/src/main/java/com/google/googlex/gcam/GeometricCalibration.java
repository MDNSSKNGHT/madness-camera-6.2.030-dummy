package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GeometricCalibration {
    public boolean swigCMemOwn;
    public long swigCPtr;

    /* compiled from: PG */
    /* loaded from: classes.dex */
    public final class Quality {
        public static final int kHigh = 1;
        public static final int kStandard = 0;
    }

    public GeometricCalibration() {
        this(GcamModuleJNI.new_GeometricCalibration(), true);
    }

    protected GeometricCalibration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public static GeometricCalibration GetRandomGeometricCalibration() {
        return new GeometricCalibration(GcamModuleJNI.GeometricCalibration_GetRandomGeometricCalibration(), true);
    }

    public static int TextToGeometricCalibrationQuality(String str) {
        return GcamModuleJNI.GeometricCalibration_TextToGeometricCalibrationQuality(str);
    }

    public static String ToText(int i) {
        return GcamModuleJNI.GeometricCalibration_ToText(i);
    }

    protected static long getCPtr(GeometricCalibration geometricCalibration) {
        if (geometricCalibration == null) {
            return 0;
        }
        return geometricCalibration.swigCPtr;
    }

    public boolean Check() {
        return GcamModuleJNI.GeometricCalibration_Check(this.swigCPtr, this);
    }

    public boolean DeserializeFromString(SWIGTYPE_p_p_char sWIGTYPE_p_p_char) {
        return GcamModuleJNI.GeometricCalibration_DeserializeFromString(this.swigCPtr, this, SWIGTYPE_p_p_char.getCPtr(sWIGTYPE_p_p_char));
    }

    public boolean Equals(GeometricCalibration geometricCalibration) {
        return GcamModuleJNI.GeometricCalibration_Equals(this.swigCPtr, this, getCPtr(geometricCalibration), geometricCalibration);
    }

    public void SerializeToString(SWIGTYPE_p_std__string sWIGTYPE_p_std__string, int i) {
        GcamModuleJNI.GeometricCalibration_SerializeToString(this.swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(sWIGTYPE_p_std__string), i);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GeometricCalibration(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public int[] getActive_rectangle() {
        return GcamModuleJNI.GeometricCalibration_active_rectangle_get(this.swigCPtr, this);
    }

    public float[] getLens_distortion() {
        return GcamModuleJNI.GeometricCalibration_lens_distortion_get(this.swigCPtr, this);
    }

    public float[] getLens_distortion_extended() {
        return GcamModuleJNI.GeometricCalibration_lens_distortion_extended_get(this.swigCPtr, this);
    }

    public float[] getLens_intrinsic_calibration() {
        return GcamModuleJNI.GeometricCalibration_lens_intrinsic_calibration_get(this.swigCPtr, this);
    }

    public int getQuality() {
        return GcamModuleJNI.GeometricCalibration_quality_get(this.swigCPtr, this);
    }

    public int[] getValid_rectangle() {
        return GcamModuleJNI.GeometricCalibration_valid_rectangle_get(this.swigCPtr, this);
    }

    public void setActive_rectangle(int[] iArr) {
        GcamModuleJNI.GeometricCalibration_active_rectangle_set(this.swigCPtr, this, iArr);
    }

    public void setLens_distortion(float[] fArr) {
        GcamModuleJNI.GeometricCalibration_lens_distortion_set(this.swigCPtr, this, fArr);
    }

    public void setLens_distortion_extended(float[] fArr) {
        GcamModuleJNI.GeometricCalibration_lens_distortion_extended_set(this.swigCPtr, this, fArr);
    }

    public void setLens_intrinsic_calibration(float[] fArr) {
        GcamModuleJNI.GeometricCalibration_lens_intrinsic_calibration_set(this.swigCPtr, this, fArr);
    }

    public void setQuality(int i) {
        GcamModuleJNI.GeometricCalibration_quality_set(this.swigCPtr, this, i);
    }

    public void setValid_rectangle(int[] iArr) {
        GcamModuleJNI.GeometricCalibration_valid_rectangle_set(this.swigCPtr, this, iArr);
    }
}
