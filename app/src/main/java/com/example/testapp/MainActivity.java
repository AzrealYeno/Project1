package com.example.testapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.testapp.databinding.ActivityMainBinding;

import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {


    private static final String CHANNEL_ID = "DRINK_NOTIFICATIONS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);


        getSupportActionBar().setDisplayShowTitleEnabled(false);



        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.app_bar, null); //hear set your costume layout
        getSupportActionBar().setCustomView(v);
        getSupportActionBar().setDisplayShowCustomEnabled(true);

                double waterNeeded = 3.5;
        String hydrationTimer = "3 mins";
        double waterDrank = 1.5;

        TextView text =(TextView) v.findViewById(R.id.topTitleText1);
        text.setText(String.valueOf(waterNeeded));

        TextView text2 =(TextView) v.findViewById(R.id.topTitleText2);
        text2.setText(String.valueOf(hydrationTimer));

        TextView text3 =(TextView) v.findViewById(R.id.topTitleText3);
        text3.setText(String.valueOf(waterDrank));

        createNotificationChannel();


        sendNotification();



    }

    private void sendNotification(){


        CharSequence textTitle = "DRINK NOW!";
        CharSequence textContent = "Drink 1l";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_avatar_foreground)
                .setContentTitle(textTitle)
                .setContentText(textContent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(123 ,builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}

