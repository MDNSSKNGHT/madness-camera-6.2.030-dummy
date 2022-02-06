package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class BaseFrameCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public BaseFrameCallback() {
        this(GcamModuleJNI.new_BaseFrameCallback(), true);
        GcamModuleJNI.BaseFrameCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected BaseFrameCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BaseFrameCallback baseFrameCallback) {
        if (baseFrameCallback == null) {
            return 0;
        }
        return baseFrameCallback.swigCPtr;
    }

    public void Run(int i, int i2, long j) {
        GcamModuleJNI.BaseFrameCallback_Run(this.swigCPtr, this, i, i2, j);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_BaseFrameCallback(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GcamModuleJNI.BaseFrameCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.BaseFrameCallback_change_ownership(this, this.swigCPtr, true);
    }
}
