package com.google.googlex.gcam;

public class GcamSwigLoader {
    static {
        //PatcherSession.Initialize();
        System.loadLibrary("gcam_jni");
    }

    public static void initialize() {
    }
}
