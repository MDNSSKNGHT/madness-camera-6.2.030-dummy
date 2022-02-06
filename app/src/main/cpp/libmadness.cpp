#include "libmadness.hpp"

extern "C" JNIEXPORT jobject JNICALL
Java_com_google_googlex_gcam_hdrplus_MetadataConverter_convertToSpatialGainMapPatch(JNIEnv *env, jobject obj) {

    jclass spatialGainMapClass = env->FindClass("com/google/googlex/gcam/SpatialGainMap");
    jobject spatialGainMapObj = env->NewObject(spatialGainMapClass,
                                               env->GetMethodID(spatialGainMapClass, "<init>", "(IIZZ)V"),
                                               17, 13, true, false);

    for (int cfa = 0; cfa < 4; ++cfa)
        for (int row = 0; row < 13; ++row)
            for (int column = 0; column < 17; ++column)
                env->CallVoidMethod(spatialGainMapObj,
                                    env->GetMethodID(spatialGainMapClass, "WriteRggb", "(IIIF)V"),
                                    column, row, cfa, S21U_ISO120[cfa][row][column]);

    return spatialGainMapObj;
}