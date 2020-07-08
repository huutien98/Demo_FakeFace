package com.vncoder.demo_1.SpinnerAdapter;

public class MessengerObject {
    String name;
    String messenger;
    String time;
    int number;
    int avatar;

    public MessengerObject(String name, String messenger, String time, int number, int avatar) {
        this.name = name;
        this.messenger = messenger;
        this.time = time;
        this.number = number;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
