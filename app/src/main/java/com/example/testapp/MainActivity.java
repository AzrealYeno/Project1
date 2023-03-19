package com.example.testapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.testapp.databinding.ActivityMainBinding;

import java.time.format.DateTimeFormatter;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        setHasOptionsMenu(true);
//
//        Toolbar toolbar = findViewById(R.id.toolbar);

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

        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#8731a0")));


//        String appTitle = String.format(" %s  -  %s -  %s ", waterNeeded, hydrationTimer, waterDrank);
//        getSupportActionBar().setTitle(appTitle);

    }

}