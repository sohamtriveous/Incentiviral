package com.incentiviral.android;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Store {
    public static final String PREFERENCES_BASE = "incentiviral";

    public static SharedPreferences getPrefs(final Context context) {
        if (context != null) {
            return context.getSharedPreferences(
                    PREFERENCES_BASE, Context.MODE_PRIVATE);
        } else {
            return null;
        }
    }

    public static SharedPreferences.Editor getPrefEdit(final Context context) {
        if (context != null) {
            return getPrefs(context).edit();
        } else {
            return null;
        }
    }

    // default getBoolean, defValue is false
    public static boolean getBoolean(final Context context, final String key) {
        if (context != null) {
            return getPrefs(context).getBoolean(key, false);
        } else {
            return false;
        }
    }

    // defValue based pilymorphic getBoolean
    public static boolean getBoolean(final Context context, final String key, boolean defValue) {
        if (context != null) {
            return getPrefs(context).getBoolean(key, defValue);
        } else {
            return defValue;
        }
    }

    public static String getString(final Context context, final String key) {
        if (context != null) {
            return getPrefs(context).getString(key, null);
        } else {
            return null;
        }
    }

    public static String getString(final Context context, final String key, String defValue) {
        if (context != null) {
            return getPrefs(context).getString(key, defValue);
        } else {
            return defValue;
        }
    }

    public static int getInt(final Context context, final String key) {
        if (context != null) {
            return getPrefs(context).getInt(key, -1);
        } else {
            return -1;
        }
    }

    public static int getInt(final Context context, final String key, int defValue) {
        if (context != null) {
            return getPrefs(context).getInt(key, defValue);
        } else {
            return defValue;
        }
    }
}
