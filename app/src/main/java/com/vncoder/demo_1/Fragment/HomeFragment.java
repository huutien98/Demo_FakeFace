package com.vncoder.demo_1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Adapter.HomeAdapter;
import com.vncoder.demo_1.CustomSpinnerAdapter;
import com.vncoder.demo_1.Object.HomeObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<HomeObject> arrayList;
     Toolbar toolbar;
     Spinner spinner_nav;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        toolbar = view.findViewById(R.id.toolbar);
        spinner_nav = view.findViewById(R.id.spinner_nav);

        if (toolbar != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        }
        addItemsToSpinner();
        arrayList = new ArrayList<>();
        HomeObject object = new HomeObject("Martin Palmer",R.drawable.img_account,R.drawable.img_glitters,
                "What is the loop of Creation? How is there something from nothing? In spite" +
                        " of the fact that it is impossible to prove that anythin….","12:20 Mon","500$");
        HomeObject object1 = new HomeObject("Pearl Myers",R.drawable.img_account,R.drawable.btn_menu_dots,
                "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                "Yesterday","290.00");
        HomeObject object2 = new HomeObject("Gary Rose",R.drawable.img_account,R.drawable.img_bottom_blob,
                "There is this awesome event happening. Let’s join it guys.",
        "yesterday","$340.00");
        HomeObject object3 = new HomeObject("Gary Rose",R.drawable.img_account,R.drawable.img_glitters,
                "There is this awesome event happening. Let’s join it guys.",
                "yesterday","$340.00");
        HomeObject object4 = new HomeObject("Gary Rose",R.drawable.img_account,R.drawable.btn_notifications,
                "There is this awesome event happening. Let’s join it guys.",
                "yesterday","$340.00");
        HomeObject object5 = new HomeObject("Gary Rose",R.drawable.img_account,R.drawable.btn_circle,
                "There is this awesome event happening. Let’s join it guys.",
                "yesterday","$340.00");


        arrayList.add(object);
        arrayList.add(object1);
        arrayList.add(object2);
        arrayList.add(object3);
        arrayList.add(object4);
        arrayList.add(object5);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        HomeAdapter adapter = new HomeAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        setHasOptionsMenu(true);
        return view;
     }
    public void addItemsToSpinner() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("All Categories");
        list.add("Movies");
        list.add("Video");
        list.add("Sports");
        list.add("Tech");

        CustomSpinnerAdapter spinAdapter = new CustomSpinnerAdapter(
                getContext(), list);
        spinner_nav.setAdapter(spinAdapter);
        spinner_nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                String item = adapter.getItemAtPosition(position).toString();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
    }


}

