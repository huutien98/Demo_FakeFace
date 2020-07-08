package com.vncoder.demo_1.SpinnerAdapter;

public class HomeObject {
     private int avatar;
     private int image;
     private int id;
     private String name;
     private String status;
     private String time;
     private float pay;
    boolean isChecked;
    public HomeObject(int id,int avatar, int image,  String name, String status, String time, float pay) {
        this.id = id;
        this.avatar = avatar;
        this.image = image;
        this.name = name;
        this.status = status;
        this.time = time;
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Float getPay() {
        return pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
