package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class WeightedNormalizedRect {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public WeightedNormalizedRect() {
        this(GcamModuleJNI.new_WeightedNormalizedRect(), true);
    }

    protected WeightedNormalizedRect(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(WeightedNormalizedRect weightedNormalizedRect) {
        if (weightedNormalizedRect == null) {
            return 0;
        }
        return weightedNormalizedRect.swigCPtr;
    }

    public boolean DeserializeFromString(SWIGTYPE_p_p_char sWIGTYPE_p_p_char) {
        return GcamModuleJNI.WeightedNormalizedRect_DeserializeFromString(this.swigCPtr, this, SWIGTYPE_p_p_char.getCPtr(sWIGTYPE_p_p_char));
    }

    public boolean Equals(WeightedNormalizedRect weightedNormalizedRect) {
        return GcamModuleJNI.WeightedNormalizedRect_Equals(this.swigCPtr, this, getCPtr(weightedNormalizedRect), weightedNormalizedRect);
    }

    public void Print(int i, int i2) {
        GcamModuleJNI.WeightedNormalizedRect_Print(this.swigCPtr, this, i, i2);
    }

    public void SerializeToString(SWIGTYPE_p_std__string sWIGTYPE_p_std__string, int i) {
        GcamModuleJNI.WeightedNormalizedRect_SerializeToString(this.swigCPtr, this, SWIGTYPE_p_std__string.getCPtr(sWIGTYPE_p_std__string), i);
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_WeightedNormalizedRect(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public NormalizedRect getRect() {
        long WeightedNormalizedRect_rect_get = GcamModuleJNI.WeightedNormalizedRect_rect_get(this.swigCPtr, this);
        if (WeightedNormalizedRect_rect_get != 0) {
            return new NormalizedRect(WeightedNormalizedRect_rect_get, false);
        }
        return null;
    }

    public float getWeight() {
        return GcamModuleJNI.WeightedNormalizedRect_weight_get(this.swigCPtr, this);
    }

    public void setRect(NormalizedRect normalizedRect) {
        GcamModuleJNI.WeightedNormalizedRect_rect_set(this.swigCPtr, this, NormalizedRect.getCPtr(normalizedRect), normalizedRect);
    }

    public void setWeight(float f) {
        GcamModuleJNI.WeightedNormalizedRect_weight_set(this.swigCPtr, this, f);
    }
}
