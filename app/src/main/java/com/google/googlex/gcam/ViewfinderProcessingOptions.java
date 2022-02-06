package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class ViewfinderProcessingOptions {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public ViewfinderProcessingOptions() {
        this(GcamModuleJNI.new_ViewfinderProcessingOptions(), true);
    }

    protected ViewfinderProcessingOptions(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ViewfinderProcessingOptions viewfinderProcessingOptions) {
        if (viewfinderProcessingOptions == null) {
            return 0;
        }
        return viewfinderProcessingOptions.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_ViewfinderProcessingOptions(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public boolean getProcess_ae() {
        return GcamModuleJNI.ViewfinderProcessingOptions_process_ae_get(this.swigCPtr, this);
    }

    public boolean getProcess_motion() {
        return GcamModuleJNI.ViewfinderProcessingOptions_process_motion_get(this.swigCPtr, this);
    }

    public void setProcess_ae(boolean z) {
        GcamModuleJNI.ViewfinderProcessingOptions_process_ae_set(this.swigCPtr, this, z);
    }

    public void setProcess_motion(boolean z) {
        GcamModuleJNI.ViewfinderProcessingOptions_process_motion_set(this.swigCPtr, this, z);
    }
}
