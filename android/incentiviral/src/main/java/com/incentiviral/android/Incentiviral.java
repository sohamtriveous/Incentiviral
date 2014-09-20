package com.incentiviral.android;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Incentiviral {
    private static Incentiviral sIncentiviral;
    private static WeakReference<Context> sContext;

    public Incentiviral(final Context context) {
        sContext = new WeakReference<Context>(context);
    }

    /**
     * Get a default Incentiviral instance (singleton)
     * @return the Inentiviral singleton
     */
    public static Incentiviral getDefault(final Context context) {
        if(sIncentiviral ==null) {
            sIncentiviral = new Incentiviral(context);
        }
        return sIncentiviral;
    }

    public void setup(String appId) {

    }

    public void logEvent() {

    }

    public void checkRewards() {

    }


}
