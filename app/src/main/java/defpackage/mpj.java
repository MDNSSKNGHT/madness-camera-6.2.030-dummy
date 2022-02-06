package defpackage;

import android.os.Build;
import java.util.Locale;

public final class mpj {
    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final boolean n;

    private mpj(long j) {
        this.a = j == -2398083415379664855L;
        this.b = j == 1938362633813361533L;
        this.c = j == -1181909560337748989L;
        this.i = j == 2353878190013225779L;
        this.h = j == 5177423953723387160L;
        this.j = j == -1520579938770587849L;
        this.k = j == 1998349393618216766L;
        this.l = j == -3048193804805810922L;
        this.d = j == -1134170917312626182L;
        this.e = j == 7819589124620182093L;
        this.m = j == 1863053326329578117L;
        this.n = j == -6540513541338685385L;
        this.f = j == 8020350475331722164L;
        this.g = j == 4736388726057620427L;
    }

    private static String a(String str) {
        return str != null ? str.toUpperCase(Locale.ROOT) : "unknown";
    }

    public static mpj a() {
        String str = Build.FINGERPRINT;
        String a = a("Google");
        String a2 = a("walleye");
        String a3 = a(str);
        if (a2.startsWith("GENERIC") || a3.startsWith("GENERIC") || a3.contains("SDK_") || a3.contains("_SDK")) {
            return new mpj(-8977428044353436645L);
        }
        String sb = "G1V5VHBME0Mq6trmUxb9Q9URJXm0Sof1|" + a2 + "|" + a;
        return new mpj(/*olf.b().a(sb.toUpperCase(Locale.ROOT)).c()*/ 0);
    }

    public final boolean b() {
        return this.i || this.h;
    }

    public final boolean c() {
        return this.j || this.k || this.l;
    }

    public final boolean d() {
        return this.e || this.d;
    }

    public final boolean e() {
        return this.m || this.n;
    }
}