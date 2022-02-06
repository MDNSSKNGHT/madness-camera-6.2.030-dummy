package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaSegmenterSwigWrapper {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaSegmenterSwigWrapper() {
        this(GcamModuleJNI.new_GoudaSegmenterSwigWrapper(), true);
    }

    protected GoudaSegmenterSwigWrapper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaSegmenterSwigWrapper goudaSegmenterSwigWrapper) {
        if (goudaSegmenterSwigWrapper == null) {
            return 0;
        }
        return goudaSegmenterSwigWrapper.swigCPtr;
    }

    public long GetSegmenterHandle() {
        return GcamModuleJNI.GoudaSegmenterSwigWrapper_GetSegmenterHandle(this.swigCPtr, this);
    }

    public boolean Init(long j, long j2, String str, boolean z, boolean z2, boolean z3) {
        return GcamModuleJNI.GoudaSegmenterSwigWrapper_Init(this.swigCPtr, this, j, j2, str, z, z2, z3);
    }

    public void Release() {
        GcamModuleJNI.GoudaSegmenterSwigWrapper_Release(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaSegmenterSwigWrapper(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }
}
