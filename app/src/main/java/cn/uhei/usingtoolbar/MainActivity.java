package cn.uhei.usingtoolbar;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 *  Androidmanifest.xml 修改  android:theme="@style/Theme.AppCompat.Light.NoActionBar"
 */
public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        //use toolbar
        //import android.support.v7.widget.Toolbar;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //设为actionbar的动作条
        setSupportActionBar(toolbar);

        //匿名监听,控制Toolbar显示与隐藏
        findViewById(R.id.btnClick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ActionBar actionBar = getSupportActionBar();
                if (actionBar != null){
                    if (actionBar.isShowing()){
                        actionBar.hide();
                    }else{
                        actionBar.show();
                    }
                }

            }
        });
    }
}
