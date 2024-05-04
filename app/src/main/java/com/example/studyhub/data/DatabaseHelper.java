package com.example.studyhub.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

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


    public DatabaseHelper(@Nullable Context context) {
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
        db.close();
    }

    /*@Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.execSQL("PRAGMA foreign_keys = ON;");
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERNAME, user.getUsername());
        cv.put(PASSWORD, user.getPassword());
        cv.put(FIRST_NAME, user.getFirstName());
        cv.put(LAST_NAME, user.getLastName());
        cv.put(COURSE, user.getCourse());
        cv.put(EMAIL, user.getEmail());
        cv.put(MOBILE_NUMBER, user.getMobileNumber());
        if (user.getDescription() != null) {
            cv.put(DESCRIPTION_USER, user.getDescription());
        }
        if (user.getFriends() != null) {
            cv.put(FRIENDS, user.getFriends());
        }
        cv.put(USER_TYPE, user.getUserType());

        db.insert(USER_TBL, null, cv);
    }

    public void addSubscription(Subscription sub) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(SUBSCRIPTION_ID_PK, sub.getSubscriptionId());
        cv.put(NAME, sub.getName());
        cv.put(DESCRIPTION_SUB, sub.getDescription());

        db.insert(SUBSCRIPTION_TBL, null, cv);
    }

    public List<User> getUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TBL, null);
        List<User> accounts = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                accounts.add(new User(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getInt(11)));
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();
        return accounts;
    }

    public List<Subscription> getSubscriptions() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SUBSCRIPTION_TBL, null);
        List<Subscription> subs = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                subs.add(new Subscription(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2)
                ));
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();
        return subs;
    }

    public User getUserById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + USER_TBL + " WHERE " + USER_ID + " = " + id, null);

        if (cursor.moveToFirst()) {
            return new User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getInt(11));
        }
        db.close();
        cursor.close();
        return null;
    }

    public Subscription getSubscriptionById (int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + SUBSCRIPTION_TBL + " WHERE " + SUBSCRIPTION_ID_PK + " = " + id, null);

        if (cursor.moveToFirst()) {
            return new Subscription(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2));
        }
        db.close();
        cursor.close();
        return null;
    }

    public void updatePassword(String currentPassword, String newPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(PASSWORD, newPassword);

        db.update(USER_TBL, cv, PASSWORD + " = ?", new String[]{currentPassword});

        db.close();
    }

    public void updateInfo(String username, String firstName, String lastName, String course, String email, String mobileNumber, String description) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        if (!username.isEmpty()) {
            cv.put(USERNAME, username);
        }
        if (!firstName.isEmpty()) {
            cv.put(FIRST_NAME, firstName);
        }
        if (!lastName.isEmpty()) {
            cv.put(LAST_NAME, lastName);
        }
        if (!course.isEmpty()) {
            cv.put(COURSE, course);
        }
        if (!email.isEmpty()) {
            cv.put(EMAIL, email);
        }
        if (!mobileNumber.isEmpty()) {
            cv.put(MOBILE_NUMBER, mobileNumber);
        }
        if (!description.isEmpty()) {
            cv.put(DESCRIPTION_USER, description);
        }

        db.update(USER_TBL, cv, USER_ID + " = " + SessionData.getCurrentUser().getId(), null);
    }
}
