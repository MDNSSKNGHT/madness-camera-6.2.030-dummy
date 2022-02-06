package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class FrameMetadataKey {
    public boolean swigCMemOwn;
    public long swigCPtr;

    /* compiled from: PG */
    /* loaded from: classes.dex */
    public static class Hasher {
        public boolean swigCMemOwn;
        public long swigCPtr;

        public Hasher() {
            this(GcamModuleJNI.new_FrameMetadataKey_Hasher(), true);
        }

        protected Hasher(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        protected static long getCPtr(Hasher hasher) {
            if (hasher == null) {
                return 0;
            }
            return hasher.swigCPtr;
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    GcamModuleJNI.delete_FrameMetadataKey_Hasher(j);
                }
                this.swigCPtr = 0;
            }
        }

        protected void finalize() {
            delete();
        }
    }

    public FrameMetadataKey() {
        this(GcamModuleJNI.new_FrameMetadataKey__SWIG_2(), true);
    }

    public FrameMetadataKey(long j, int i) {
        this(GcamModuleJNI.new_FrameMetadataKey__SWIG_1(j, i), true);
    }

    protected FrameMetadataKey(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    public FrameMetadataKey(FrameMetadata frameMetadata) {
        this(GcamModuleJNI.new_FrameMetadataKey__SWIG_0(FrameMetadata.getCPtr(frameMetadata), frameMetadata), true);
    }

    public FrameMetadataKey(FrameMetadataKey frameMetadataKey) {
        this(GcamModuleJNI.new_FrameMetadataKey__SWIG_3(getCPtr(frameMetadataKey), frameMetadataKey), true);
    }

    protected static long getCPtr(FrameMetadataKey frameMetadataKey) {
        if (frameMetadataKey == null) {
            return 0;
        }
        return frameMetadataKey.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_FrameMetadataKey(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }
}
