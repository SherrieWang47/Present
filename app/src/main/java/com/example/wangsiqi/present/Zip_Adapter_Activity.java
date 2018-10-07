package com.example.wangsiqi.present;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class Zip_Adapter_Activity extends AppCompatActivity {

    ListView mListView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip__adapter_);
        List<ItemBean> itemBeanList = new ArrayList<>();
        for (int i = 0;i < 20; i ++){
            //itemBeanList.add(new ItemBean(R.mipmap.ic_launcher, "标题" + i, "内容" + i));
        }
        mListView = (ListView) findViewById(R.id.lv_zip);
        //设置ListView的数据适配器
        //mListView.setAdapter(new MyAdapter(this,itemBeanList));
    }
}
