package org.lagonette.android.content.loader;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class PartnerCursorLoaderHelper {

    private static final java.lang.String ARG_IS_VISIBLE = "arg:is_visible";
    private static String ARG_SEARCH = "arg:search";

    public static Bundle getArgs(@NonNull String search) {
        Bundle args = new Bundle(1);
        args.putString(ARG_SEARCH, search);
        return args;
    }

    public static Bundle getArgs(@NonNull String search, boolean isVisible) {
        Bundle args = new Bundle(2);
        args.putString(ARG_SEARCH, search);
        args.putBoolean(ARG_IS_VISIBLE, isVisible);
        return args;
    }

    @Nullable
    public static String getSearch(@Nullable Bundle bundle) {
        return bundle != null ? bundle.getString(ARG_SEARCH, null) : null;
    }

    @Nullable
    public static Boolean isVisible(@Nullable Bundle bundle) {
        return bundle != null && bundle.containsKey(ARG_IS_VISIBLE) ? bundle.getBoolean(ARG_IS_VISIBLE, false) : null;
    }
}
