package com.vncoder.demo_1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vncoder.demo_1.Object.HomeObject;
import com.vncoder.demo_1.R;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    ArrayList<HomeObject> arrayList;

    public HomeAdapter(ArrayList<HomeObject> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.item_home,parent,false);
        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeObject homeObject = arrayList.get(position);
        holder.tv_name.setText(homeObject.getName());
        holder.tv_time.setText(homeObject.getTime());
        holder.tv_status.setText(homeObject.getStatus());
        holder.tv_money.setText(homeObject.getPay());
        holder.img_avatar.setImageResource(homeObject.getAvatar());
        holder.img_status.setImageResource(homeObject.getImage());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name;
        TextView tv_time;
        TextView tv_status;
        TextView tv_money;
        ImageView img_status;
        ImageView img_avatar;
        ToggleButton btn_heart;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_status = itemView.findViewById(R.id.tv_status);
            tv_money = itemView.findViewById(R.id.tv_money);
            img_status = itemView.findViewById(R.id.img_status);
            img_avatar = itemView.findViewById(R.id.img_avatar);
            btn_heart = itemView.findViewById(R.id.btn_heart);

            final ScaleAnimation scaleAnimation = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.7f, Animation.RELATIVE_TO_SELF, 0.7f);
            scaleAnimation.setDuration(500);
            BounceInterpolator bounceInterpolator = new BounceInterpolator();
            scaleAnimation.setInterpolator(bounceInterpolator);
            btn_heart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    btn_heart.startAnimation(scaleAnimation);
                }
            });
        }
    }
}
