package com.android.droidconke;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class myIntentService extends IntentService {


    public myIntentService() {
        super("myIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null)
        {
            BackgroundClass backgroundClass = new BackgroundClass();
            backgroundClass.sendANotification();

        }
    }


}
