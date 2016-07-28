package com.abc.app.memberapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hb2003 on 2016-07-28.
 */
public class MemberAdapter extends BaseAdapter{
    ArrayList<MemberBean> list;
    LayoutInflater inflater;
    int[] imgs={
            R.drawable.cupcake,
            R.drawable.donut,
            R.drawable.eclair,
            R.drawable.froyo,
            R.drawable.honeycomb,
            R.drawable.icecream,
            R.drawable.jellybean,
            R.drawable.kitkat,
            R.drawable.lollipop
    };
    public MemberAdapter(Context context, ArrayList<MemberBean>list) {
        this.list=list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View v, ViewGroup p) {
        ViewHolder holder;
        if(v==null){
            v = inflater.inflate(R.layout.member_list,null);
            holder = new ViewHolder();
            holder.ivphoto = (ImageView) v.findViewById(R.id.iv_photo);
            holder.tvname = (TextView) v.findViewById(R.id.tv_name);
            holder.tvphone = (TextView) v.findViewById(R.id.tv_phone);
            v.setTag(holder);
        }else{
            holder =(ViewHolder) v.getTag();
        }
        Log.d("사진인덱스",list.get(i).getName());
        holder.ivphoto.setImageResource(imgs[i]);
        holder.tvname.setText(list.get(i).getName());
        holder.tvphone.setText(list.get(i).getPhone());

        return v;
    }
    //inner class
    static class ViewHolder{
        ImageView ivphoto;
        TextView tvname;
        TextView tvphone;

    }
}
