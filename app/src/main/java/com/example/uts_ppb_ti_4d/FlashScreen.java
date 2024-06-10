package com.example.uts_ppb_ti_4d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class FlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove title bar for a cleaner splash screen experience
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_flash_screen); // Replace with your splash screen layout

        // Create a Handler to delay transition to MainActivity
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            // Start MainActivity after a delay (here, 2 seconds)
            Intent intent = new Intent(FlashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 1200); // Milliseconds until transition
    }
}
