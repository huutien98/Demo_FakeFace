package com.vncoder.demo_1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Adapter.NotificationAdapter;
import com.vncoder.demo_1.MainActivity.Main3Activity;
import com.vncoder.demo_1.Object.NotificationObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;
import java.util.HashMap;

public class NotificationFragment extends Fragment {
    RecyclerView rv_notification;
    ArrayList<NotificationObject> arrayList;
    NotificationAdapter notificationAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notification_fragment, container, false);

        rv_notification = view.findViewById(R.id.rv_notification);
        arrayList = new ArrayList<>();
        NotificationObject n1 = new NotificationObject(1,R.drawable.img_account,"notification 1");
        NotificationObject n2 = new NotificationObject(2,R.drawable.img_account,"notification 1");
        NotificationObject n3 = new NotificationObject(3,R.drawable.img_account,"notification 1");
        NotificationObject n4 = new NotificationObject(4,R.drawable.img_account,"notification 1");

        arrayList.add(n1);
        arrayList.add(n2);
        arrayList.add(n3);
        arrayList.add(n4);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        notificationAdapter = new NotificationAdapter(arrayList,getContext());
        rv_notification.setLayoutManager(layoutManager);
        rv_notification.setAdapter(notificationAdapter);
        notificationAdapter.setArrayList(arrayList);

        return view;
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
        notificationAdapter.notifyDataSetChanged();
    }

    private void updateArraylist(Integer mapId, boolean isChecked) {
        for(NotificationObject notificationObject: notificationAdapter.getArrayList()){
            if(notificationObject.getId() == mapId){
                int index = notificationAdapter.getArrayList().indexOf(notificationObject);
                notificationAdapter.getArrayList().get(index).setChecked(isChecked);
                break;
            }
        }
    }
}
