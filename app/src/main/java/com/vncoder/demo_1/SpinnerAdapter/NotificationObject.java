package com.vncoder.demo_1.SpinnerAdapter;

public class NotificationObject {
    int avatar;
    int id;
    boolean isChecked;
    String notification;

    public NotificationObject(int id,int avatar, String notification) {
        this.id = id;
        this.avatar = avatar;
        this.notification = notification;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getNotification() {
        return notification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }
}
