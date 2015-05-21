package com.brandon.brandonadnetworktest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by BRANDON on 2015-05-21.
 */
public class BrandonBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        final String action = intent.getAction();
        final String packageName = intent.getData().getSchemeSpecificPart();

        // install application
        if(intent.ACTION_PACKAGE_ADDED == intent.getAction()){
            Log.d("onReceive()", "action: " + action);
            Log.d("onReceive()", "packageName: " + packageName);


            Log.d("onReceive()", "Installation completed");
        }
        else if(intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")){
            Log.d("onReceive()", "action: " + action);
            Log.d("onReceive()", "packageName: " + packageName);


            Log.d("onReceive()", "Application is Removed");
        }
    }
}
