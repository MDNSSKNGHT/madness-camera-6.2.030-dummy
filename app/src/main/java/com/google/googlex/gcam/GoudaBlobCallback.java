package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaBlobCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    protected GoudaBlobCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaBlobCallback goudaBlobCallback) {
        if (goudaBlobCallback == null) {
            return 0;
        }
        return goudaBlobCallback.swigCPtr;
    }

    public void BlobReady(long j, String str, String str2, String str3) {
        GcamModuleJNI.GoudaBlobCallback_BlobReady(this.swigCPtr, this, j, str, str2, str3);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaBlobCallback(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }
}
