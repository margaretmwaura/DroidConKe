package com.android.droidconke;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class BackgroundClass
{
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    private static final String LEGACY_SERVER = "AIzaSyAPCnPrE1xgm1VAn-Uef_MNDE47z9m0cdY";
    //    Will build this method

    public BackgroundClass()
    {

    }
    public void sendANotification()
    {
        Log.d("NotificationSending","The method has been called to send a notification");
//        String regToken = returnRegistrationToken();
        String regToken = " ";
        String topic = "/topics/userABC";
        Log.d("RegistrationToken","This is the registration token " + regToken);
        OkHttpClient client = new OkHttpClient();
        JSONObject json=new JSONObject();
        JSONObject dataJson=new JSONObject();
        try {
            dataJson.put("body", "Reminder about the chama event \n taking place today");
            dataJson.put("title", "Chama event");
            json.put("notification", dataJson);
            json.put("to", topic);
        }
        catch (Exception e)
        {
            Log.d("NotificationSettingUp", "An error was caught : details " + e.getMessage());
        }
        RequestBody body = RequestBody.create(JSON, json.toString());
        Request request = new Request.Builder()
                .header("Authorization","key="+LEGACY_SERVER)
                .url("https://fcm.googleapis.com/fcm/send")
                .post(body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String finalResponse = response.body().string();
            Log.d("SendingNotification","Sending of notification was succesful");
        }
        catch (Exception e)
        {
            Log.d("NotificationExecution","An error was caught : details " + e.getMessage());
            e.printStackTrace();
        }
//          String finalResponse = response.body().string();

        Log.d("NotificationSending","The method has completed");
    }
}
