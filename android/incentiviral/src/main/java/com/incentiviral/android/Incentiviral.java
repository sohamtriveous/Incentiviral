package com.incentiviral.android;

import android.content.Context;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Incentiviral {
    private static Incentiviral sIncentiviral;
    private static String sAppId;
    private static Rewards sRewards;


    private static String sUserId;

    private static final String KEY_USER_ID = "user_id";

    public static String getsAppId() {
        return sAppId;
    }

    public static void setUserId(String userId) {
        Incentiviral.sUserId = sUserId;
    }

    private static void setAppId(String sAppId) {
        Incentiviral.sAppId = sAppId;
    }

    public void setup(final Context context, String appId, String userId) {
        setAppId(appId);
        setUserId(userId);
        sRewards = fetchRewards(context);
    }


    /**
     * Called by the developer to log an event
     * @param context
     * @param eventName the unique event name
     */
    public void logEvent(final Context context, String eventName) {

    }

    /**
     * A method to fetch Rewards from the rewards endpoint
     * @param context
     * @return A set of fresh rewards object
     */
    public Rewards fetchRewards(final Context context) {
        Rewards rewards = null;
        return rewards;
    }

    /**
     * A method to check the status of any reward and then show the reward if needed
     * @param context
     */
    public void checkCurrentRewardsStatus(final Context context) {

    }


}
