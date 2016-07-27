package com.abc.app.memberapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hb2003 on 2016-07-27.
 */
    public class MemberDAO extends SQLiteOpenHelper{

    public MemberDAO(Context context) {
        super(context, "", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public int insert(MemberBean bean){
        int result = 0;
        String sql = "insert into member(id,pw,name,reg_date,ssn,email,profile_img,phone)"
                + "values(?,?,?,?,?,?,?,?)";

        try {

            result = 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public int updatePw(MemberBean mBean){
        int result = 0;
        String sql = "UPDATE MEMBER SET PW=?,EMAIL=? WHERE ID=?";

        return result;
    }
    public int deleteMember(MemberBean bean){
        int result = 0;
        String sql = "DELETE FROM MEMBER WHERE ID=?";

        return result;
    }
    public MemberBean findByPK(String pk){
        String sql = "select * from member where id = ?";
        MemberBean temp = null;

        return temp;
    }
    public Map<String, MemberBean> selectMap() {
        Map<String, MemberBean> memberMap = new HashMap<String,MemberBean>();
        String sql = "SELECT * FROM MEMBER";



        return memberMap;
    }

}
