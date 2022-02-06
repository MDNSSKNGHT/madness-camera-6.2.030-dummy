package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaProgressCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaProgressCallback() {
        this(GcamModuleJNI.new_GoudaProgressCallback(), true);
        GcamModuleJNI.GoudaProgressCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected GoudaProgressCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaProgressCallback goudaProgressCallback) {
        if (goudaProgressCallback == null) {
            return 0;
        }
        return goudaProgressCallback.swigCPtr;
    }

    public void Run(long j, float f) {
        GcamModuleJNI.GoudaProgressCallback_Run(this.swigCPtr, this, j, f);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaProgressCallback(j);
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
        GcamModuleJNI.GoudaProgressCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.GoudaProgressCallback_change_ownership(this, this.swigCPtr, true);
    }
}
