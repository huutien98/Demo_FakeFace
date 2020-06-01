package com.vncoder.demo_1.MainActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vncoder.demo_1.Fragment.AddFragment;
import com.vncoder.demo_1.Fragment.HomeFragment;
import com.vncoder.demo_1.Fragment.MessengerFragment;
import com.vncoder.demo_1.Fragment.NotificationFragment;
import com.vncoder.demo_1.Fragment.ProfileFragment;
import com.vncoder.demo_1.R;

public class Main3Activity extends AppCompatActivity implements HomeFragment.IListener {
    BottomNavigationView bottom_navigation;
    FloatingActionButton fab;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bottom_navigation = findViewById(R.id.bottom_navigation);
        fab = findViewById(R.id.fab);
        bottom_navigation.setOnNavigationItemSelectedListener(navListener);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        bottom_navigation.setItemIconTintList(null);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AddFragment fragment = new AddFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragment);
                transaction.commit();

            }
        });
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
                case  R.id.nav_add:
                    break;
                case R.id.nav_notification:
                    selectedFragment = new NotificationFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,selectedFragment).commit();

            return true;
        }
    };

    @Override
    public void heartClickListener(boolean isChecked, int id) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if(fragment instanceof NotificationFragment){
            ((NotificationFragment) fragment).updateList(isChecked,id);
        }
    }

}
