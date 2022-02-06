package com.google.googlex.gcam;

import android.annotation.TargetApi;
import android.graphics.Bitmap;

/* compiled from: PG */
@TargetApi(19)
/* loaded from: classes.dex */
public class LockedBitmap implements AutoCloseable {
    public final Bitmap bitmap;
    public long nativePointer;
    public final InterleavedWriteViewU8 view;

    private LockedBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        //ohr.a(bitmap.getConfig().equals(Bitmap.Config.ARGB_8888), "Bitmap Config must be ARGB_8888", bitmap.getConfig());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int rowBytes = bitmap.getRowBytes() - (width << 2);
        int i = rowBytes / 4;
        //ohr.a(rowBytes % 4 == 0, "Bitmap's row padding in bytes (%s) must evenly divide the number of channels (%s)", rowBytes, 4);
        this.nativePointer = AndroidJniUtils.lockBitmap(bitmap);
        long j = this.nativePointer;
        if (j != 0) {
            this.view = new InterleavedWriteViewU8(width, height, 4, new SWIGTYPE_p_unsigned_char(j, false), (long) i);
            return;
        }
        throw new IllegalArgumentException("Failed to lock bitmap.");
    }

    public static LockedBitmap acquire(Bitmap bitmap) {
        return new LockedBitmap(bitmap);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.nativePointer != 0) {
            AndroidJniUtils.unlockBitmap(this.bitmap);
            this.nativePointer = 0;
        }
    }

    @Override // java.lang.Object
    protected void finalize() {
        close();
    }

    public InterleavedWriteViewU8 view() {
        return this.view;
    }
}
