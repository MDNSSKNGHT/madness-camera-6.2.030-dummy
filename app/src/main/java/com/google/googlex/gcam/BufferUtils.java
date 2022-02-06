package com.google.googlex.gcam;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import defpackage.ohr;

public final class BufferUtils {
    private BufferUtils() {
    }

    public static ByteBuffer byteBufferViewOfNativePointer(long j, int i) {
        boolean z = i > 0;
        ohr.a(j != 0, "ptr must not be 0.");
        ohr.a(z, "capacity must be positive, got: %s", i);
        return byteBufferViewOfNativePointerImpl(j, i).order(ByteOrder.nativeOrder());
    }

    public static ByteBuffer byteBufferViewOfNativePointer(SWIGTYPE_p_unsigned_char sWIGTYPE_p_unsigned_char, int i) {
        //ohr.b(sWIGTYPE_p_unsigned_char);
        return byteBufferViewOfNativePointer(SWIGTYPE_p_unsigned_char.getCPtr(sWIGTYPE_p_unsigned_char), i);
    }

    private static native ByteBuffer byteBufferViewOfNativePointerImpl(long j, int i);

    public static long getDirectBufferAddress(Buffer buffer) {
        //ohr.b(buffer);
        return getDirectBufferAddressImpl(buffer);
    }

    private static native long getDirectBufferAddressImpl(Buffer buffer);

    public static long getDirectBufferCapacity(Buffer buffer) {
        //ohr.b(buffer);
        return getDirectBufferCapacityImpl(buffer);
    }

    private static native long getDirectBufferCapacityImpl(Buffer buffer);
}
