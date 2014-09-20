package com.incentiviral.android;

import com.incentiviral.android.model.Reward;

import java.util.List;

/**
 * Created by sohammondal on 20/09/14.
 */
public interface RewardsListener {
    public void onRewardsReceived(List<Reward> rewards);
}
