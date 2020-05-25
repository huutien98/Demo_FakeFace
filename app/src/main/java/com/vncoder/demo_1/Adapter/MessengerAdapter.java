package com.vncoder.demo_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Object.MessengerObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;

public class MessengerAdapter extends RecyclerView.Adapter<MessengerAdapter.ViewHolder> {
    ArrayList<MessengerObject> arrayList;

    public MessengerAdapter(ArrayList<MessengerObject> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View contactView = layoutInflater.inflate(R.layout.item_messenger,parent,false);
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessengerObject messengerObject = arrayList.get(position);
        holder.img_avatar.setImageResource(messengerObject.getAvatar());
        holder.tv_time.setText(messengerObject.getTime());
        holder.tv_name.setText(messengerObject.getName());
        holder.tv_number.setText(messengerObject.getNumber()+"");
        holder.tv_messenger.setText(messengerObject.getMessenger());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_avatar;
        TextView tv_name;
        TextView tv_messenger;
        TextView tv_number;
        TextView tv_time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avatar = itemView.findViewById(R.id.img_avatar);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_messenger = itemView.findViewById(R.id.tv_messenger);
            tv_number = itemView.findViewById(R.id.tv_number);
            tv_time = itemView.findViewById(R.id.tv_time);


        }
    }
}
