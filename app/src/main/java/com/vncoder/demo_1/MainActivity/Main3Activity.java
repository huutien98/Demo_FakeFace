package com.vncoder.demo_1.MainActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vncoder.demo_1.Fragment.AddFragment;
import com.vncoder.demo_1.Fragment.HomeFragment;
import com.vncoder.demo_1.Fragment.MessengerFragment;
import com.vncoder.demo_1.Fragment.NotificationFragment;
import com.vncoder.demo_1.Fragment.ProfileFragment;
import com.vncoder.demo_1.R;

public class Main3Activity extends AppCompatActivity {
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(navListener);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_messenger:
                    selectedFragment = new MessengerFragment();
                    break;
                case R.id.nav_add:
                    selectedFragment = new AddFragment();
                    break;
                case R.id.nav_notification:
                    selectedFragment = new NotificationFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }
    };


}
