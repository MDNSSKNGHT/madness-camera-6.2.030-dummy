package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class PdCalibrationDataVector {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public PdCalibrationDataVector() {
        this(GcamModuleJNI.new_PdCalibrationDataVector__SWIG_0(), true);
    }

    public PdCalibrationDataVector(long j) {
        this(GcamModuleJNI.new_PdCalibrationDataVector__SWIG_1(j), true);
    }

    protected PdCalibrationDataVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PdCalibrationDataVector pdCalibrationDataVector) {
        if (pdCalibrationDataVector == null) {
            return 0;
        }
        return pdCalibrationDataVector.swigCPtr;
    }

    public void add(PdCalibrationData pdCalibrationData) {
        GcamModuleJNI.PdCalibrationDataVector_add(this.swigCPtr, this, PdCalibrationData.getCPtr(pdCalibrationData), pdCalibrationData);
    }

    public long capacity() {
        return GcamModuleJNI.PdCalibrationDataVector_capacity(this.swigCPtr, this);
    }

    public void clear() {
        GcamModuleJNI.PdCalibrationDataVector_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_PdCalibrationDataVector(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public PdCalibrationData get(int i) {
        return new PdCalibrationData(GcamModuleJNI.PdCalibrationDataVector_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return GcamModuleJNI.PdCalibrationDataVector_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        GcamModuleJNI.PdCalibrationDataVector_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, PdCalibrationData pdCalibrationData) {
        GcamModuleJNI.PdCalibrationDataVector_set(this.swigCPtr, this, i, PdCalibrationData.getCPtr(pdCalibrationData), pdCalibrationData);
    }

    public long size() {
        return GcamModuleJNI.PdCalibrationDataVector_size(this.swigCPtr, this);
    }
}
