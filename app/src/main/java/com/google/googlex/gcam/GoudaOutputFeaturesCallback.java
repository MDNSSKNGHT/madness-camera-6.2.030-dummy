package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaOutputFeaturesCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    protected GoudaOutputFeaturesCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaOutputFeaturesCallback goudaOutputFeaturesCallback) {
        if (goudaOutputFeaturesCallback == null) {
            return 0;
        }
        return goudaOutputFeaturesCallback.swigCPtr;
    }

    public void AddFeature(long j, String str, double d) {
        GcamModuleJNI.GoudaOutputFeaturesCallback_AddFeature(this.swigCPtr, this, j, str, d);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaOutputFeaturesCallback(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }
}
