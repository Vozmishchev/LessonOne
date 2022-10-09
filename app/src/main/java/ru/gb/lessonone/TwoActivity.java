package ru.gb.lessonone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Button btnTwoActivity = findViewById(R.id.btn_two_activity);
        EditText personNameEditText = findViewById(R.id.personName_edit_text);
        EditText emailAddressEditText = findViewById(R.id.emailAddress_edit_text);
        EditText phoneNumberEditText = findViewById(R.id.phoneNumber_edit_text);

        btnTwoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (personNameEditText.getText().toString().trim().equals("")) {
                    Toast.makeText(TwoActivity.this, "Введите ФИО", Toast.LENGTH_LONG).show();
                }
                 else if (emailAddressEditText.getText().toString().trim().equals("")) {
                    Toast.makeText(TwoActivity.this, "Введите e-mail", Toast.LENGTH_LONG).show();
                }
                else if (phoneNumberEditText.getText().toString().trim().equals("")) {
                    Toast.makeText(TwoActivity.this, "Введите номер телефона", Toast.LENGTH_LONG).show();
                } else {

                    Intent intent = new Intent(TwoActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }


}
