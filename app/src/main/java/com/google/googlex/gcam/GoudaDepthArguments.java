package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaDepthArguments {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaDepthArguments() {
        this(GcamModuleJNI.new_GoudaDepthArguments(), true);
    }

    protected GoudaDepthArguments(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaDepthArguments goudaDepthArguments) {
        if (goudaDepthArguments == null) {
            return 0;
        }
        return goudaDepthArguments.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaDepthArguments(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public InterleavedReadViewU8 getFront_stereo_0() {
        long GoudaDepthArguments_front_stereo_0_get = GcamModuleJNI.GoudaDepthArguments_front_stereo_0_get(this.swigCPtr, this);
        if (GoudaDepthArguments_front_stereo_0_get != 0) {
            return new InterleavedReadViewU8(GoudaDepthArguments_front_stereo_0_get, false);
        }
        return null;
    }

    public InterleavedReadViewU8 getFront_stereo_1() {
        long GoudaDepthArguments_front_stereo_1_get = GcamModuleJNI.GoudaDepthArguments_front_stereo_1_get(this.swigCPtr, this);
        if (GoudaDepthArguments_front_stereo_1_get != 0) {
            return new InterleavedReadViewU8(GoudaDepthArguments_front_stereo_1_get, false);
        }
        return null;
    }

    public InterleavedReadViewU16 getPd_input() {
        long GoudaDepthArguments_pd_input_get = GcamModuleJNI.GoudaDepthArguments_pd_input_get(this.swigCPtr, this);
        if (GoudaDepthArguments_pd_input_get != 0) {
            return new InterleavedReadViewU16(GoudaDepthArguments_pd_input_get, false);
        }
        return null;
    }

    public void setFront_stereo_0(InterleavedReadViewU8 interleavedReadViewU8) {
        GcamModuleJNI.GoudaDepthArguments_front_stereo_0_set(this.swigCPtr, this, InterleavedReadViewU8.getCPtr(interleavedReadViewU8), interleavedReadViewU8);
    }

    public void setFront_stereo_1(InterleavedReadViewU8 interleavedReadViewU8) {
        GcamModuleJNI.GoudaDepthArguments_front_stereo_1_set(this.swigCPtr, this, InterleavedReadViewU8.getCPtr(interleavedReadViewU8), interleavedReadViewU8);
    }

    public void setPd_input(InterleavedReadViewU16 interleavedReadViewU16) {
        GcamModuleJNI.GoudaDepthArguments_pd_input_set(this.swigCPtr, this, InterleavedReadViewU16.getCPtr(interleavedReadViewU16), interleavedReadViewU16);
    }
}
