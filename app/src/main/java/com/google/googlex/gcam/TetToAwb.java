package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class TetToAwb {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public TetToAwb() {
        this(GcamModuleJNI.new_TetToAwb__SWIG_0(), true);
    }

    public TetToAwb(long j) {
        this(GcamModuleJNI.new_TetToAwb__SWIG_1(j), true);
    }

    protected TetToAwb(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(TetToAwb tetToAwb) {
        if (tetToAwb == null) {
            return 0;
        }
        return tetToAwb.swigCPtr;
    }

    public void add(TetAwbPair tetAwbPair) {
        GcamModuleJNI.TetToAwb_add(this.swigCPtr, this, TetAwbPair.getCPtr(tetAwbPair), tetAwbPair);
    }

    public long capacity() {
        return GcamModuleJNI.TetToAwb_capacity(this.swigCPtr, this);
    }

    public void clear() {
        GcamModuleJNI.TetToAwb_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_TetToAwb(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public TetAwbPair get(int i) {
        return new TetAwbPair(GcamModuleJNI.TetToAwb_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return GcamModuleJNI.TetToAwb_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        GcamModuleJNI.TetToAwb_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, TetAwbPair tetAwbPair) {
        GcamModuleJNI.TetToAwb_set(this.swigCPtr, this, i, TetAwbPair.getCPtr(tetAwbPair), tetAwbPair);
    }

    public long size() {
        return GcamModuleJNI.TetToAwb_size(this.swigCPtr, this);
    }
}
