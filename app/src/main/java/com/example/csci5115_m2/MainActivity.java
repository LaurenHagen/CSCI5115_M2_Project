//this is where i try moving everything from MainActivity to NextActivity, and rewriting main activity to just be the splash screen that THEN
//goes to NextActivity which should contain code for the rest of the app
//I suspect that the code block:

//@Override
//protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);

//is what is responsible for making that specific java file the one that starts on launch.

//overall, i think our general problem is that the splash screen has to be in a different java file that is either
//MaiActivity OR SplashActivity, which contains logic for the splash screen. then THIS PART

package com.example.csci5115_m2;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.csci5115_m2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}