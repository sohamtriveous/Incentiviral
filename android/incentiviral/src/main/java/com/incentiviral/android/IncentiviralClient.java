package com.incentiviral.android;

import com.incentiviral.android.model.Reward;
import com.incentiviral.android.model.UserEvents;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by sohammondal on 20/09/14.
 */
public class IncentiviralClient {
    private static final String API_URL = "http://incentiviral.herokuapp.com/api";
    private static IncentiviralApiInterface sIncentiviralApiInterface;

    public static IncentiviralApiInterface getIncentiviralApi() {
        if(sIncentiviralApiInterface == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API_URL)
                    .build();

            sIncentiviralApiInterface = restAdapter.create(IncentiviralApiInterface.class);
        }
        return sIncentiviralApiInterface;
    }

    public interface IncentiviralApiInterface {
        @POST("/userEvents")
        void logEvents(@Body UserEvents userEvents, Callback<Object> callback);
        @GET("/rewards")
        void getRewards(@Query("appId") String appId, @Query("uid") String uid, Callback<List<Reward>> callback);
    }
}
