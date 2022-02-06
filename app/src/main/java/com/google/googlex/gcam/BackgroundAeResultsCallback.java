package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class BackgroundAeResultsCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public BackgroundAeResultsCallback() {
        this(GcamModuleJNI.new_BackgroundAeResultsCallback(), true);
        GcamModuleJNI.BackgroundAeResultsCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected BackgroundAeResultsCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BackgroundAeResultsCallback backgroundAeResultsCallback) {
        if (backgroundAeResultsCallback == null) {
            return 0;
        }
        return backgroundAeResultsCallback.swigCPtr;
    }

    public void Run(AeResults aeResults) {
        GcamModuleJNI.BackgroundAeResultsCallback_Run(this.swigCPtr, this, AeResults.getCPtr(aeResults), aeResults);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_BackgroundAeResultsCallback(j);
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
        GcamModuleJNI.BackgroundAeResultsCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.BackgroundAeResultsCallback_change_ownership(this, this.swigCPtr, true);
    }
}
