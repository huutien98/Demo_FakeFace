package com.vncoder.demo_1.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Adapter.MessengerAdapter;
import com.vncoder.demo_1.Object.MessengerObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;

public class MessengerFragment extends Fragment {
    RecyclerView rv_messenger;
    ArrayList<MessengerObject> arrayList;
   Toolbar toolbar_messenger;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.messenger_fragment, container, false);
        rv_messenger = view.findViewById(R.id.rv_messenger);
        toolbar_messenger = view.findViewById(R.id.toolbar_messenger);


       if (toolbar_messenger != null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar_messenger);
            ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        arrayList = new ArrayList<>();
        MessengerObject messengerObject = new MessengerObject("Vernon Bradley1","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject1 = new MessengerObject("Vernon Bradley2","Shall we meet today?","5 : 45 PM",5,R.drawable.img_account);
        MessengerObject messengerObject2 = new MessengerObject("Vernon Bradley3","Shall we meet today?","5 : 45 PM",2,R.drawable.img_account);
        MessengerObject messengerObject3 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject4 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject5 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject6 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject7 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject8 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject9 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);

        arrayList.add(messengerObject);
        arrayList.add(messengerObject1);
        arrayList.add(messengerObject2);
        arrayList.add(messengerObject3);
        arrayList.add(messengerObject4);
        arrayList.add(messengerObject5);
        arrayList.add(messengerObject6);
        arrayList.add(messengerObject7);
        arrayList.add(messengerObject8);
        arrayList.add(messengerObject9);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        MessengerAdapter adapter = new MessengerAdapter(arrayList);
        rv_messenger.setLayoutManager(layoutManager);
        rv_messenger.setAdapter(adapter);

        setHasOptionsMenu(true);
        return view;

    }
}
