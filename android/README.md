#Android SDK

##General uses and API

- To setup Incentiviral, please add the following to the onCreate method of your activity
```java
Incentiviral.setup("AppId", "UserId");
```
Here 
AppId is your application id available at the Incentiviral dashboard, this is unique to your application
UserId is the unique id of the user of the app, incentives will be tracked based on this user id for your application


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
