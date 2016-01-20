package cn.uhei.usingtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

/**
 * Androidmanifest.xml 修改  android:theme="@style/Theme.AppCompat.Light.NoActionBar"
 */
public class MainActivity extends AppCompatActivity {
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
                if (actionBar != null) {
                    if (actionBar.isShowing()) {
                        actionBar.hide();
                    } else {
                        actionBar.show();
                    }
                }

            }
        });
    }

    //引入menu_layout.xml 样式并显示到界面上
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout, menu);

        //操作搜索
        MenuItem menuItem = menu.findItem(R.id.search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        //监听
        MenuItemCompat.setOnActionExpandListener(menuItem, new MenuItemCompat.OnActionExpandListener() {
            //搜索条展开
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                showTosat("onMenuItemActionExpand");
                return true;
            }

            //搜索条收起
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                showTosat("onMenuItemActionCollapse");
                return true;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }

    //菜单点击动作

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.favorite:
                showTosat("喜欢");
                return true;
            case R.id.setting:
                showTosat("设置");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showTosat(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
    }


    public void otherActivity(View v){
        startActivity(new Intent(this,OtherActivity.class));
    }
}
