package com.example.studyhub.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyhub.R;

public class VipUpgradeActivity extends AppCompatActivity {
    private Button subscribeBtn;
    private ImageView backBtn;

    private RadioButton monthlyRbtn;
    private RadioButton yearlyRbtn;

    private RadioButton gcashRbtn;
    private RadioButton mayaRbtn;
    private RadioButton cardRbtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vip_upgrade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        monthlyRbtn = findViewById(R.id.subsRBtnMonthly);
        yearlyRbtn = findViewById(R.id.subsRBtnYearly);
        gcashRbtn = findViewById(R.id.subsRBtnGcash);
        mayaRbtn = findViewById(R.id.subsRBtnMaya);
        cardRbtn = findViewById(R.id.subsRBtnCard);

        subscribeBtn = findViewById(R.id.subsVipBtn);
        backBtn = findViewById(R.id.vipBackBtn);

        setButtons();
    }

    private void setButtons() {
        backBtn.setOnClickListener(v -> finish());
        subscribeBtn.setOnClickListener(v -> {
            // TODO: Implement data passing that shows a pop up that talks about your payment
            // in the next activity
        });
    }
}