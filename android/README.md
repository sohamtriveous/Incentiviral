#Incentiviral Android SDK
The Incentiviral Android SDK can help devlopers 
- drive engagement in their app
- generate app virality
- increase the app revenue

For example, by using the SDK
- you can generate virality in your app by incentivising app shares on facebook. When users share your app on facebook, you can use this sdk to offer them some kind of discount coupons (virtual good).
- you can drive engagement amongst users by offering in-app currency to users who spend a large amount of time in the app

![The LowPrice app using the Incentiviral SDK ](http://s27.postimg.org/xca7v5smr/incentiviral1.png "The LowPrice android app using the Incentiviral SDK")

#Features
- Custom event logging
- Per app and per user incentivisation
- Custom threshold monitoring
- Dynamically change rewards and threshold from the serverside

#Sample
Integrating the Incentiviral sdk is as easy as
- Calling the setup method
- Calling the logEvent method to log events
- Calling getRewards to get information on the rewards accrued by the user

The sample app "app" included in the repo demonstrates the following features
- Setting up the Incentiviral SDK with the appId and userId
- Logging a simple event for the current user
- Retrieving the current rewards for the same user

#Integration details

##Add Incentiviral to your app (Android Studio only)
- [Download the latest incentiviral.aar library from here](https://github.com/triveous/Incentiviral/blob/master/android/incentiviral.aar)
- Add the incentiviral.aar file to your libs folder
- Add the following to your build.gradle file if it is not already there
```groovy
repositories {
  mavenCentral()
  flatDir {
    dirs 'libs'
  }
}
```
- Add the following dependency to the build.gradle file
```groovy
dependencies {
    compile(name:'incentiviral', ext:'aar')
}
```

##Setup incentiviral for your user

To setup Incentiviral, please add the following to the onCreate method of your activity
```java
Incentiviral.setup("appId", "userId");
```
Here
- **appId** is your application id available at the Incentiviral dashboard, this is unique to your application
- **userId** is the unique id of the user of the app, incentives will be tracked based on this user id for your application

##Logging events
To log an event, please call the logEvent method
```java
Incentiviral.logEvent("eventType", count, new LogEventListener() {
  @Override
  public void onLogEventSuccess() {
    Toast.makeText(SampleActivity.this, "Event logged successfully", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onLogEventFailure(String error) {
    Toast.makeText(SampleActivity.this, "Error in event logging: " + error, Toast.LENGTH_SHORT).show();
  }
});
```

For example, if you'd like to log an event that the user has successfully shared the relevant message on facebook, you can
```java
Incentiviral.logEvent("facebookShare", 1, new LogEventListener() {
  @Override
  public void onLogEventSuccess() {
    Toast.makeText(SampleActivity.this, "Event logged successfully", Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onLogEventFailure(String error) {
    Toast.makeText(SampleActivity.this, "Error in event logging: " + error, Toast.LENGTH_SHORT).show();
  }
});
```
**Note**
- There are some callbacks, mainly onLogEventSuccess and onLogEventFailure that let us know the status of the event logging

##Checking for Rewards (that have been achieved)
To check for rewards, please call the checkCurrentRewards method which is handled **asynchronously**
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
**Note**
- This call is completely asynchronous in nature, there is no need to add support for threading
- A callback to onRewardsReceived is received when information about the rewards is received
- In case there are no active deals, this list will be blank
- In case there is an error while retrieving deals, a callback to onRewardsFailed is received

Also available, a **synchronous** call to check rewards, useful when one wants to explicitly wait for the rewards, example:

```java
List<Reward> rewards = Incentiviral.checkCurrentRewardsSync();
```
**Note**
- this should not be called from the UI thread as in might block UI processing
- can be called from an AsyncTask or any non-UI thread

##Show all rewards
To fetch a list of all possible rewards, please call the checkStaticRewardList method

```java
Incentiviral.checkStaticRewardList(new StaticRewardListListener() {
  @Override
  public void onRewardListReceived(List<RewardList> rewardLists) {
    Toast.makeText(SampleActivity.this, rewardLists.get(0).getReward().getDesc(), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onRewardListFailed(String error) {
  }
});
```
**Note**
- This call is completely asynchronous in nature, there is no need to add support for threading
- A callback to onRewardListReceived is received when information about the rewards is received
- In case there are no active deals, this list will be blank
- In case there is an error while retrieving deals, a callback to onRewardListFailed is received

##The Reward object
Once you have a list of rewards that is accessible to the user, you can use the following methods to find details of the reward itself
```java
String title = reward.getTitle();
String description = reward.getDesc();
String code = reward.getCode();
```
With the above information, you can show the incentive to the end user
