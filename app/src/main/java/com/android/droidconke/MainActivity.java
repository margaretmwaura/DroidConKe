package com.android.droidconke;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.android.droidconke.Analytics.addAdminChatAnalysis;

public class MainActivity extends AppCompatActivity {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static final String LEGACY_SERVER = "AIzaSyAPCnPrE1xgm1VAn-Uef_MNDE47z9m0cdY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button)findViewById(R.id.analytics);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Logging the event to firebase analytics
                Bundle params = new Bundle();
                params.putString("Action","AddingAdminChat");
                addAdminChatAnalysis(MainActivity.this,"AdminChat",params);

                Intent intent = new Intent(MainActivity.this,myIntentService.class);
                startService(intent);
            }
        });
    }



}
