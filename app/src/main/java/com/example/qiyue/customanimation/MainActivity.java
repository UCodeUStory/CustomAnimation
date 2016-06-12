package com.example.qiyue.customanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.qiyue.customanimation.activity.AnimatorSetActivity;
import com.example.qiyue.customanimation.activity.CameraActivity;
import com.example.qiyue.customanimation.activity.RatioActivity;
import com.example.qiyue.customanimation.activity.Xml4AnimActivity;

public class MainActivity extends AppCompatActivity {
    protected ListView mListView;
    protected String []items = {"matrix实现动画","camera实现3D动画","AnimatorSet设置属性动画",
            "加载xml属性动画","item5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, RatioActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, CameraActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, AnimatorSetActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Xml4AnimActivity.class));
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                }
            }
        });

    }
}
