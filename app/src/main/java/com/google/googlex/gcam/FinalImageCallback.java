package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class FinalImageCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public FinalImageCallback() {
        this(GcamModuleJNI.new_FinalImageCallback(), true);
        GcamModuleJNI.FinalImageCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected FinalImageCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(FinalImageCallback finalImageCallback) {
        if (finalImageCallback == null) {
            return 0;
        }
        return finalImageCallback.swigCPtr;
    }

    public void RgbReady(int i, InterleavedReadViewU8 interleavedReadViewU8, ExifMetadata exifMetadata, int i2) {
        GcamModuleJNI.FinalImageCallback_RgbReady(this.swigCPtr, this, i, InterleavedReadViewU8.getCPtr(interleavedReadViewU8), interleavedReadViewU8, ExifMetadata.getCPtr(exifMetadata), exifMetadata, i2);
    }

    public void YuvReady(int i, YuvReadView yuvReadView, ExifMetadata exifMetadata, int i2) {
        GcamModuleJNI.FinalImageCallback_YuvReady(this.swigCPtr, this, i, YuvReadView.getCPtr(yuvReadView), yuvReadView, ExifMetadata.getCPtr(exifMetadata), exifMetadata, i2);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_FinalImageCallback(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    protected void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        GcamModuleJNI.FinalImageCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.FinalImageCallback_change_ownership(this, this.swigCPtr, true);
    }
}
