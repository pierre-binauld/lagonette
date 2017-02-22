package com.zxcv.gonette.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.zxcv.gonette.R;
import com.zxcv.gonette.content.contract.GonetteContract;
import com.zxcv.gonette.database.GonetteDatabaseOpenHelper;

public class GonetteContentProvider extends ContentProvider {

    private UriMatcher mUriMatcher;

    private GonetteDatabaseOpenHelper mOpenHelper;

    @Override
    public boolean onCreate() {
        mOpenHelper = new GonetteDatabaseOpenHelper(getContext());
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        setupUriMatcher();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int match = mUriMatcher.match(uri);
        switch (match) {
            case R.id.content_uri_partner:
                return GonetteContract.Partner.CONTENT_TYPE_ITEM;
            case R.id.content_uri_partners:
                return GonetteContract.Partner.CONTENT_TYPE_DIR;
            default:
                throw new IllegalArgumentException(String.format("Unknown content uri code: %s", match));
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    private void setupUriMatcher() {
        addUriToUriMatcher(
                mUriMatcher,
                GonetteContract.AUTHORITY,
                GonetteContract.Partner.CONTENT_URI.getPath(),
                R.id.content_uri_partners
        );
        addUriToUriMatcher(
                mUriMatcher,
                GonetteContract.AUTHORITY,
                GonetteContract.Partner.CONTENT_URI.getPath()+"/#",
                R.id.content_uri_partner
        );
    }

    private static void addUriToUriMatcher(
            @NonNull UriMatcher uriMatcher,
            @NonNull String authority,
            @NonNull String path,
            int code) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR2) {
            path = path.substring(1);
        }
        uriMatcher.addURI(authority, path, code);
    }
}
