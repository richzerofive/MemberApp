package com.abc.app.memberapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MemberListActivity extends Activity{
    ListView lv_memberlist;
    MemberService service;
    Phone phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        service = new MemberServiceImpl(this.getApplicationContext());
        phone = new Phone(this,this);
        ArrayList<MemberBean> list = service.list();
        lv_memberlist = (ListView) findViewById(R.id.lv_memberlist);
        lv_memberlist.setAdapter(new MemberAdapter(this,list));
        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = lv_memberlist.getItemAtPosition(position);
                MemberBean member = (MemberBean) o;
                Toast.makeText(MemberListActivity.this,"선택한이름:"+member.getName(),Toast.LENGTH_LONG).show();
                phone.directCall(member.getPhone());

            }
        });
    }
    public ArrayList<MemberBean> getList(){
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();

        String[] names={
                "cupcake",
                "donut",
                "eclair",
                "froyo",
                "honeycomb",
                "icecream",
                "jellybean",
                "kitkat",
                "lollipop"
        };
        int i = 0;
        while (i<names.length) {
            MemberBean member = new MemberBean();
            member.setName(names[i]);
            member.setPhone("010-9540-1017");
            list.add(member);
            i++;
        }
        return list;
    }

}
