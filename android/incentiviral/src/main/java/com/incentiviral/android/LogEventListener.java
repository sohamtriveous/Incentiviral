package com.incentiviral.android;

/**
 * Created by sohammondal on 21/09/14.
 */
public interface LogEventListener {
    public void onLogEventSuccess();
    public void onLogEventFailure(String error);
}
