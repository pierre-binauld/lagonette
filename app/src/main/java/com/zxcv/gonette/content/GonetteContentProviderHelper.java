package com.zxcv.gonette.content;

import com.zxcv.gonette.database.PartnerColumns;
import com.zxcv.gonette.database.PartnerMetadataColumns;
import com.zxcv.gonette.database.Tables;

public abstract class GonetteContentProviderHelper {

    public static String getPartnerWithMetadataStatement() {
        return Tables.PARTNER +
                " LEFT JOIN " + Tables.PARTNER_METADATA +
                " ON " + PartnerColumns.ID + " = " + PartnerMetadataColumns.PARTNER_ID;
    }

    public static String getIsVisibleProjection() {
        return "CASE " + PartnerMetadataColumns.IS_VISIBLE + " IS NULL THEN 'true' ELSE " + PartnerMetadataColumns.IS_VISIBLE + " END";
    }

    public static String getIsVisibleSelection() {
        return PartnerMetadataColumns.IS_VISIBLE + " IS NULL OR " + PartnerMetadataColumns.IS_VISIBLE + " = 1";
    }

}