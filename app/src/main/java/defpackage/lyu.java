package defpackage;

import android.annotation.TargetApi;

@TargetApi(19)
public interface lyu extends AutoCloseable {
    @Override // java.lang.AutoCloseable
    void close();
}