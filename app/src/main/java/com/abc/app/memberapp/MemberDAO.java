package com.abc.app.memberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hb2003 on 2016-07-27.
 */
    public class MemberDAO extends SQLiteOpenHelper {


    public static final String TABLE_NAME = "member";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME= "name";
    public static final String SSN = "ssn";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    public MemberDAO(Context context) {
        super(context, "hanbitdb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =  "create table if not exists "
                +TABLE_NAME
                +" ( "
                +ID+" text primary key, "
                +PW+" text, "
                +NAME+" text, "
                +SSN+" text, "
                +EMAIL+" text, "
                +PHONE+" text ";

       db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists " + TABLE_NAME;
        db.execSQL("");
    }

    public int insert(MemberBean bean) {
        int result = 0;
        String sql = "insert into member(id,pw,name,reg_date,ssn,email,profile_img,phone)"
                + "values(?,?,?,?,?,?,?,?)";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("");

        try {

            result = 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public int updatePw(MemberBean mBean) {
        int result = 0;
        String sql = "UPDATE MEMBER SET PW=?,EMAIL=? WHERE ID=?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    public int deleteMember(MemberBean bean) {
        int result = 0;
        String sql = "DELETE FROM MEMBER WHERE ID=?";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        return result;
    }

    public MemberBean findByPK(String pk) {
        String sql = "select * from member where id = ?";
        MemberBean temp = null;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return temp;
    }

    public List<MemberBean> list() {
        String sql = "select * from member";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return null;

    }

    public Map<String, MemberBean> selectMap() {
        Map<String, MemberBean> memberMap = new HashMap<String, MemberBean>();
        String sql = "SELECT * FROM MEMBER";
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);
        return memberMap;
    }

    public boolean existId(String id) {
        boolean existOK = false;
        String sql = "select count(*) as count from member where id = ?";
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL(sql);

        if(result == 1){
            existOK = true;
        }
        return existOK;
    }

    }
