package com.google.googlex.gcam.androidutils;

public class MathUtils {
    public static float clamp(float f, float f2, float f3) {
        return f >= f2 ? Math.min(f, f3) : f2;
    }

    public static int clamp(int i, int i2, int i3) {
        return i >= i2 ? Math.min(i, i3) : i2;
    }

    public static float divideToFloat(int i, int i2) {
        return ((float) i) / ((float) i2);
    }

    public static float linearRescaleRanges(float f, float f2, float f3, float f4, float f5) {
        return f4 + (((f - f2) / (f3 - f2)) * (f5 - f4));
    }

    public static int linearRescaleRangesAndRound(float f, float f2, float f3, float f4, float f5) {
        return (int) (f4 + (((f - f2) / (f3 - f2)) * (f5 - f4)) + 0.5f);
    }

    public static int mod(int i, int i2) {
        return ((i % i2) + i2) % i2;
    }

    public static int numBins(int i, int i2) {
        return (int) Math.ceil((double) (((float) i) / ((float) i2)));
    }

    public static int roundToInt(float f) {
        return (int) (f + 0.5f);
    }

    public static int unsignedShortAsInt(short s) {
        return (char) s;
    }
}