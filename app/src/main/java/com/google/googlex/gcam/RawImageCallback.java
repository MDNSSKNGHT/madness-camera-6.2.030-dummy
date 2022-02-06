package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class RawImageCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public RawImageCallback() {
        this(GcamModuleJNI.new_RawImageCallback(), true);
        GcamModuleJNI.RawImageCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
    }

    protected RawImageCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(RawImageCallback rawImageCallback) {
        if (rawImageCallback == null) {
            return 0;
        }
        return rawImageCallback.swigCPtr;
    }

    public void ImageReady(int i, ExifMetadata exifMetadata, RawImage rawImage) {
        GcamModuleJNI.RawImageCallback_ImageReady(this.swigCPtr, this, i, ExifMetadata.getCPtr(exifMetadata), exifMetadata, RawImage.getCPtr(rawImage), rawImage);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_RawImageCallback(j);
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
        GcamModuleJNI.RawImageCallback_change_ownership(this, this.swigCPtr, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        GcamModuleJNI.RawImageCallback_change_ownership(this, this.swigCPtr, true);
    }
}
