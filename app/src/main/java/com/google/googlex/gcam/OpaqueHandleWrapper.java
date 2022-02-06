package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class OpaqueHandleWrapper {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public OpaqueHandleWrapper() {
        this(GcamModuleJNI.new_OpaqueHandleWrapper__SWIG_0(), true);
    }

    public OpaqueHandleWrapper(long j) {
        this(GcamModuleJNI.new_OpaqueHandleWrapper__SWIG_1(j), true);
    }

    protected OpaqueHandleWrapper(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OpaqueHandleWrapper opaqueHandleWrapper) {
        if (opaqueHandleWrapper == null) {
            return 0;
        }
        return opaqueHandleWrapper.swigCPtr;
    }

    public boolean Empty() {
        return GcamModuleJNI.OpaqueHandleWrapper_Empty(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_OpaqueHandleWrapper(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public long getOpaque_handle() {
        return GcamModuleJNI.OpaqueHandleWrapper_opaque_handle_get(this.swigCPtr, this);
    }

    public void setOpaque_handle(long j) {
        GcamModuleJNI.OpaqueHandleWrapper_opaque_handle_set(this.swigCPtr, this, j);
    }
}
