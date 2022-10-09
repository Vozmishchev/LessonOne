package ru.gb.lessonone;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Switch switchBtn;
    private Button btn;
    private CalendarView calendarView;
    private CheckBox therapistCheck;
    private CheckBox surgeonCheck;
    private CheckBox orthopedistCheck;
    private ToggleButton toggleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        switchBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean on) {
                if (on) {
                    switchBtn.setTextColor(Color.BLUE);
                } else {
                    switchBtn.setTextColor(Color.BLACK);
                }

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                Toast.makeText(getApplicationContext(), "Дата вашей записи к врачу:" +
                        "\n" + "Year: "
                        + year + "\n" + "Month: " + (month + 1) + "\n" + "Day: "
                        + day, Toast.LENGTH_SHORT).show();
            }
        });

        therapistCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                surgeonCheck.setChecked(false);
                orthopedistCheck.setChecked(false);
            }
        });
        surgeonCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                therapistCheck.setChecked(false);
                orthopedistCheck.setChecked(false);
            }
        });
        orthopedistCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                therapistCheck.setChecked(false);
                surgeonCheck.setChecked(false);
            }
        });

        toggleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Вы записаны!", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void initView() {
        switchBtn = findViewById(R.id.switch_btn);
        btn = findViewById(R.id.btn);
        calendarView = findViewById(R.id.calendar_view);
        therapistCheck = findViewById(R.id.therapist_check);
        surgeonCheck = findViewById(R.id.surgeon_check);
        orthopedistCheck = findViewById(R.id.orthopedist_check);
        toggleBtn = findViewById(R.id.toggle_btn);
    }
}