package com.vncoder.demo_1.Object;

public class HomeObject {
     private int avatar;
     private int image;
     private int id;
     private String name;
     private String status;
     private String time;
     private String pay;

    public HomeObject(String name, int avatar, int image, String status, String time, String pay) {
        this.name = name;
        this.avatar = avatar;
        this.image = image;
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

    public String getPay() {
        return pay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }
}
