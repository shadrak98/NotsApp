package com.kodery.calden.newsession;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

public class filler extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<String> msglist=new ArrayList<String>();
    ArrayList<String> msglistid=new ArrayList<String>();
    ArrayList<String> listofemp=new ArrayList<String>();

    public filler(Context context, Dictionary msg){
        this.context=context;
        layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
/*
        for (Enumeration i = msg.elements(); i.hasMoreElements();)
        {
            msglist.add(i.nextElement().toString());
        }
*/
        for (Enumeration k = msg.keys(); k.hasMoreElements();)
        {
            String temp=k.nextElement().toString();
            msglistid.add(temp);
            msglist.add(temp+" "+msg.get(temp));
        }
/*
        for(int i=0;i<msg.size();i++)
        {
            msglist.add(msg.get(i));
        }
        */
    }

    @Override
    public int getCount() {
        return msglist.size();
    }

    @Override
    public Object getItem(int i) {
        return msglist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.activity_filler,null);
        final TextView txtView=(TextView)view.findViewById(R.id.txtView);
        txtView.setText(msglist.get(i));



        view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String temp=txtView.getText().toString();
                if(temp.contains(" ")){
                    temp= temp.substring(0, temp.indexOf(" "));
                }

                //listofemp.add(temp);
                newSession.getInstance().setme(temp);
            }
        });



        return view;

    }



}
