package com.example.liutim.coolweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by liutim on 2017/5/5.
 */

public class CityActivity extends AppCompatActivity {
    private String[] city01 = {"北京"};
    private String[] city17 = {"杭州", "湖州", "嘉兴", "宁波", "绍兴"
            , "台州", "温州", "丽水", "金华", "衢州", "舟山"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String p=getIntent().getStringExtra("p");
        String[] data=null;
        if("北京市".equals(p)){
            data=city01;
        }else if("浙江省".equals(p)){
            data=city17;
        }

        TextView tv= (TextView) findViewById(R.id.textView);
        tv.setText(p);
        ListView listView = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(CityActivity.this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

    }
}