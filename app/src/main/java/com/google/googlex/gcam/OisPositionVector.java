package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class OisPositionVector {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public OisPositionVector() {
        this(GcamModuleJNI.new_OisPositionVector__SWIG_0(), true);
    }

    public OisPositionVector(long j) {
        this(GcamModuleJNI.new_OisPositionVector__SWIG_1(j), true);
    }

    protected OisPositionVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(OisPositionVector oisPositionVector) {
        if (oisPositionVector == null) {
            return 0;
        }
        return oisPositionVector.swigCPtr;
    }

    public void add(OisPosition oisPosition) {
        GcamModuleJNI.OisPositionVector_add(this.swigCPtr, this, OisPosition.getCPtr(oisPosition), oisPosition);
    }

    public long capacity() {
        return GcamModuleJNI.OisPositionVector_capacity(this.swigCPtr, this);
    }

    public void clear() {
        GcamModuleJNI.OisPositionVector_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_OisPositionVector(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public OisPosition get(int i) {
        return new OisPosition(GcamModuleJNI.OisPositionVector_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return GcamModuleJNI.OisPositionVector_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        GcamModuleJNI.OisPositionVector_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, OisPosition oisPosition) {
        GcamModuleJNI.OisPositionVector_set(this.swigCPtr, this, i, OisPosition.getCPtr(oisPosition), oisPosition);
    }

    public long size() {
        return GcamModuleJNI.OisPositionVector_size(this.swigCPtr, this);
    }
}
