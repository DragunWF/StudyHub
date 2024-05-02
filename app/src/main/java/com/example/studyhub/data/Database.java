package com.example.studyhub.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    //----------------------TABLE-NAMES-------------------------\\
    private final String USER_TBL = "user_tbl";
    private final String SUBSCRIPTION_TBL = "subscription_tbl";
    //----------------------TABLE-NAMES-------------------------\\

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


    public Database(@Nullable Context context) {
        super(context, "study_hub.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String subscriptionTbl = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                        ", %s TEXT NOT NULL, %s TEXT NOT NULL)"
                         , SUBSCRIPTION_TBL, SUBSCRIPTION_ID_PK, NAME, DESCRIPTION_SUB);

        String userTbl = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                                       ", %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL" +
                                       ", %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL" +
                                       ", %s TEXT, %s TEXT, %s INTEGER NOT NULL, FOREIGN KEY (%s) REFERENCES %s(%s))"
                                        , USER_TBL, USER_ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME
                                        , COURSE, EMAIL, MOBILE_NUMBER, USER_TYPE, DESCRIPTION_USER
                                        , FRIENDS, SUBSCRIPTION_ID_FK, SUBSCRIPTION_ID_FK, SUBSCRIPTION_TBL, SUBSCRIPTION_ID_PK);

        db.execSQL(subscriptionTbl);
        db.execSQL(userTbl);
        Log.d("Database", "OnCreate: Database has been created");
    }

    /*@Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.execSQL("PRAGMA foreign_keys = ON;");
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
