package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class DetectHotPixelParams {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public DetectHotPixelParams() {
        this(GcamModuleJNI.new_DetectHotPixelParams(), true);
    }

    protected DetectHotPixelParams(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DetectHotPixelParams detectHotPixelParams) {
        if (detectHotPixelParams == null) {
            return 0;
        }
        return detectHotPixelParams.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_DetectHotPixelParams(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public float getThreshold_factor() {
        return GcamModuleJNI.DetectHotPixelParams_threshold_factor_get(this.swigCPtr, this);
    }

    public float getThreshold_offset() {
        return GcamModuleJNI.DetectHotPixelParams_threshold_offset_get(this.swigCPtr, this);
    }

    public void setThreshold_factor(float f) {
        GcamModuleJNI.DetectHotPixelParams_threshold_factor_set(this.swigCPtr, this, f);
    }

    public void setThreshold_offset(float f) {
        GcamModuleJNI.DetectHotPixelParams_threshold_offset_set(this.swigCPtr, this, f);
    }
}
