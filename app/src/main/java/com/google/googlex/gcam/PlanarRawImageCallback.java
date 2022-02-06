package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class PlanarRawImageCallback {
    public boolean swigCMemOwn;
    public long swigCPtr;

    protected PlanarRawImageCallback(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(PlanarRawImageCallback planarRawImageCallback) {
        if (planarRawImageCallback == null) {
            return 0;
        }
        return planarRawImageCallback.swigCPtr;
    }

    public void ImageReady(int i, ExifMetadata exifMetadata, SWIGTYPE_p_gcam__ReadWriteTImageViewT_unsigned_short_gcam__kChannelContiguous_t sWIGTYPE_p_gcam__ReadWriteTImageViewT_unsigned_short_gcam__kChannelContiguous_t) {
        GcamModuleJNI.PlanarRawImageCallback_ImageReady(this.swigCPtr, this, i, ExifMetadata.getCPtr(exifMetadata), exifMetadata, SWIGTYPE_p_gcam__ReadWriteTImageViewT_unsigned_short_gcam__kChannelContiguous_t.getCPtr(sWIGTYPE_p_gcam__ReadWriteTImageViewT_unsigned_short_gcam__kChannelContiguous_t));
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_PlanarRawImageCallback(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }
}
