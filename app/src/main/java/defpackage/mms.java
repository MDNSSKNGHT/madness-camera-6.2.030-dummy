package defpackage;

public enum mms {
    EXTENDED(128),
    FULL(2),
    SIMPLE(1),
    NONE(0);

    public final int e;

    mms(int i) {
        e = i;
    }

    public static mms a(int i) {
        switch (i) {
            case 1: return SIMPLE;
            case 2: return FULL;
            case 128: return EXTENDED;
            default: return NONE;
        }
    }
}