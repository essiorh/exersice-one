package com.example.iliamaltsev.exercise_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Collections;


public class SecondActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplitAnimation.prepareAnimation(this);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SplitAnimation.animate(this, 1500);
        final ImageView imageView=(ImageView)findViewById(R.id.image);
        imageView.setImageResource(R.drawable.two);
        final RadioGroup radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(this,R.array.scale_names,android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        for(int i=0;i<arrayAdapter.getCount();i++)
        {
            String sRadio=arrayAdapter.getItem(i).toString();
            RadioButton radioButton=new RadioButton(this);
            radioButton.setText(sRadio);
            radioButton.setId(i);
            radioGroup.addView(radioButton);
        }
        radioGroup.check(radioGroup.getChildAt(0).getId());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ArrayList arrayList=new ArrayList();
                Collections.addAll(arrayList, getResources().getStringArray(R.array.scale_values));
                imageView.setScaleType(ImageView.ScaleType.valueOf(arrayList.get(radioGroup.getChildAt(checkedId).getId()).toString()));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    protected void onStop() {
        SplitAnimation.cancel();
        super.onStop();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
