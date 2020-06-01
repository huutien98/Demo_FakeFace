package com.vncoder.demo_1.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Adapter.NotificationAdapter;
import com.vncoder.demo_1.Object.NotificationObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;
import java.util.List;

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
        NotificationObject n1 = new NotificationObject(R.drawable.img_account,"notification 1");
        NotificationObject n2 = new NotificationObject(R.drawable.img_account,"notification 1");
        NotificationObject n3 = new NotificationObject(R.drawable.img_account,"notification 1");
        NotificationObject n4 = new NotificationObject(R.drawable.img_account,"notification 1");

        arrayList.add(n1);
        arrayList.add(n2);
        arrayList.add(n3);
        arrayList.add(n4);



        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        NotificationAdapter adapter = new NotificationAdapter(arrayList,getContext());
        rv_notification.setLayoutManager(layoutManager);
        rv_notification.setAdapter(adapter);

        return view;
    }

    public void updateList(boolean isChecked,int id){
        for(NotificationObject notificationObject: notificationAdapter.getArrayList()){
            if(notificationObject.getId() == id){
                int index = notificationAdapter.getArrayList().indexOf(notificationObject);
                notificationAdapter.getArrayList().get(index).setChecked(isChecked);
                break;
            }
        }
        notificationAdapter.notifyDataSetChanged();
    }
}
