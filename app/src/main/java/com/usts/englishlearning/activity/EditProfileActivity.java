package com.usts.englishlearning.activity;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.usts.englishlearning.R;

public class EditProfileActivity extends AppCompatActivity {

    private static final String TAG = "tag";
    private EditText etName, etSchool, etSign;
    private int etage;
    private TextView tvBirthDay;
    private RadioButton rbBoy, rbGirl;
    private AppCompatSpinner spinnerCity;
    private String bithday;
    private String birthdayTime;
    private String[] cities;
    private int gendert;
    private int selectedCityPosition;
    private String selectedCity;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initView();
        initData();

        initEvent();
    }

    private void initView() {
        etName = findViewById(R.id.et_name_text);
        etSign = findViewById(R.id.et_sign_text);
        etSchool = findViewById(R.id.et_school_text);
        tvBirthDay = findViewById(R.id.et_birthday_text);
        rbBoy = findViewById(R.id.rb_boy);
        rbGirl = findViewById(R.id.rb_girl);
        spinnerCity = findViewById(R.id.sp_city_text);
        btnBack = findViewById(R.id.btn_back);
    }

    private void initData() {
        cities = getResources().getStringArray(R.array.cities);
        getDataFromSpf();
    }

    private void getDataFromSpf() {
        SharedPreferences spfRecord = getSharedPreferences("spfRecord", MODE_PRIVATE);
        String age = spfRecord.getString("age", "");
        String name = spfRecord.getString("name", "");
        String birthday = spfRecord.getString("birthday", "");
        String gender = spfRecord.getString("gender", "");
        String school = spfRecord.getString("school", "");
        String sign = spfRecord.getString("sign", "");
        String city = spfRecord.getString("city", "");

        etName.setText(name);
        etSign.setText(sign);
        etSchool.setText(school);

        if (gendert == 0) {
            rbBoy.setChecked(true);
        }

        if (gendert == 1) {
            rbGirl.setChecked(true);
        }

        for (int i = 0; i < cities.length; i++) {
            if (cities[i].equals(city)) {
                selectedCityPosition = i;
                break;
            }
        }
        spinnerCity.setSelection(selectedCityPosition);
    }

    private void initEvent() {
        spinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                selectedCityPosition = position;
                selectedCity = cities[position];
                Log.d(TAG, "onItemSelected: -----position-----" + position);
                Log.d(TAG, "onItemSelected: -----selectedCity-----" + selectedCity);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        tvBirthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(EditProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        int realMonth = month + 1;
                        etage = 2024 - year;
                        bithday = year + "年" + realMonth + "月" + dayOfMonth + "日";
                        tvBirthDay.setText(bithday);
                    }
                }, 2000, 10, 28).show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void save(View view) {
        String sign = etSign.getText().toString();
        String school = etSchool.getText().toString();
        String name = etName.getText().toString();
        String gender = "男";
        if (rbBoy.isChecked()) {
            gender = "男";
            gendert = 0;
        }
        if (rbGirl.isChecked()) {
            gender = "女";
            gendert = 1;
        }

        SharedPreferences spfRecord = getSharedPreferences("spfRecord", MODE_PRIVATE);
        SharedPreferences.Editor edit = spfRecord.edit();
        edit.putString("age", String.valueOf(etage));
        edit.putString("sign", sign);
        edit.putString("school", school);
        edit.putString("name", name);
        edit.putString("birthday", bithday);
        edit.putString("city", selectedCity);
        edit.putString("gender", gender);
        edit.apply();

        this.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}