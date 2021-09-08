package com.henrybaby.paperartist.utils;

import ohos.app.Context;
import ohos.data.DatabaseHelper;
import ohos.data.preferences.Preferences;

public final class SaveUtils {
    private static Preferences mPrefers = null;
    private static final String KEY_Privacy = "Key_LicenseAgreed";

    private static Preferences getSharedPref(Context context) {
        if (mPrefers == null) {
            DatabaseHelper databaseHelper = new DatabaseHelper(context);
            String fileName = "only_pref";
            mPrefers = databaseHelper.getPreferences(fileName);
        }
        return mPrefers;
    }

    public static boolean readUserAgreedPrivacy(Context context) {
        Preferences pref = getSharedPref(context);
        return pref.getBoolean(KEY_Privacy, false);
    }

    public static boolean writeUserAgreedPrivacy(Context context, boolean newValue) {
        Preferences pref = getSharedPref(context);
        pref.putBoolean(KEY_Privacy, newValue);
        return pref.flushSync();
    }
}
