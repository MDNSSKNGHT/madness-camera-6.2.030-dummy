package com.google.googlex.gcam;

import android.annotation.TargetApi;
import android.view.Surface;

/* compiled from: PG */
@TargetApi(19)
/* loaded from: classes.dex */
public class LockedSurface implements AutoCloseable {
    public long nativePointer;

    private LockedSurface(Surface surface) {
        //ohr.b(surface);
        this.nativePointer = AndroidJniUtils.lockSurface(surface);
        if (this.nativePointer == 0) {
            throw new IllegalArgumentException("Failed to lock Surface.");
        }
    }

    public static LockedSurface acquire(Surface surface) {
        return new LockedSurface(surface);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long j = this.nativePointer;
        if (j != 0) {
            AndroidJniUtils.unlockSurface(j);
            this.nativePointer = 0;
        }
    }

    public long nativePointer() {
        return this.nativePointer;
    }
}
