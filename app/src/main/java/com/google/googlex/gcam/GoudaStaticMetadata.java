package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaStaticMetadata {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaStaticMetadata() {
        this(GcamModuleJNI.new_GoudaStaticMetadata(), true);
    }

    protected GoudaStaticMetadata(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaStaticMetadata goudaStaticMetadata) {
        if (goudaStaticMetadata == null) {
            return 0;
        }
        return goudaStaticMetadata.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaStaticMetadata(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public PdCalibrationDataVector getCalibration_landscape_left() {
        long GoudaStaticMetadata_calibration_landscape_left_get = GcamModuleJNI.GoudaStaticMetadata_calibration_landscape_left_get(this.swigCPtr, this);
        if (GoudaStaticMetadata_calibration_landscape_left_get != 0) {
            return new PdCalibrationDataVector(GoudaStaticMetadata_calibration_landscape_left_get, false);
        }
        return null;
    }

    public PdCalibrationDataVector getCalibration_landscape_right() {
        long GoudaStaticMetadata_calibration_landscape_right_get = GcamModuleJNI.GoudaStaticMetadata_calibration_landscape_right_get(this.swigCPtr, this);
        if (GoudaStaticMetadata_calibration_landscape_right_get != 0) {
            return new PdCalibrationDataVector(GoudaStaticMetadata_calibration_landscape_right_get, false);
        }
        return null;
    }

    public PdCalibrationDataVector getCalibration_portrait() {
        long GoudaStaticMetadata_calibration_portrait_get = GcamModuleJNI.GoudaStaticMetadata_calibration_portrait_get(this.swigCPtr, this);
        if (GoudaStaticMetadata_calibration_portrait_get != 0) {
            return new PdCalibrationDataVector(GoudaStaticMetadata_calibration_portrait_get, false);
        }
        return null;
    }

    public String getStereo_pipeline_config() {
        return GcamModuleJNI.GoudaStaticMetadata_stereo_pipeline_config_get(this.swigCPtr, this);
    }

    public void setCalibration_landscape_left(PdCalibrationDataVector pdCalibrationDataVector) {
        GcamModuleJNI.GoudaStaticMetadata_calibration_landscape_left_set(this.swigCPtr, this, PdCalibrationDataVector.getCPtr(pdCalibrationDataVector), pdCalibrationDataVector);
    }

    public void setCalibration_landscape_right(PdCalibrationDataVector pdCalibrationDataVector) {
        GcamModuleJNI.GoudaStaticMetadata_calibration_landscape_right_set(this.swigCPtr, this, PdCalibrationDataVector.getCPtr(pdCalibrationDataVector), pdCalibrationDataVector);
    }

    public void setCalibration_portrait(PdCalibrationDataVector pdCalibrationDataVector) {
        GcamModuleJNI.GoudaStaticMetadata_calibration_portrait_set(this.swigCPtr, this, PdCalibrationDataVector.getCPtr(pdCalibrationDataVector), pdCalibrationDataVector);
    }

    public void setStereo_pipeline_config(String str) {
        GcamModuleJNI.GoudaStaticMetadata_stereo_pipeline_config_set(this.swigCPtr, this, str);
    }
}
