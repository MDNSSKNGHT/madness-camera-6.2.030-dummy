package defpackage;

import android.graphics.Point;
import android.graphics.Rect;

public final class lyw {
    public final int a;
    public final int b;
    private volatile lyw c;

    public lyw(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = null;
    }

    private lyw(int i, int i2, lyw lyw) {
        this.a = i;
        this.b = i2;
        this.c = lyw;
    }

    public static lyw a(int i, int i2) {
        return new lyw(i, i2);
    }

    public static lyw a(Point point) {
        return new lyw(point.x, point.y);
    }

    public static lyw a(Rect rect) {
        return new lyw(rect.width(), rect.height());
    }

    public final lyw a() {
        lyw lyw = this.c;
        if (lyw != null) {
            return lyw;
        }
        lyw lyw2 = new lyw(this.b, this.a, this);
        this.c = lyw2;
        return lyw2;
    }

    public final String toString() {
        return this.a + "x" + this.b;
    }
}