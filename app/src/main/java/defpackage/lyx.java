package defpackage;

import android.annotation.TargetApi;
import android.util.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class lyx {
    public static String a(lyw lyw) {
        int i = lyw.a;
        int i2 = lyw.b;
        return i + "x" + i2;
    }

    @TargetApi(21)
    public static List<lyw> a(Size[] sizeArr) {
        if (sizeArr == null) {
            return /*ods.g()*/ null;
        }
        ArrayList<lyw> arrayList = new ArrayList<>(sizeArr.length);
        for (Size size : sizeArr) {
            if (size != null) {
                arrayList.add(new lyw(size.getWidth(), size.getHeight()));
            }
        }
        return arrayList;
    }

    public static lyw a(String str) {
        if (str != null) {
            String[] split = str.split("x");
            if (split.length == 2) {
                try {
                    return new lyw(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
                } catch (NumberFormatException ignored) {
                }
            }
        }
        return null;
    }

    public static lyw a(List list) {
        //ohr.b(!list.isEmpty());
        return (lyw) Collections.max(list, /*lyy.a*/ null);
    }

    @TargetApi(21)
    public static Size b(lyw lyw) {
        return new Size(lyw.a, lyw.b);
    }
}