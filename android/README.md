#Android SDK
The Incentiviral Android SDK helps devlopers incentivise their apps in unique ways thereby creating a lasting, viral impression on users. For example
- You can offer discount coupons to users when they share an app message on facebook
- You can offer in-app currency when users have spent a certain amount of time in the app

#Features
- Custom event logging
- Per app and per user incentivisation
- Custom threshold monitoring
- Dynamically change rewards and threshold from the serverside

##Setup

To setup Incentiviral, please add the following to the onCreate method of your activity
```java
Incentiviral.setup("appId", "userId");
```
Here
- appId is your application id available at the Incentiviral dashboard, this is unique to your application
- userId is the unique id of the user of the app, incentives will be tracked based on this user id for your application

##Event logging
To log an event, please call the logEvent method
```java
Incentiviral.logEvent("eventType", 1);
```

For example, if you'd like to log an event that the user has successfully shared the relevant message on facebook, you can
```java
Incentiviral.logEvent("facebookShare", 1);
```

##Checking for Rewards
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
Details
- A callback to onRewardsReceived is received when information about the deals is received
- In case there are no active deals, this list will be blank
- In case there is an error while retrieving deals, a callback to onRewardsFailed is received

Also available, a synchronous call to check rewards, should be called from a non UI thread, useful when one wants to explicitly wait for the rewards, example:

```java
List<Reward> rewards = Incentiviral.checkCurrentRewardsSync();
```
