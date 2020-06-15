package com.vncoder.demo_1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Adapter.HomeAdapter;
import com.vncoder.demo_1.CustomSpinnerAdapter;
import com.vncoder.demo_1.MainActivity.Main3Activity;
import com.vncoder.demo_1.Object.HomeObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<HomeObject> arrayList;
    Toolbar toolbar;
    Spinner spinner_nav;
    HomeAdapter HomeAdapter;

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
        HomeObject object = new HomeObject(1,R.drawable.profile1,R.drawable.background,"Martin Palmer",
                "What is the loop of Creation? How is there something from nothing? " +
                        "In spite of the fact that it is impossible to prove that anythin….","Today, 03:24 PM",340);

        HomeObject object2 = new HomeObject(2,R.drawable.profile1,R.drawable.img_glitters,
                "Pearl Myers","I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
                "Yesterday",290);

        HomeObject object3 = new HomeObject(3,R.drawable.profilemain,R.drawable.btn_home,"Gary Rose",
                "There is this awesome event happening. Let’s join it guys.","Yesterday",340);

        HomeObject object4 = new HomeObject(4,R.drawable.img_account,R.drawable.img_glitters,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",50);

        HomeObject object5 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_home2,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);

        HomeObject object6 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_notifications,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday", 500);

        HomeObject object7 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object8 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object9 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object10 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object11 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object12 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object13 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);
        HomeObject object14 = new HomeObject(4,R.drawable.img_account,R.drawable.btn_menu_dots,"Vernon Bradley",
                "What is the loop of Creation? How is there something from nothing?","yesterday",500);

        arrayList.add(object);
        arrayList.add(object2);
        arrayList.add(object3);
        arrayList.add(object4);
        arrayList.add(object5);
        arrayList.add(object6);
        arrayList.add(object7);
        arrayList.add(object8);
        arrayList.add(object9);
        arrayList.add(object10);
        arrayList.add(object11);
        arrayList.add(object12);
        arrayList.add(object13);
        arrayList.add(object14);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        HomeAdapter = new HomeAdapter(arrayList,getContext());
        recyclerView.setAdapter(HomeAdapter);

        recyclerView.setLayoutManager(layoutManager);
        HomeAdapter.setArrayList(arrayList);
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

    public interface IListener{
        void heartClickListener(boolean isChecked,int id);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }

    public void updateList(){
        HashMap<Integer,Boolean> checkedMap = ((Main3Activity)getActivity()).getCheckeMap();
        if(checkedMap == null) return;
        for(Integer mapId:checkedMap.keySet()){
            updateArraylist(mapId,checkedMap.get(mapId));
        }
        HomeAdapter.notifyDataSetChanged();
    }

    private void updateArraylist(Integer mapId, boolean isChecked) {
        for(HomeObject homeObject: HomeAdapter.getArrayList()){
            if(homeObject.getId() == mapId){
                int index = HomeAdapter.getArrayList().indexOf(homeObject);
                HomeAdapter.getArrayList().get(index).setChecked(isChecked);
                break;
            }
        }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        updateList();

        super.onSaveInstanceState(outState);
    }
}

