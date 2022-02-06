package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class AeResults {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public AeResults() {
        this(GcamModuleJNI.new_AeResults__SWIG_0(), true);
    }

    protected AeResults(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public AeResults(AeResults aeResults) {
        this(GcamModuleJNI.new_AeResults__SWIG_1(getCPtr(aeResults), aeResults), true);
    }

    protected static long getCPtr(AeResults aeResults) {
        if (aeResults == null) {
            return 0;
        }
        return aeResults.swigCPtr;
    }

    public float FinalHdrRatio() {
        return GcamModuleJNI.AeResults_FinalHdrRatio(this.swigCPtr, this);
    }

    public float GetDesiredFinalTet() {
        return GcamModuleJNI.AeResults_GetDesiredFinalTet(this.swigCPtr, this);
    }

    public float IdealHdrRatio() {
        return GcamModuleJNI.AeResults_IdealHdrRatio(this.swigCPtr, this);
    }

    public float LogSceneBrightness() {
        return GcamModuleJNI.AeResults_LogSceneBrightness(this.swigCPtr, this);
    }

    public int MeteringFrameCount() {
        return GcamModuleJNI.AeResults_MeteringFrameCount(this.swigCPtr, this);
    }

    public boolean MotionValid() {
        return GcamModuleJNI.AeResults_MotionValid(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_AeResults(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public AeDebugInfo getDebug() {
        long AeResults_debug_get = GcamModuleJNI.AeResults_debug_get(this.swigCPtr, this);
        if (AeResults_debug_get != 0) {
            return new AeDebugInfo(AeResults_debug_get, false);
        }
        return null;
    }

    public float[] getFinal_tet() {
        return GcamModuleJNI.AeResults_final_tet_get(this.swigCPtr, this);
    }

    public int getFlash() {
        return GcamModuleJNI.AeResults_flash_get(this.swigCPtr, this);
    }

    public Int64Vector getMetering_frame_timestamps_ns() {
        long AeResults_metering_frame_timestamps_ns_get = GcamModuleJNI.AeResults_metering_frame_timestamps_ns_get(this.swigCPtr, this);
        if (AeResults_metering_frame_timestamps_ns_get != 0) {
            return new Int64Vector(AeResults_metering_frame_timestamps_ns_get, false);
        }
        return null;
    }

    public float getMotion_score() {
        return GcamModuleJNI.AeResults_motion_score_get(this.swigCPtr, this);
    }

    public float getPredicted_image_brightness() {
        return GcamModuleJNI.AeResults_predicted_image_brightness_get(this.swigCPtr, this);
    }

    public float getPure_fraction_of_pixels_from_long_exposure() {
        return GcamModuleJNI.AeResults_pure_fraction_of_pixels_from_long_exposure_get(this.swigCPtr, this);
    }

    public float getSafe_underexposure() {
        return GcamModuleJNI.AeResults_safe_underexposure_get(this.swigCPtr, this);
    }

    public int getScene_flicker() {
        return GcamModuleJNI.AeResults_scene_flicker_get(this.swigCPtr, this);
    }

    public boolean getValid() {
        return GcamModuleJNI.AeResults_valid_get(this.swigCPtr, this);
    }

    public AwbInfo getWb() {
        long AeResults_wb_get = GcamModuleJNI.AeResults_wb_get(this.swigCPtr, this);
        if (AeResults_wb_get != 0) {
            return new AwbInfo(AeResults_wb_get, false);
        }
        return null;
    }

    public float getWeighted_fraction_of_pixels_from_long_exposure() {
        return GcamModuleJNI.AeResults_weighted_fraction_of_pixels_from_long_exposure_get(this.swigCPtr, this);
    }

    public void setDebug(AeDebugInfo aeDebugInfo) {
        GcamModuleJNI.AeResults_debug_set(this.swigCPtr, this, AeDebugInfo.getCPtr(aeDebugInfo), aeDebugInfo);
    }

    public void setFinal_tet(float[] fArr) {
        GcamModuleJNI.AeResults_final_tet_set(this.swigCPtr, this, fArr);
    }

    public void setFlash(int i) {
        GcamModuleJNI.AeResults_flash_set(this.swigCPtr, this, i);
    }

    public void setMetering_frame_timestamps_ns(Int64Vector int64Vector) {
        GcamModuleJNI.AeResults_metering_frame_timestamps_ns_set(this.swigCPtr, this, Int64Vector.getCPtr(int64Vector), int64Vector);
    }

    public void setMotion_score(float f) {
        GcamModuleJNI.AeResults_motion_score_set(this.swigCPtr, this, f);
    }

    public void setPredicted_image_brightness(float f) {
        GcamModuleJNI.AeResults_predicted_image_brightness_set(this.swigCPtr, this, f);
    }

    public void setPure_fraction_of_pixels_from_long_exposure(float f) {
        GcamModuleJNI.AeResults_pure_fraction_of_pixels_from_long_exposure_set(this.swigCPtr, this, f);
    }

    public void setSafe_underexposure(float f) {
        GcamModuleJNI.AeResults_safe_underexposure_set(this.swigCPtr, this, f);
    }

    public void setScene_flicker(int i) {
        GcamModuleJNI.AeResults_scene_flicker_set(this.swigCPtr, this, i);
    }

    public void setValid(boolean z) {
        GcamModuleJNI.AeResults_valid_set(this.swigCPtr, this, z);
    }

    public void setWb(AwbInfo awbInfo) {
        GcamModuleJNI.AeResults_wb_set(this.swigCPtr, this, AwbInfo.getCPtr(awbInfo), awbInfo);
    }

    public void setWeighted_fraction_of_pixels_from_long_exposure(float f) {
        GcamModuleJNI.AeResults_weighted_fraction_of_pixels_from_long_exposure_set(this.swigCPtr, this, f);
    }
}
