package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class ClientExifMetadata {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public ClientExifMetadata() {
        this(GcamModuleJNI.new_ClientExifMetadata(), true);
    }

    protected ClientExifMetadata(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(ClientExifMetadata clientExifMetadata) {
        if (clientExifMetadata == null) {
            return 0;
        }
        return clientExifMetadata.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_ClientExifMetadata(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public LocationData getLocation() {
        long ClientExifMetadata_location_get = GcamModuleJNI.ClientExifMetadata_location_get(this.swigCPtr, this);
        if (ClientExifMetadata_location_get != 0) {
            return new LocationData(ClientExifMetadata_location_get, false);
        }
        return null;
    }

    public void setLocation(LocationData locationData) {
        GcamModuleJNI.ClientExifMetadata_location_set(this.swigCPtr, this, LocationData.getCPtr(locationData), locationData);
    }
}
