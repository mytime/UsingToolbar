package cn.uhei.usingtoolbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Created by Administrator on 2016/1/20.
 */
public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_layout);

        //use toolbar
        //import android.support.v7.widget.Toolbar;
        Toolbar toolbar = (Toolbar) findViewById(R.id.other_toolbar);
        //设为actionbar的动作条
        setSupportActionBar(toolbar);


        //回退方法
        //需要配置AndroidManifest
       ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            //启用回退
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }
}
