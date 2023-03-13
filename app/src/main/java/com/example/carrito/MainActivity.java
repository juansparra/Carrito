package com.example.carrito;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.carrito.Belleza.Belleza;
import com.example.carrito.Farmacia.Farmacia;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        RadioGroup radioGroup = findViewById(R.id.radio_group);
        RadioButton radioButton1 = findViewById(R.id.radio_button_1);
        RadioButton radioButton2 = findViewById(R.id.radio_button_2);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == radioButton1.getId()) {
                    Intent intent = new Intent(MainActivity.this, Farmacia.class);
                    startActivity(intent);
                } else if (selectedId == radioButton2.getId()) {
                    Intent intent = new Intent(MainActivity.this, Belleza.class);
                    startActivity(intent);
                }
            }
        });


    }
}
