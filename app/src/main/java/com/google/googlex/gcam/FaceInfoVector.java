package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class FaceInfoVector {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public FaceInfoVector() {
        this(GcamModuleJNI.new_FaceInfoVector__SWIG_0(), true);
    }

    public FaceInfoVector(long j) {
        this(GcamModuleJNI.new_FaceInfoVector__SWIG_1(j), true);
    }

    protected FaceInfoVector(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FaceInfoVector faceInfoVector) {
        if (faceInfoVector == null) {
            return 0;
        }
        return faceInfoVector.swigCPtr;
    }

    public void add(FaceInfo faceInfo) {
        GcamModuleJNI.FaceInfoVector_add(this.swigCPtr, this, FaceInfo.getCPtr(faceInfo), faceInfo);
    }

    public long capacity() {
        return GcamModuleJNI.FaceInfoVector_capacity(this.swigCPtr, this);
    }

    public void clear() {
        GcamModuleJNI.FaceInfoVector_clear(this.swigCPtr, this);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_FaceInfoVector(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public FaceInfo get(int i) {
        return new FaceInfo(GcamModuleJNI.FaceInfoVector_get(this.swigCPtr, this, i), false);
    }

    public boolean isEmpty() {
        return GcamModuleJNI.FaceInfoVector_isEmpty(this.swigCPtr, this);
    }

    public void reserve(long j) {
        GcamModuleJNI.FaceInfoVector_reserve(this.swigCPtr, this, j);
    }

    public void set(int i, FaceInfo faceInfo) {
        GcamModuleJNI.FaceInfoVector_set(this.swigCPtr, this, i, FaceInfo.getCPtr(faceInfo), faceInfo);
    }

    public long size() {
        return GcamModuleJNI.FaceInfoVector_size(this.swigCPtr, this);
    }
}
