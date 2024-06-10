package com.example.uts_ppb_ti_4d;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityMenu extends AppCompatActivity {
     LinearLayout clickable_calculator, clickable_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        // Add Toolbar and inflate menu
        clickable_calculator=findViewById(R.id.clickable_calculator);
        clickable_about=findViewById(R.id.clickable_about);



        clickable_calculator.setOnClickListener(v -> {
            Intent intent = new Intent(this, calculator.class);  // Replace with your Calculator activity name
            startActivity(intent);
        });

        clickable_about.setOnClickListener(v -> {
            Intent intent = new Intent(this, AboutUs.class);  // Replace with your About Us activity name
            startActivity(intent);
        });



    }
}
