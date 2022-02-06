package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Size;

import java.math.BigInteger;
import java.util.Arrays;

public final class lyb {
    public static final lyb a = a(4, 3);
    public static final lyb b = a(16, 9);
    private final int c;
    private final int d;

    private lyb(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    public static lyb a(int i, int i2) {
        int intValue = BigInteger.valueOf((long) i).gcd(BigInteger.valueOf((long) i2)).intValue();
        return new lyb(i / intValue, i2 / intValue);
    }

    public static lyb a(Size size) {
        return a(size.getWidth(), size.getHeight());
    }

    public static lyb a(lyw lyw) {
        return a(lyw.a, lyw.b);
    }

    private lyb d() {
        return a(this.d, this.c);
    }

    private boolean e() {
        return this.c <= this.d;
    }

    public final float a() {
        return ((float) this.c) / ((float) this.d);
    }

    public final Rect a(Rect rect) {
        lyb a2 = a(rect.width(), rect.height());
        if (this.c * a2.d > a2.c * this.d) {
            int width = (rect.width() * this.d) / this.c;
            int height = rect.top + ((rect.height() - width) / 2);
            return new Rect(rect.left, height, rect.left + rect.width(), width + height);
        }
        int height2 = (rect.height() * this.c) / this.d;
        int width2 = rect.left + ((rect.width() - height2) / 2);
        return new Rect(width2, rect.top, height2 + width2, rect.top + rect.height());
    }

    public final boolean a(lyb lyb) {
        float a2 = a();
        if (!e()) {
            lyb = lyb.c();
        } else if (!lyb.e()) {
            lyb = lyb.d();
        }
        return ((double) Math.abs(a2 - lyb.a())) < 0.025d;
    }

    public final double b() {
        double d = (double) this.c;
        double d2 = (double) this.d;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d / d2;
    }

    public final lyb c() {
        return this.c < this.d ? d() : this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof lyb) {
            lyb lyb = (lyb) obj;
            return this.d == lyb.d && this.c == lyb.c;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.d});
    }

    @SuppressLint("DefaultLocale")
    public final String toString() {
        return String.format("AspectRatio[%d:%d]", this.c, this.d);
    }
}