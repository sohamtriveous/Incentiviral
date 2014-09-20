package com.incentiviral.android;

/**
 * Created by sohammondal on 20/09/14.
 */
public class Incentiviral {

    private static Incentiviral sIncentiviral;

    /**
     * Get a default Incentiviral instance (singleton)
     * @return the Inentiviral singleton
     */
    public static Incentiviral getDefault() {
        if(sIncentiviral ==null) {
            sIncentiviral = new Incentiviral();
        }
        return sIncentiviral;
    }

    
}
