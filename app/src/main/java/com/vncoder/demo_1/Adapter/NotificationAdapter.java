package com.vncoder.demo_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Object.NotificationObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {
    private ArrayList<NotificationObject> arrayList;
    private Context context;

    public NotificationAdapter(ArrayList<NotificationObject> arrayList,Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    public void setArrayList(ArrayList<NotificationObject> arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    public ArrayList<NotificationObject> getArrayList() {
        return arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_notification,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         NotificationObject notificationObject = arrayList.get(position);
         holder.img_avatar.setImageResource(notificationObject.getAvatar());
         holder.tv_notification.setText(notificationObject.getNotification());
         holder.btn_1.setChecked(notificationObject.isChecked());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_avatar;
        TextView tv_notification;
        ToggleButton btn_1;
        ToggleButton btn_2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avatar = itemView.findViewById(R.id.img_avatar);
            tv_notification = itemView.findViewById(R.id.tv_notification);
            btn_1 = itemView.findViewById(R.id.btn_1);
            //btn_2 = itemView.findViewById(R.id.btn_2);

        }
    }
}
