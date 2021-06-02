package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.testlibrary.FileTools;

import java.io.File;

public class FirstActivity extends BaseActivity {

    //control+o重写方法
    //1.重写onCreateOptionsMenu创建
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //get之后，inflate()方法创建菜单，第一个参数：通过哪个资源文件；第二个参数：指定菜单项添加到哪个menu中
        getMenuInflater().inflate(R.menu.main,menu);
        //返回TRUE，让菜单显示出来
        //return true;
        new FileTools();
        return super.onCreateOptionsMenu(menu);//返回true
    }

    //重写菜单响应事件
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

    //任何Activity都要重写onCreat()方法
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        //使用Toast
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式Intent：通过First打开Second，再通过Start执行
                //Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                //startActivity(intent);

                //隐式Intent：
                // Intent intent = new Intent("com.example.activithtest.ACTION_START");
                //报错：找不到相应的活动
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");
                // intent.addCategory("android.intent.category.DEFAULT");
                // startActivity(intent);

                //点击button1，则执行销毁一个活动的操作，等同于按下Back键
                //finish();

                //Toast上下文、Toast文本内容、Toast显示时长
                //Toast.makeText(FirstActivity.this, "You clicked Button1", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);

                //快速启动SecondActivity
                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }
        });
    }
}