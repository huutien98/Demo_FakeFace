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

import java.util.HashMap;

public class Main3Activity extends AppCompatActivity implements HomeFragment.IListener {
    private static final String SELECT_FRAGMENT = "SELECT_FRAGMENT";
    private static final String MESSENGER_FRAGMENT = "MESSENGER_FRAGMENT";
    private static final String NOTIFICATION_FRAGMENT = "NOTIFICATION_FRAGMENT";
    private static final String PROFILE_FRAGMENT = "PROFILE_FRAGMENT";
    private static final String CHECKED_MAP = "CHECKED_MAP";
    BottomNavigationView bottom_navigation;
    FloatingActionButton fab;
    HashMap<Integer,Boolean> checkeMap = new HashMap<>();

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            checkeMap = (HashMap<Integer, Boolean>) savedInstanceState.getSerializable(CHECKED_MAP);
        }
    }

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
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.fragment_container,selectedFragment,SELECT_FRAGMENT);
                    break;
                case R.id.nav_messenger:
                    selectedFragment = new MessengerFragment();
                    fragmentTransaction.add(R.id.fragment_container,selectedFragment,MESSENGER_FRAGMENT);
                    break;
                case  R.id.nav_add:
                    break;
                case R.id.nav_notification:
                    selectedFragment = new NotificationFragment();
                    fragmentTransaction.add(R.id.fragment_container,selectedFragment,NOTIFICATION_FRAGMENT);
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    fragmentTransaction.add(R.id.fragment_container,selectedFragment,PROFILE_FRAGMENT);
                    break;
            }
            fragmentTransaction.commit();
            return true;
        }
    };

    @Override
    public void heartClickListener(boolean isChecked, int id) {
        checkeMap.put(id,isChecked);
    }

    public HashMap<Integer, Boolean> getCheckeMap() {
        return checkeMap;
    }

    public void setCheckeMap(HashMap<Integer, Boolean> checkeMap) {
        this.checkeMap = checkeMap;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(checkeMap != null){
            outState.putSerializable(CHECKED_MAP,checkeMap);
        }
    }
}
