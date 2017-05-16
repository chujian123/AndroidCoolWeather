package com.example.liutim.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<String> dataList=new ArrayList<>();

    private List<String> provinces = Arrays.asList(new String[]{"北京市", "浙江省", "江西省"});
    private List<String>  city01 = Arrays.asList(new String[]{"北京"});
    private List<String>  city17 = Arrays.asList(new String[]{"杭州", "湖州", "嘉兴", "宁波", "绍兴"
            , "台州", "温州", "丽水", "金华", "衢州", "舟山"});

    private List<String>  country1701 = Arrays.asList(new String[]{"瓯海", "永嘉","鹿城"});
//1表示最顶层省直辖市级，2表示市级，3表现县区级
    private int level=1;
    private Button backButton =null;
    private ListView listView =null;
    private ArrayAdapter adapter;


    //选中的省或者直辖市的序号（0,1,2...)
    private int selectedProvinceIndex=0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.backButton = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listview);
        this.dataList.addAll(this.provinces);
        adapter = new ArrayAdapter<String>(this,
               android.R.layout.simple_list_item_1, this.dataList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            ///回调 callback method
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if(level==1){
                  selectedProvinceIndex=position;
                  showCities(selectedProvinceIndex);
              }else if(level==2){
                  showCounties();
              }else{
                  //TODO 选定区县，去显示天气界面
              }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level==3){
                    showCities(MainActivity.this.selectedProvinceIndex);
                }else if(level==2){
                    level=1;
                    backButton.setVisibility(View.GONE);
                    MainActivity.this.dataList.clear();
                    MainActivity.this.dataList.addAll(provinces);
                    MainActivity.this.adapter.notifyDataSetChanged();
                }



            }
        });
    }

    private void showCities(int position) {
        level=2;
        this.backButton.setVisibility(View.VISIBLE);
        this.dataList.clear();
        if("北京市".equals(this.provinces.get(position))){
            this.dataList.addAll(city01);
        }else{
            this.dataList.addAll(city17);
        }
        this.adapter.notifyDataSetChanged();
    }

    private void showCounties() {
        level=3;
        this.dataList.clear();
        this.dataList.addAll(country1701);
        adapter.notifyDataSetChanged();
    }


}
