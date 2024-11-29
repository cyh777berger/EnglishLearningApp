package com.usts.englishlearning.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.usts.englishlearning.R;

public class UserProfileActivity extends AppCompatActivity {

    private TextView tvName,tvBirthday,tvAge,tvGender,tvCity,tvSchool,tvSign;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }


    private void initData(){
        getDataFromSpf();
    }
    private void getDataFromSpf(){
        SharedPreferences spfRecord = getSharedPreferences("spfRecord",MODE_PRIVATE);
        String name =spfRecord.getString("name","");
        String birthday =spfRecord.getString("birthday","");
        String gender =spfRecord.getString("gender","");
        String school =spfRecord.getString("school","");
        String sign =spfRecord.getString("sign","");
        String city =spfRecord.getString("city","");

        String age = getAgeByBirthDay(birthday);

        tvAge.setText(age);
        tvName.setText(name);
        tvBirthday.setText(birthday);
        tvGender.setText(gender);
        tvCity.setText(city);
        tvSign.setText(sign);
        tvSchool.setText(school);

    }
    private String getAgeByBirthDay(String birthdayTime) {
        int index = birthdayTime.indexOf("年");

        try {

            String result = birthdayTime.substring(0,index);
            int parseInt = Integer.parseInt(result);
            return String.valueOf(2024 - parseInt);

        }catch (Exception e){
            e.printStackTrace();
        }

        return "";
    }

    private void initView() {
        tvAge = findViewById(R.id.tv_age);
        tvName = findViewById(R.id.tv_name_text);
        tvBirthday = findViewById(R.id.tv_birthday_text);
        tvGender = findViewById(R.id.tv_gender);
        tvSchool = findViewById(R.id.tv_school_text);
        tvCity = findViewById(R.id.tv_city_text);
        tvSign= findViewById(R.id.tv_sign_text);
    }

    public void toEdit(View view){
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
    public void onBackPressed(View view) {
        super.onBackPressed();  // 调用系统的返回方法
    }

}

