package com.incentiviral.android;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Incentiviral {
    private static Incentiviral sIncentiviral;
    private static String appId;

    public static String getAppId() {
        return appId;
    }

    private static void setAppId(String appId) {
        Incentiviral.appId = appId;
    }

    public void setup(final Context context, String appId) {
        setAppId(appId);
    }

    public void logEvent(final Context context, String eventName) {

    }

    public Rewards checkRewards(final Context context) {
        Rewards rewards = null;
        return rewards;
    }


}
