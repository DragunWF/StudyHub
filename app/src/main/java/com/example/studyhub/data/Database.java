package com.example.studyhub.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //----------------------USER-FIELDS-------------------------\\
    private final String USER_ID = "user_id";
    private final String USERNAME = "username";
    private final String PASSWORD = "password";
    private final String FIRST_NAME = "first_name";
    private final String LAST_NAME = "last_name";
    private final String COURSE = "course";
    private final String EMAIL = "email";
    private final String MOBILE_NUMBER = "mobile_number";
    private final String USER_TYPE = "user_type";
    private final String DESCRIPTION_USER = "description";
    private final String FRIENDS = "friends";
    private final String SUBSCRIPTION_ID_FK = "subscription_id";
    //----------------------USER-FIELDS-------------------------\\

    //--------------------SUBSCRIPTION-FIELDS-----------------------\\
    private final String SUBSCRIPTION_ID_PK = "subscription_id";
    private final String NAME = "name";
    private final String DESCRIPTION_SUB = "description";
    //--------------------SUBSCRIPTION-FIELDS-----------------------\\


    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
