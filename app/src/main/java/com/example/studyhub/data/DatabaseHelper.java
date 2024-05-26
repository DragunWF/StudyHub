package com.example.studyhub.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.studyhub.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    //----------------------TABLE-NAMES-------------------------\\
    private final String USER_TBL = "user_tbl";
    private final String SUBSCRIPTION_TBL = "subscription_tbl";
    private final String REQUEST_TBL = "request_tbl";
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

    //--------------------REQUEST-FIELDS-----------------------\\
    private final String REQUEST_ID = "request_id";
    private final String SENDER_ID = "sender_id";
    private final String RECEIVER_ID = "receiver_id";
    //--------------------REQUEST-FIELDS-----------------------\\


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

        String requestTbl = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
                                          ", %s INTEGER NOT NULL, %s INTEGER NOT NULL" +
                                          ", FOREIGN KEY (%s) REFERENCES %s(%s)" +
                                          ", FOREIGN KEY (%s) REFERENCES %s(%s))"
                                           , REQUEST_TBL, REQUEST_ID, SENDER_ID, RECEIVER_ID
                                           , SENDER_ID, USER_TBL, USER_ID
                                           , RECEIVER_ID, USER_TBL, USER_ID);


        db.execSQL(subscriptionTbl);
        db.execSQL(userTbl);
        db.execSQL(requestTbl);

        try {
            String userQuery = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s) " +
                            Utils.generateUserValuesQuery(new User[]{
                                    new User("eriko123", "Eric Santos", "BSIT", "An aspiring IT Consultant"),
                                    new User("elainery", "Elaine Plarisan", "BSN", "Looking for someone to teach me anaphy and physiology ;^("),
                                    new User("randelll", "Randel Cruz", "BSCE", "Let''s build our home together ;^)"),
                                    new User("delambda", "Macaiyla Lacros", "BSEE", "lf study partner for a girly Nikola Tesla"),
                                    new User("arnoners", "Arnon Sinahunon", "BSPsych", "Let us twist our minds together and learn more"),
                                    new User("eleneya", "Elaine Garcia", "BSArch", "Build and design, lf study mate sa sb"),
                                    new User("shantidop", "Santino Morales", "BSME", "Future Iron Man lf future Pepper Potts"),
                                    new User("leslies", "Leslie Anchovy", "BSArch", "Build on and design lf study mate sa sb"),
                                    new User("lichon34", "Anita Maxwin", "BAPsych", "Let us talk about the art of emotions and learn"),
                                    new User("randyyy", "Randy Ormoc", "BSPT", "Massage after study date <3"),
                                    new User("loonzo", "Macaraig Dimagiba", "BSCS", "Dance with me on a million of algorithms"),
                                    new User("suzana", "Susan Broses", "BSIT", "Let us create an infrastructure between our hearts"),
                                    new User("ranchill", "Resketa Lastikman", "BSArch", "Gawa tayo bahay together yahhhh"),
                                    new User("kloeyyy", "Chloe Martinez", "BSBio", "Study mate only not interested in dating"),
                                    new User("janseena", "Ernin Salamanca", "BSBA", "Ambitious and Persistent"),
                                    new User("lanaya", "Lani Maskilucha", "BSCpE", "Turuan nyo ko mag solder fls"),
                                    new User("danya", "Dan Mojica", "BSTM", "Sabi ni mama kuha daw degree para may bayad ang paglipad, tama na ang greens"),
                                    new User("tonton", "Antonio Desmond", "BSHM", "Dreaming to have my own coffee shop"),
                                    new User("sandragon", "Sandra Gomez", "BSN", "LF study mate sa Manila library need help sa acads huhu"),
                                    new User("zendeya", "Zen Santos", "BSMT", "Seaman on the making"),
                                    new User("jonesbon", "Bonito Askardo", "BSA", "Di papataob kaka record ng account"),
                                    new User("remysu", "Remlin Kelnis", "BSArch", "Plates with you"),
                                    new User("andeng", "Malsita Konya", "BSTM", "Future FA lf study partner every weekend at discord"),
                                    new User("loocian", "Lucero Kapangan", "BSME", "study date please, help me with calc"),
                                    new User("jaclen", "Jacinto Len", "BSIS", "Ambition is the healthiest food"),
                                    new User("donya", "Donnalyn Daniya", "BSCE", "Need ko po tutor sa strength of materials"),
                                    new User("rin", "Renee Cordero", "BSIT", "Libre kita sb basta gawin mo Java ko"),
                                    new User("denyark", "Dennis Noly", "BSBA", "Future trillionaire"),
                                    new User("menzen", "Marco Menesses", "BSCpE", "Tech-savvy since one"),
                                    new User("anikka", "Anisa Manalac", "BSN", "Need a break from studying, so let us do it together")
                            })
                                        , USER_TBL, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, COURSE, EMAIL, MOBILE_NUMBER
                                        , USER_TYPE, DESCRIPTION_USER, SUBSCRIPTION_ID_FK);
            db.execSQL(userQuery);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
        cv.put(SUBSCRIPTION_ID_FK, user.getSubscriptionId());

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

    public List<Request> getRequest() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + REQUEST_TBL, null);
        List<Request> requests = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                requests.add(new Request(cursor.getInt(0),
                                         cursor.getInt(1),
                                         cursor.getInt(2)));
            } while(cursor.moveToNext());
        }
        return requests;
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

    public void updateUserInfo(UserUpdateInfo info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        if (info.getUsername() != null) {
            cv.put(USERNAME, info.getUsername());
        }
        if (info.getPassword() != null) {
            cv.put(PASSWORD, info.getPassword());
        }
        if (info.getFirstName() != null) {
            cv.put(FIRST_NAME, info.getFirstName());
        }
        if (info.getLastName() != null) {
            cv.put(LAST_NAME, info.getLastName());
        }
        if (info.getCourse() != null) {
            cv.put(COURSE, info.getCourse());
        }
        if (info.getEmail() != null) {
            cv.put(EMAIL, info.getEmail());
        }
        if (info.getMobileNumber() != null) {
            cv.put(MOBILE_NUMBER, info.getMobileNumber());
        }
        if (info.getDescription() != null) {
            cv.put(DESCRIPTION_USER, info.getDescription());
        }

        db.update(USER_TBL, cv, USER_ID + " = " + SessionData.getCurrentUser().getId(), null);
    }
}
