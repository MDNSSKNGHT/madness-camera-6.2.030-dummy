package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class TetAwbPair {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public TetAwbPair() {
        this(GcamModuleJNI.new_TetAwbPair__SWIG_0(), true);
    }

    public TetAwbPair(float f, AwbInfo awbInfo) {
        this(GcamModuleJNI.new_TetAwbPair__SWIG_1(f, AwbInfo.getCPtr(awbInfo), awbInfo), true);
    }

    protected TetAwbPair(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public TetAwbPair(TetAwbPair tetAwbPair) {
        this(GcamModuleJNI.new_TetAwbPair__SWIG_2(getCPtr(tetAwbPair), tetAwbPair), true);
    }

    protected static long getCPtr(TetAwbPair tetAwbPair) {
        if (tetAwbPair == null) {
            return 0;
        }
        return tetAwbPair.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_TetAwbPair(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public float getFirst() {
        return GcamModuleJNI.TetAwbPair_first_get(this.swigCPtr, this);
    }

    public AwbInfo getSecond() {
        long TetAwbPair_second_get = GcamModuleJNI.TetAwbPair_second_get(this.swigCPtr, this);
        if (TetAwbPair_second_get != 0) {
            return new AwbInfo(TetAwbPair_second_get, false);
        }
        return null;
    }

    public void setFirst(float f) {
        GcamModuleJNI.TetAwbPair_first_set(this.swigCPtr, this, f);
    }

    public void setSecond(AwbInfo awbInfo) {
        GcamModuleJNI.TetAwbPair_second_set(this.swigCPtr, this, AwbInfo.getCPtr(awbInfo), awbInfo);
    }
}
