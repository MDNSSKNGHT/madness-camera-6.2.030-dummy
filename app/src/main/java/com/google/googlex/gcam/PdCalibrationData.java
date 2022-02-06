package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class PdCalibrationData {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public PdCalibrationData() {
        this(GcamModuleJNI.new_PdCalibrationData(), true);
    }

    protected PdCalibrationData(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PdCalibrationData pdCalibrationData) {
        if (pdCalibrationData == null) {
            return 0;
        }
        return pdCalibrationData.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_PdCalibrationData(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public float getDepth_to_disparity_offset() {
        return GcamModuleJNI.PdCalibrationData_depth_to_disparity_offset_get(this.swigCPtr, this);
    }

    public float getDepth_to_disparity_scale() {
        return GcamModuleJNI.PdCalibrationData_depth_to_disparity_scale_get(this.swigCPtr, this);
    }

    public float getEstimated_focus_distance_diopters() {
        return GcamModuleJNI.PdCalibrationData_estimated_focus_distance_diopters_get(this.swigCPtr, this);
    }

    public InterleavedImageF getPd_offset() {
        long PdCalibrationData_pd_offset_get = GcamModuleJNI.PdCalibrationData_pd_offset_get(this.swigCPtr, this);
        if (PdCalibrationData_pd_offset_get != 0) {
            return new InterleavedImageF(PdCalibrationData_pd_offset_get, false);
        }
        return null;
    }

    public InterleavedImageF getPd_scale() {
        long PdCalibrationData_pd_scale_get = GcamModuleJNI.PdCalibrationData_pd_scale_get(this.swigCPtr, this);
        if (PdCalibrationData_pd_scale_get != 0) {
            return new InterleavedImageF(PdCalibrationData_pd_scale_get, false);
        }
        return null;
    }

    public float getReported_focus_distance_diopters() {
        return GcamModuleJNI.PdCalibrationData_reported_focus_distance_diopters_get(this.swigCPtr, this);
    }

    public void setDepth_to_disparity_offset(float f) {
        GcamModuleJNI.PdCalibrationData_depth_to_disparity_offset_set(this.swigCPtr, this, f);
    }

    public void setDepth_to_disparity_scale(float f) {
        GcamModuleJNI.PdCalibrationData_depth_to_disparity_scale_set(this.swigCPtr, this, f);
    }

    public void setEstimated_focus_distance_diopters(float f) {
        GcamModuleJNI.PdCalibrationData_estimated_focus_distance_diopters_set(this.swigCPtr, this, f);
    }

    public void setPd_offset(InterleavedImageF interleavedImageF) {
        GcamModuleJNI.PdCalibrationData_pd_offset_set(this.swigCPtr, this, InterleavedImageF.getCPtr(interleavedImageF), interleavedImageF);
    }

    public void setPd_scale(InterleavedImageF interleavedImageF) {
        GcamModuleJNI.PdCalibrationData_pd_scale_set(this.swigCPtr, this, InterleavedImageF.getCPtr(interleavedImageF), interleavedImageF);
    }

    public void setReported_focus_distance_diopters(float f) {
        GcamModuleJNI.PdCalibrationData_reported_focus_distance_diopters_set(this.swigCPtr, this, f);
    }
}
