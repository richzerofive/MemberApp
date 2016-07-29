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
    public boolean login(MemberBean mBean) {
        return dao.login(mBean);
    }

    private static MemberServiceImpl instance = new MemberServiceImpl();

    private MemberServiceImpl() {

    }
    public static MemberServiceImpl getInstance() {
        return instance;
    }

    @Override
    public void regist(MemberBean mem) {
        dao.insert(mem);
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
        return dao.list();
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
