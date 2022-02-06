package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public final class SwigHacks {
    private SwigHacks() {
    }

    public static long getNativePointer(AeShotParams aeShotParams) {
        return AeShotParams.getCPtr(aeShotParams);
    }

    public static long getNativePointer(ExifMetadata exifMetadata) {
        return ExifMetadata.getCPtr(exifMetadata);
    }

    public static long getNativePointer(FrameMetadata frameMetadata) {
        return FrameMetadata.getCPtr(frameMetadata);
    }

    public static long getNativePointer(Gcam gcam) {
        return Gcam.getCPtr(gcam);
    }

    public static long getNativePointer(GyroSampleVector gyroSampleVector) {
        return GyroSampleVector.getCPtr(gyroSampleVector);
    }

    public static long getNativePointer(InitParams initParams) {
        return InitParams.getCPtr(initParams);
    }

    public static long getNativePointer(InterleavedReadViewU16 interleavedReadViewU16) {
        return InterleavedReadViewU16.getCPtr(interleavedReadViewU16);
    }

    public static long getNativePointer(InterleavedReadViewU8 interleavedReadViewU8) {
        return InterleavedReadViewU8.getCPtr(interleavedReadViewU8);
    }

    public static long getNativePointer(InterleavedWriteViewF interleavedWriteViewF) {
        return InterleavedWriteViewF.getCPtr(interleavedWriteViewF);
    }

    public static long getNativePointer(InterleavedWriteViewU16 interleavedWriteViewU16) {
        return InterleavedWriteViewU16.getCPtr(interleavedWriteViewU16);
    }

    public static long getNativePointer(InterleavedWriteViewU8 interleavedWriteViewU8) {
        return InterleavedWriteViewU8.getCPtr(interleavedWriteViewU8);
    }

    public static long getNativePointer(NormalizedRect normalizedRect) {
        return NormalizedRect.getCPtr(normalizedRect);
    }

    public static long getNativePointer(RawWriteView rawWriteView) {
        return RawWriteView.getCPtr(rawWriteView);
    }

    public static long getNativePointer(SWIGTYPE_p_float sWIGTYPE_p_float) {
        return SWIGTYPE_p_float.getCPtr(sWIGTYPE_p_float);
    }

    public static long getNativePointer(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char) {
        return SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char);
    }

    public static long getNativePointer(SWIGTYPE_p_unsigned_short sWIGTYPE_p_unsigned_short) {
        return SWIGTYPE_p_unsigned_short.getCPtr(sWIGTYPE_p_unsigned_short);
    }

    public static long getNativePointer(ShotParams shotParams) {
        return ShotParams.getCPtr(shotParams);
    }

    public static long getNativePointer(SpatialGainMap spatialGainMap) {
        return SpatialGainMap.getCPtr(spatialGainMap);
    }

    public static long getNativePointer(StaticMetadata staticMetadata) {
        return StaticMetadata.getCPtr(staticMetadata);
    }

    public static long getNativePointer(Tuning tuning) {
        return Tuning.getCPtr(tuning);
    }

    public static long getNativePointer(YuvReadView yuvReadView) {
        return YuvReadView.getCPtr(yuvReadView);
    }

    public static long getNativePointer(YuvWriteView yuvWriteView) {
        return YuvWriteView.getCPtr(yuvWriteView);
    }

    public static SWIGTYPE_p_gcam__Context wrapNativePointerWithSwigContext(long j) {
        return new SWIGTYPE_p_gcam__Context(j, false);
    }

    public static SWIGTYPE_p_unsigned_char wrapNativePointerWithSwigUnsignedChar(long j) {
        return new SWIGTYPE_p_unsigned_char(j, false);
    }

    public static SWIGTYPE_p_unsigned_short wrapNativePointerWithSwigUnsignedShort(long j) {
        return new SWIGTYPE_p_unsigned_short(j, false);
    }

    public static YuvWriteView wrapNativePointerWithSwigYuvWriteView(long j, boolean z) {
        return new YuvWriteView(j, z);
    }
}
