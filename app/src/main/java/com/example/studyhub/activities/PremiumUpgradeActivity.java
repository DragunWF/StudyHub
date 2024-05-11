package com.example.studyhub.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;

public class PremiumUpgradeActivity extends AppCompatActivity {
    private ImageView backBtn;
    private Button subscribeBtn;

    private RadioButton gCashBtn;
    private RadioButton mayaBtn;
    private RadioButton cardBtn;

    private RadioButton monthlyBtn;
    private RadioButton yearlyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_premium_upgrade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backBtn = findViewById(R.id.premiumBackBtn);
        subscribeBtn = findViewById(R.id.subsPremiumBtn);

        gCashBtn = findViewById(R.id.subsRBtnGcash1);
        mayaBtn = findViewById(R.id.subsRBtnMaya1);
        cardBtn = findViewById(R.id.subsRBtnCard1);

        monthlyBtn = findViewById(R.id.subsRBtnMonthly1);
        yearlyBtn = findViewById(R.id.subsRBtnYearly1);

        backBtn.setOnClickListener(v -> finish());
        subscribeBtn.setOnClickListener(v -> {
            // TODO: Implement input validation
        });
    }
}