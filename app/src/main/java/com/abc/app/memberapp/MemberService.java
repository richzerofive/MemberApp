package com.abc.app.memberapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2003 on 2016-07-27.
 */
public interface MemberService {
    public String regist(MemberBean mBean);
    public int update(MemberBean mBean);
    public int delete(MemberBean mBean);
    public MemberBean findById(String id);
    public MemberBean login(MemberBean mBean);
    public void logOut(MemberBean mBean);
    public MemberBean getSession();
    public int count();
    public ArrayList<MemberBean> list();
    public List<MemberBean> findBy(String word);

}
