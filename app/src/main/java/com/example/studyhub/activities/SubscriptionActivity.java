package com.example.studyhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;

public class SubscriptionActivity extends AppCompatActivity {
    private TextView currentSubscriptionPlan;
    private ImageView backBtn;

    private Button vipUpgradeBtn;
    private Button premiumUpgradeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subscription);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // TODO: Implement a way to get the current user's subscription plan
        // and display it on the current subscription text.

        currentSubscriptionPlan = findViewById(R.id.displayCurrentSubs);
        setButtons();
    }

    private void setButtons() {
        backBtn = findViewById(R.id.subsBackBtn);
        vipUpgradeBtn = findViewById(R.id.subsUpgradeVipBtn);
        premiumUpgradeBtn = findViewById(R.id.subsUpgradePremiumBtn);

        backBtn.setOnClickListener(v -> {
            finish();
        });
        vipUpgradeBtn.setOnClickListener(v -> {
            startActivity(new Intent(SubscriptionActivity.this, VipUpgradeActivity.class));
        });
        premiumUpgradeBtn.setOnClickListener(v -> {
            startActivity(new Intent(SubscriptionActivity.this, PremiumUpgradeActivity.class));
        });
    }
}