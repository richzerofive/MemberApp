package com.abc.app.memberapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity{
    MemberService service;
    TextView tv_id,tv_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        service =  new MemberServiceImpl(getApplicationContext());
        Intent intent = getIntent();
        String id =intent.getExtras().getString("id");
        MemberBean member = service.findById(id);
        tv_id= (TextView) findViewById(R.id.tv_id);
        tv_id.setText(member.getId());
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText(member.getName());
    }

}
