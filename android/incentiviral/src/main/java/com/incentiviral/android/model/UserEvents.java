package com.incentiviral.android.model;

/**
 * Created by sohammondal on 20/09/14.
 */
public class UserEvents {
    String uid;
    String appId;
    String type;
    int count;

    public UserEvents(String uid, String appId, String type, int count) {
        this.uid = uid;
        this.appId = appId;
        this.type = type;
        this.count = count;
    }
}
