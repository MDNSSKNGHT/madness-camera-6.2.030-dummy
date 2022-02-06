package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class AeMetadata {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public AeMetadata() {
        this(GcamModuleJNI.new_AeMetadata(), true);
    }

    protected AeMetadata(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(AeMetadata aeMetadata) {
        if (aeMetadata == null) {
            return 0;
        }
        return aeMetadata.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_AeMetadata(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public float getExposure_compensation() {
        return GcamModuleJNI.AeMetadata_exposure_compensation_get(this.swigCPtr, this);
    }

    public boolean getLock() {
        return GcamModuleJNI.AeMetadata_lock_get(this.swigCPtr, this);
    }

    public WeightedPixelRectVector getMetering_rectangles() {
        long AeMetadata_metering_rectangles_get = GcamModuleJNI.AeMetadata_metering_rectangles_get(this.swigCPtr, this);
        if (AeMetadata_metering_rectangles_get != 0) {
            return new WeightedPixelRectVector(AeMetadata_metering_rectangles_get, false);
        }
        return null;
    }

    public int getMode() {
        return GcamModuleJNI.AeMetadata_mode_get(this.swigCPtr, this);
    }

    public int getPrecapture_trigger() {
        return GcamModuleJNI.AeMetadata_precapture_trigger_get(this.swigCPtr, this);
    }

    public int getState() {
        return GcamModuleJNI.AeMetadata_state_get(this.swigCPtr, this);
    }

    public void setExposure_compensation(float f) {
        GcamModuleJNI.AeMetadata_exposure_compensation_set(this.swigCPtr, this, f);
    }

    public void setLock(boolean z) {
        GcamModuleJNI.AeMetadata_lock_set(this.swigCPtr, this, z);
    }

    public void setMetering_rectangles(WeightedPixelRectVector weightedPixelRectVector) {
        GcamModuleJNI.AeMetadata_metering_rectangles_set(this.swigCPtr, this, WeightedPixelRectVector.getCPtr(weightedPixelRectVector), weightedPixelRectVector);
    }

    public void setMode(int i) {
        GcamModuleJNI.AeMetadata_mode_set(this.swigCPtr, this, i);
    }

    public void setPrecapture_trigger(int i) {
        GcamModuleJNI.AeMetadata_precapture_trigger_set(this.swigCPtr, this, i);
    }

    public void setState(int i) {
        GcamModuleJNI.AeMetadata_state_set(this.swigCPtr, this, i);
    }
}
