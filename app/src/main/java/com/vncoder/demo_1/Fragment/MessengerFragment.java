package com.vncoder.demo_1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Adapter.MessengerAdapter;
import com.vncoder.demo_1.SpinnerAdapter.MessengerObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

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
        MessengerObject messengerObject1 = new MessengerObject("Jason Howard","Hahahaha… \uD83D\uDE02","5 : 45 PM",5,R.drawable.img_account);
        MessengerObject messengerObject2 = new MessengerObject("Melvin Burgess","Sounds perfect to me. \uD83D\uDE0E","5 : 45 PM",2,R.drawable.img_account);
        MessengerObject messengerObject3 = new MessengerObject("Duane McDonald","The cost is too high. Can you ple.…","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject4 = new MessengerObject("Isabella Clayton","I think, i am gonna go for it. Tha.…","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject5 = new MessengerObject("Addie Cain","Ohh yeaah! YOLO!! \uD83D\uDE0D❤️","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject6 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject7 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject8 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject9 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject10 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject11 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject12 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject13 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);
        MessengerObject messengerObject14 = new MessengerObject("Vernon Bradley4","Shall we meet today?","5 : 45 PM",8,R.drawable.img_account);



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
        arrayList.add(messengerObject10);
        arrayList.add(messengerObject11);
        arrayList.add(messengerObject12);
        arrayList.add(messengerObject13);
        arrayList.add(messengerObject14);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        MessengerAdapter adapter = new MessengerAdapter(arrayList,getContext());
        rv_messenger.setLayoutManager(layoutManager);
        rv_messenger.setAdapter(adapter);
        rv_messenger.setItemAnimator(new SlideInUpAnimator());

        setHasOptionsMenu(true);
        return view;

    }
}
