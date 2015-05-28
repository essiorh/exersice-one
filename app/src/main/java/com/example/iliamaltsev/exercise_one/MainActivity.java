package com.example.iliamaltsev.exercise_one;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_one=(Button)findViewById(R.id.button_one);
        Button button_two=(Button)findViewById(R.id.button_two);
        button_one.setText(getString(R.string.goto_)+" "+getString(R.string.second_activity));
        button_two.setText(getString(R.string.goto_)+" "+getString(R.string.third_activity));
        button_one.setOnClickListener(this);
        button_two.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                //This code for animation
                //SplitAnimation.startActivity(MainActivity.this, new Intent(MainActivity.this, SecondActivity.class));
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                break;
            case R.id.button_two:
                startActivity(new Intent(MainActivity.this,ThirdActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
