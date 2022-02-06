package com.google.googlex.gcam;

/* compiled from: PG */
/* loaded from: classes.dex */
public class GoudaRequest {
    public boolean swigCMemOwn;
    public long swigCPtr;

    public GoudaRequest() {
        this(GcamModuleJNI.new_GoudaRequest(), true);
    }

    protected GoudaRequest(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(GoudaRequest goudaRequest) {
        if (goudaRequest == null) {
            return 0;
        }
        return goudaRequest.swigCPtr;
    }

    public synchronized void delete() {
        long j = this.swigCPtr;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                GcamModuleJNI.delete_GoudaRequest(j);
            }
            this.swigCPtr = 0;
        }
    }

    protected void finalize() {
        delete();
    }

    public boolean getColorize_debug_images() {
        return GcamModuleJNI.GoudaRequest_colorize_debug_images_get(this.swigCPtr, this);
    }

    public int getDebug_images_verbosity() {
        return GcamModuleJNI.GoudaRequest_debug_images_verbosity_get(this.swigCPtr, this);
    }

    public int getDepth_blur_config() {
        return GcamModuleJNI.GoudaRequest_depth_blur_config_get(this.swigCPtr, this);
    }

    public int getDepth_blur_layers() {
        return GcamModuleJNI.GoudaRequest_depth_blur_layers_get(this.swigCPtr, this);
    }

    public boolean getEmbed_gdepth_metadata() {
        return GcamModuleJNI.GoudaRequest_embed_gdepth_metadata_get(this.swigCPtr, this);
    }

    public PixelRectVector getFaces() {
        long GoudaRequest_faces_get = GcamModuleJNI.GoudaRequest_faces_get(this.swigCPtr, this);
        if (GoudaRequest_faces_get != 0) {
            return new PixelRectVector(GoudaRequest_faces_get, false);
        }
        return null;
    }

    public FrameMetadata getFrame_metadata() {
        long GoudaRequest_frame_metadata_get = GcamModuleJNI.GoudaRequest_frame_metadata_get(this.swigCPtr, this);
        if (GoudaRequest_frame_metadata_get != 0) {
            return new FrameMetadata(GoudaRequest_frame_metadata_get, false);
        }
        return null;
    }

    public GoudaStaticMetadata getGouda_static_metadata() {
        long GoudaRequest_gouda_static_metadata_get = GcamModuleJNI.GoudaRequest_gouda_static_metadata_get(this.swigCPtr, this);
        if (GoudaRequest_gouda_static_metadata_get != 0) {
            return new GoudaStaticMetadata(GoudaRequest_gouda_static_metadata_get, false);
        }
        return null;
    }

    public long getId() {
        return GcamModuleJNI.GoudaRequest_id_get(this.swigCPtr, this);
    }

    public int getImage_rotation() {
        return GcamModuleJNI.GoudaRequest_image_rotation_get(this.swigCPtr, this);
    }

    public int getOutput_format_primary() {
        return GcamModuleJNI.GoudaRequest_output_format_primary_get(this.swigCPtr, this);
    }

    public int getOutput_height() {
        return GcamModuleJNI.GoudaRequest_output_height_get(this.swigCPtr, this);
    }

    public int getOutput_width() {
        return GcamModuleJNI.GoudaRequest_output_width_get(this.swigCPtr, this);
    }

    public int getPd_version() {
        return GcamModuleJNI.GoudaRequest_pd_version_get(this.swigCPtr, this);
    }

    public String getPortrait_raw_path() {
        return GcamModuleJNI.GoudaRequest_portrait_raw_path_get(this.swigCPtr, this);
    }

    public float getPost_resample_sharpening() {
        return GcamModuleJNI.GoudaRequest_post_resample_sharpening_get(this.swigCPtr, this);
    }

    public String getShot_prefix() {
        return GcamModuleJNI.GoudaRequest_shot_prefix_get(this.swigCPtr, this);
    }

    public StaticMetadata getStatic_metadata() {
        long GoudaRequest_static_metadata_get = GcamModuleJNI.GoudaRequest_static_metadata_get(this.swigCPtr, this);
        if (GoudaRequest_static_metadata_get != 0) {
            return new StaticMetadata(GoudaRequest_static_metadata_get, false);
        }
        return null;
    }

    public boolean getUse_internal_rectiface() {
        return GcamModuleJNI.GoudaRequest_use_internal_rectiface_get(this.swigCPtr, this);
    }

    public boolean getUse_learned_depth() {
        return GcamModuleJNI.GoudaRequest_use_learned_depth_get(this.swigCPtr, this);
    }

    public SWIGTYPE_p_wireless_android_camera__rectiface__RectifaceWarpfield getWarpfield() {
        long GoudaRequest_warpfield_get = GcamModuleJNI.GoudaRequest_warpfield_get(this.swigCPtr, this);
        if (GoudaRequest_warpfield_get != 0) {
            return new SWIGTYPE_p_wireless_android_camera__rectiface__RectifaceWarpfield(GoudaRequest_warpfield_get, false);
        }
        return null;
    }

    public void setColorize_debug_images(boolean z) {
        GcamModuleJNI.GoudaRequest_colorize_debug_images_set(this.swigCPtr, this, z);
    }

    public void setDebug_images_verbosity(int i) {
        GcamModuleJNI.GoudaRequest_debug_images_verbosity_set(this.swigCPtr, this, i);
    }

    public void setDepth_blur_config(int i) {
        GcamModuleJNI.GoudaRequest_depth_blur_config_set(this.swigCPtr, this, i);
    }

    public void setDepth_blur_layers(int i) {
        GcamModuleJNI.GoudaRequest_depth_blur_layers_set(this.swigCPtr, this, i);
    }

    public void setEmbed_gdepth_metadata(boolean z) {
        GcamModuleJNI.GoudaRequest_embed_gdepth_metadata_set(this.swigCPtr, this, z);
    }

    public void setFaces(PixelRectVector pixelRectVector) {
        GcamModuleJNI.GoudaRequest_faces_set(this.swigCPtr, this, PixelRectVector.getCPtr(pixelRectVector), pixelRectVector);
    }

    public void setFrame_metadata(FrameMetadata frameMetadata) {
        GcamModuleJNI.GoudaRequest_frame_metadata_set(this.swigCPtr, this, FrameMetadata.getCPtr(frameMetadata), frameMetadata);
    }

    public void setGouda_static_metadata(GoudaStaticMetadata goudaStaticMetadata) {
        GcamModuleJNI.GoudaRequest_gouda_static_metadata_set(this.swigCPtr, this, GoudaStaticMetadata.getCPtr(goudaStaticMetadata), goudaStaticMetadata);
    }

    public void setId(long j) {
        GcamModuleJNI.GoudaRequest_id_set(this.swigCPtr, this, j);
    }

    public void setImage_rotation(int i) {
        GcamModuleJNI.GoudaRequest_image_rotation_set(this.swigCPtr, this, i);
    }

    public void setOutput_format_primary(int i) {
        GcamModuleJNI.GoudaRequest_output_format_primary_set(this.swigCPtr, this, i);
    }

    public void setOutput_height(int i) {
        GcamModuleJNI.GoudaRequest_output_height_set(this.swigCPtr, this, i);
    }

    public void setOutput_width(int i) {
        GcamModuleJNI.GoudaRequest_output_width_set(this.swigCPtr, this, i);
    }

    public void setPd_version(int i) {
        GcamModuleJNI.GoudaRequest_pd_version_set(this.swigCPtr, this, i);
    }

    public void setPortrait_raw_path(String str) {
        GcamModuleJNI.GoudaRequest_portrait_raw_path_set(this.swigCPtr, this, str);
    }

    public void setPost_resample_sharpening(float f) {
        GcamModuleJNI.GoudaRequest_post_resample_sharpening_set(this.swigCPtr, this, f);
    }

    public void setShot_prefix(String str) {
        GcamModuleJNI.GoudaRequest_shot_prefix_set(this.swigCPtr, this, str);
    }

    public void setStatic_metadata(StaticMetadata staticMetadata) {
        GcamModuleJNI.GoudaRequest_static_metadata_set(this.swigCPtr, this, StaticMetadata.getCPtr(staticMetadata), staticMetadata);
    }

    public void setUse_internal_rectiface(boolean z) {
        GcamModuleJNI.GoudaRequest_use_internal_rectiface_set(this.swigCPtr, this, z);
    }

    public void setUse_learned_depth(boolean z) {
        GcamModuleJNI.GoudaRequest_use_learned_depth_set(this.swigCPtr, this, z);
    }

    public void setWarpfield(SWIGTYPE_p_wireless_android_camera__rectiface__RectifaceWarpfield sWIGTYPE_p_wireless_android_camera__rectiface__RectifaceWarpfield) {
        GcamModuleJNI.GoudaRequest_warpfield_set(this.swigCPtr, this, SWIGTYPE_p_wireless_android_camera__rectiface__RectifaceWarpfield.getCPtr(sWIGTYPE_p_wireless_android_camera__rectiface__RectifaceWarpfield));
    }
}
