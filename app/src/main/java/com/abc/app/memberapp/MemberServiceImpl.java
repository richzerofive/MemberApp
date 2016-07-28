package com.abc.app.memberapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hb2003 on 2016-07-27.
 */
public class MemberServiceImpl implements MemberService{
    private Map<String,MemberBean> map;
    MemberDAO dao;
    MemberBean session;

    public MemberServiceImpl(Context context) {
        dao = new MemberDAO(context);
    }

    @Override
    public MemberBean login(MemberBean mBean) {
        return null;
    }




    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {

    }
    public static MemberServiceImpl getInstance() {
        return instance;
    }

    @Override
    public String regist(MemberBean mem) {
        String msg = "";
        MemberBean temp = this.findById(mem.getId());
        if (temp == null) {
            System.out.println(mem.getId()+"가 존재하지 않음,가입 가능한 ID");
            int result = dao.insert(mem);
            if (result==1) {
                msg = "success";
            } else {
                msg = "fail";
            }
        } else {
            System.out.println(mem.getId()+"가 존재함,가입 불가능한 ID");
            msg = "fail";
        }

        return msg;
    }

    @Override
    public int update(MemberBean mBean) {
        int result= dao.updatePw(mBean);
        if(result==1){
            System.out.println("수정성공");
        }else{
            System.out.println("수정실패");
        }
        return result;
    }
    @Override
    public int delete(MemberBean mBean) {

        return dao.deleteMember(mBean);
    }
    @Override
    public int count() {
        return map.values().size();
    }
    @Override
    public MemberBean findById(String id) {
        return dao.findByPK(id);
    }
    @Override
    public List<MemberBean> findBy(String word) {
        List<MemberBean> findList = new ArrayList<MemberBean>();
        Set<?> keys = map.keySet();
        Iterator<?> it = keys.iterator();
        while(it.hasNext()){
            MemberBean tempBean = (MemberBean) map.get(it.next());
            if(tempBean.getName().equals(word)){
                findList.add(tempBean);
            }
        }
        return findList;
    }
    @Override
    public ArrayList<MemberBean> list() {
        ArrayList<MemberBean> allList = new ArrayList<MemberBean>();
        Set<?> keys = map.keySet();
        Iterator<?> it = keys.iterator();
        while(it.hasNext()){
            allList.add((MemberBean) this.map.get(it.next()));
        }

        return allList;
    }
    public MemberBean getSession() {
        return session;
    }
    public boolean checkLogin(MemberBean mBean) {
        boolean loginOk = false;
        MemberBean m = dao.findByPK(mBean.getId());
        if(m!=null && m.getPw().equals(mBean.getPw())){
            loginOk = true;
        }
        return loginOk;
    }
    @Override
    public void logOut(MemberBean mBean) {
        if(mBean.getId().equals(session.getId()) && mBean.getPw().equals(session.getPw())){
            this.session = null;
        }
    }

}
