package defpackage;

import java.util.Arrays;

public class mnh {
    public final int a;
    public final  lyw b;

    public mnh(int format, lyw res) {
        a = format;
        b = res;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof mnh)) {
            return false;
        }
        mnh mnh = (mnh) o;
        return mnh.a == this.a && mnh.b.equals(this.b);
    }

    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    /*
    public final String toString() {
        return oxl.a("ImageReaderFormat").a("ImageFormat", mql.a(this.a)).a("Size", this.b).toString();
    }
    */
}
