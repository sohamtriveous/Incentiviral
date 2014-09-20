package com.example.incentiviral;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.incentiviral.android.Incentiviral;
import com.incentiviral.android.RewardsListener;
import com.incentiviral.android.model.Reward;

import java.util.List;


public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Incentiviral.setup("IncentiviralSample", "akaashanky@gmail.com");
        // logging a simple event
        Incentiviral.logEvent("facebookShare", 1);
        // async call to check current rewards
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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sample, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
