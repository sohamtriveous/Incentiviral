#Android SDK

##General uses and API

To setup Incentiviral, please add the following to the onCreate method of your activity
```java
Incentiviral.setup("IncentiviralSample", "myemail@mydomain.com");
```

To log an event, please call the logEvent method
```java
Incentiviral.logEvent("facebookShare", 1);
```

To check for rewards, please call the checkCurrentRewards method
```java
Incentiviral.checkCurrentRewards(new RewardsListener() {
  @Override
  public void onRewardsReceived(List<Reward> rewards) {
    if(rewards!=null) {
      Toast.makeText(SampleActivity.this, rewards.get(0).getDesc(), Toast.LENGTH_SHORT).show();
    }
  }

  @Override
  public void onRewardsFailed(String error) {
    Toast.makeText(SampleActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
  }
});
```
