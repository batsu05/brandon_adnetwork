package com.brandon.brandonadnetworktest;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.appnext.appnextsdk.API.AppnextAPI;
import com.appnext.appnextsdk.API.AppnextAdRequest;
import com.appnext.appnextsdk.Appnext;
import com.appnext.appnextsdk.NoAdsInterface;
import com.appnext.appnextsdk.OnAdLoadInterface;

import java.util.ArrayList;


public class AppnextActivity extends ActionBarActivity {

    AppnextAPI api;
    Appnext appnext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appnext);

//        AppnextAPI api;
//        Appnext appnext;

        appnext = new Appnext(this);
        appnext.setAppID("05390be9-7da9-402d-b9cd-67bbb53fe5e9"); // Set your AppID
        appnext.showBubble(); // show the interstitial
        appnext.setAdLoadInterface(new OnAdLoadInterface() {
            @Override
            public void adLoaded() {
                Log.v("appnext", "on ad load");
            }
        });
        appnext.setNoAdsInterface(new NoAdsInterface() {
            @Override
            public void noAds() {
                Log.v("appnext", "no ads");
            }
        });

        api = new AppnextAPI(this, "05390be9-7da9-402d-b9cd-67bbb53fe5e9");
        api.setAdListener(new AppnextAPI.AppnextAdListener() {
            @Override
            public void onError(String error) {
            }

            @Override
            public void onAdsLoaded(ArrayList ads) {
                //collect and store the data received


            }
        });
        api.loadAds(new AppnextAdRequest());
    }

    @Override
    public void onBackPressed() {
        if(appnext.isBubbleVisible()){
            appnext.hideBubble();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appnext, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
