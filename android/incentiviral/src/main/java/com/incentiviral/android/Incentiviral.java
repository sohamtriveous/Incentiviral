package com.incentiviral.android;

import android.content.Context;

import com.incentiviral.android.model.Reward;
import com.incentiviral.android.model.UserEvents;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Incentiviral {
    private static String sAppId;
    private static String sUserId;


    private static String getsUserId() {
        return sUserId;
    }

    private static String getsAppId() {
        return sAppId;
    }

    private static void setUserId(String userId) {
        Incentiviral.sUserId = userId;
    }

    private static void setAppId(String sAppId) {
        Incentiviral.sAppId = sAppId;
    }

    /**
     * Setup Incentiviral, must be called every time an apps tarts
     * @param context
     * @param appId App id
     * @param userId User id
     */
    public static void setup(final Context context, String appId, String userId) {
        setAppId(appId);
        setUserId(userId);
    }


    /**
     * Called by the developer to log an event
     * @param context
     * @param eventName the unique event name
     */
    public static void logEvent(final Context context, String eventName, int count) {
        IncentiviralClient.getIncentiviralApi().logEvents(new UserEvents(getsUserId(), getsAppId(), eventName, count), new Callback<Object>() {
            @Override
            public void success(Object o, Response response) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    /**
     * A method to check the status of any reward and then show the reward if needed
     * @param context
     */
    public static void checkCurrentRewards(final Context context, final RewardsListener rewardsListener) {
        // make async post to check rewards
        // if successful use the rewardsListener interface
        IncentiviralClient.getIncentiviralApi().getRewards(getsAppId(), getsUserId(), new Callback<List<Reward>>() {
            @Override
            public void success(List<Reward> rewards, Response response) {
                rewardsListener.onRewardsReceived(rewards);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}
