package org.lagonette.android.util;

import android.os.StrictMode;

import org.lagonette.android.BuildConfig;

public class StrictModeUtil {

    public static void enableStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder()
                            .detectAll()
                            .build()
            );
            StrictMode.setVmPolicy(
                    new StrictMode.VmPolicy.Builder()
                            .detectAll()
                            .build()
            );
        }
    }
}
