package com.madnessknight;

import android.os.Build;

/** Per device characteristics
 */
public class ProductCharacteristics {
    private static ProductCharacteristics Sef = null;

    private String soc, bl, hw;

    private ProductCharacteristics() {}

    public static ProductCharacteristics getSef() {
        if (Sef == null) {
            var self = new ProductCharacteristics();
            self.soc = Build.BOARD;
            self.bl = Build.BOOTLOADER;
            self.hw = Build.HARDWARE;
            Sef = self;
        }
        return Sef;
    }

    // Exynos devices
    public final boolean isExynos() {
        return hw.contains("exynos");
    }

    public final boolean isExynos9610() {
        return soc.endsWith("9610");
    }

    public final boolean isExynos9611() {
        return soc.endsWith("9611");
    }

    public final boolean isExynos9820() {
        return soc.endsWith("9820");
    }

    public final boolean isExynos9825() {
        return soc.endsWith("9825");
    }

    public final boolean isExynos2100() {
        return soc.endsWith("2100");
    }

    // Exynos and device specific
    public final boolean isA3Y17() {
        return bl.startsWith("A320");
    }

    public final boolean isJ7Y17() {
        return bl.startsWith("J730");
    }
}
