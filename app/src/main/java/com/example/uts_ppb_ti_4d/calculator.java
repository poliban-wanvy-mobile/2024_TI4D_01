package com.example.uts_ppb_ti_4d;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class calculator extends AppCompatActivity {

    ImageButton back_button;
    EditText no1,no2;
    Button penjumlahan,pengurangan,perkalian,pembagian;
    TextView resultUts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

                back_button=findViewById(R.id.back_button1);
                no1=findViewById(R.id.input1);
                no2=findViewById(R.id.input2);
                penjumlahan=findViewById(R.id.penjumlahan);
                pengurangan=findViewById(R.id.pengurangan);
                perkalian=findViewById(R.id.perkalian);
                pembagian=findViewById(R.id.pembagian);
                resultUts=findViewById(R.id.result1);

        back_button.setOnClickListener(v -> {
            // Handle back button click (e.g., finish activity)
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        penjumlahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        pengurangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        perkalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        pembagian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
    }




    private void performOperation(String operation) {
        String input1 = no1.getText().toString();
        String input2 = no2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Masukkan Angkanya", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    Toast.makeText(this, "Tidak bisa dibagi dengan 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = num1 / num2;
                break;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        resultUts.setText(decimalFormat.format(result));


    }
}