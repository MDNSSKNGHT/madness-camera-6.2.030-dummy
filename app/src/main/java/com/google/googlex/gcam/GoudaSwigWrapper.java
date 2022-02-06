package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaSwigWrapper {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaSwigWrapper() {
        this(GcamModuleJNI.new_GoudaSwigWrapper(), true);
    }

    protected GoudaSwigWrapper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaSwigWrapper goudaSwigWrapper) {
        if (goudaSwigWrapper == null) {
            return 0;
        }
        return goudaSwigWrapper.swigCPtr;
    }

    public boolean Init(long j) {
        return GcamModuleJNI.GoudaSwigWrapper_Init(this.swigCPtr, this, j);
    }

    public boolean Process(long j, GoudaCallbacks goudaCallbacks, InterleavedReadViewU8 interleavedReadViewU8, GoudaDepthArguments goudaDepthArguments, long j2, GoudaRequest goudaRequest) {
        return GcamModuleJNI.GoudaSwigWrapper_Process(this.swigCPtr, this, j, GoudaCallbacks.getCPtr(goudaCallbacks), goudaCallbacks, InterleavedReadViewU8.getCPtr(interleavedReadViewU8), interleavedReadViewU8, GoudaDepthArguments.getCPtr(goudaDepthArguments), goudaDepthArguments, j2, GoudaRequest.getCPtr(goudaRequest), goudaRequest);
    }

    public void Release() {
        GcamModuleJNI.GoudaSwigWrapper_Release(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaSwigWrapper(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }
}
