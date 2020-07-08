package com.vncoder.demo_1.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.vncoder.demo_1.Model.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
        public abstract UserDao getUserDao();
}
