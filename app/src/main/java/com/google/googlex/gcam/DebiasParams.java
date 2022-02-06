package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class DebiasParams {
    public boolean swigCMemOwn;
    public long swigCPtr;

    /* compiled from: PG */
    /* loaded from: classes.dex */
    public static class Point {
        public boolean swigCMemOwn;
        public long swigCPtr;

        public Point() {
            this(GcamModuleJNI.new_DebiasParams_Point(), true);
        }

        protected Point(long j, boolean z) {
            this.swigCMemOwn = z;
            this.swigCPtr = j;
        }

        protected static long getCPtr(Point point) {
            if (point == null) {
                return 0;
            }
            return point.swigCPtr;
        }

        public synchronized void delete() {
            long j = this.swigCPtr;
            if (j != 0) {
                if (this.swigCMemOwn) {
                    this.swigCMemOwn = false;
                    GcamModuleJNI.delete_DebiasParams_Point(j);
                }
                this.swigCPtr = 0;
            }
        }

        protected void finalize() {
            delete();
        }

        public float getX() {
            return GcamModuleJNI.DebiasParams_Point_x_get(this.swigCPtr, this);
        }

        public float getY() {
            return GcamModuleJNI.DebiasParams_Point_y_get(this.swigCPtr, this);
        }

        public void setX(float f) {
            GcamModuleJNI.DebiasParams_Point_x_set(this.swigCPtr, this, f);
        }

        public void setY(float f) {
            GcamModuleJNI.DebiasParams_Point_y_set(this.swigCPtr, this, f);
        }
    }

    public DebiasParams() {
        this(GcamModuleJNI.new_DebiasParams(), true);
    }

    protected DebiasParams(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(DebiasParams debiasParams) {
        if (debiasParams == null) {
            return 0;
        }
        return debiasParams.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_DebiasParams(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public SWIGTYPE_p_std__arrayT_gcam__DebiasParams__Point_5_t getCurves() {
        long DebiasParams_curves_get = GcamModuleJNI.DebiasParams_curves_get(this.swigCPtr, this);
        if (DebiasParams_curves_get != 0) {
            return new SWIGTYPE_p_std__arrayT_gcam__DebiasParams__Point_5_t(DebiasParams_curves_get, false);
        }
        return null;
    }

    public void setCurves(SWIGTYPE_p_std__arrayT_gcam__DebiasParams__Point_5_t sWIGTYPE_p_std__arrayT_gcam__DebiasParams__Point_5_t) {
        GcamModuleJNI.DebiasParams_curves_set(this.swigCPtr, this, SWIGTYPE_p_std__arrayT_gcam__DebiasParams__Point_5_t.getCPtr(sWIGTYPE_p_std__arrayT_gcam__DebiasParams__Point_5_t));
    }
}
