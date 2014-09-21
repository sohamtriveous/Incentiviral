package com.incentiviral.android;

import com.incentiviral.android.model.Reward;
import com.incentiviral.android.model.list.RewardList;

import java.util.List;

/**
 * Created by sohammondal on 20/09/14.
 */
public interface StaticRewardListListener {
    public void onRewardListReceived(List<RewardList> rewardLists);
    public void onRewardListFailed(String error);
}
