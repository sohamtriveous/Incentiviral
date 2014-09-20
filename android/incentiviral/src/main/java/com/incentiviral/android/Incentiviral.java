package com.incentiviral.android;

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
     * @param appId App id
     * @param userId User id
     */
    public static void setup(String appId, String userId) {
        setAppId(appId);
        setUserId(userId);
    }


    /**
     * Called by the developer to log an event
     * @param type the unique event name
     */
    public static void logEvent(String type, int count) {
        IncentiviralClient.getIncentiviralApi().logEvents(new UserEvents(getsUserId(), getsAppId(), type, count), new Callback<Object>() {
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
     * @param rewardsListener
     */
    public static void checkCurrentRewards(final RewardsListener rewardsListener) {
        // make async post to check rewards
        // if successful use the rewardsListener interface
        IncentiviralClient.getIncentiviralApi().getRewards(getsAppId(), getsUserId(), new Callback<List<Reward>>() {
            @Override
            public void success(List<Reward> rewards, Response response) {
                rewardsListener.onRewardsReceived(rewards);
            }

            @Override
            public void failure(RetrofitError error) {
                rewardsListener.onRewardsFailed(error.getMessage());
            }
        });
    }

    /**
     * A synchronous (blocking) version of the checkCurrentRewards API
     * Should be called from a non UI thread, useful when you want to explicitly wait for the rewards
     * @return
     */
    public static List<Reward> checkCurrentRewardsSync() {
        // make a synchronous(blocking) post to check rewards
        // if successful use the rewardsListener interface
        return IncentiviralClient.getIncentiviralApi().getRewards(getsAppId(), getsUserId());
    }
}
