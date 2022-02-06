package com.google.googlex.gcam;

import android.graphics.Bitmap;
import android.hardware.HardwareBuffer;
import android.view.Surface;

/* compiled from: PG */
/* loaded from: classes.dex */
public final class AndroidJniUtils {
    static {
        GcamSwigLoader.initialize();
        System.loadLibrary("AndroidJniUtilsJni");
    }

    private AndroidJniUtils() {
    }

    public static native long getAHardwareBufferPtr(HardwareBuffer hardwareBuffer);

    public static void initialize() {
    }

    static native long lockBitmap(Bitmap bitmap);

    static native long lockSurface(Surface surface);

    static native void unlockBitmap(Bitmap bitmap);

    static native void unlockSurface(long j);
}
