package com.example.health_mate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnAddToCart, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        tvPackageName = findViewById(R.id.textViewLDTitle2);
        tvTotalCost = findViewById(R.id.textViewLDTotal);
        edDetails = findViewById(R.id.editTextLD);
        btnAddToCart = findViewById(R.id.buttonLDCart);
        btnBack = findViewById(R.id.buttonLDBack);
        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        tvTotalCost.setText("Total Cost : " + intent.getStringExtra("text2") + "tk");
        edDetails.setText(intent.getStringExtra("text3"));

        btnBack.setOnClickListener(v -> {
            startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
        });

        btnAddToCart.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "").toString();
            String product = tvPackageName.getText().toString();
            float price = Float.parseFloat(intent.getStringExtra("text3").toString());
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);
            if (db.checkCart(username, product) == 1) {
                Toast.makeText(this, "Already Added to Cart", Toast.LENGTH_SHORT).show();
            } else {
                db.addCart(username, product, price, "lab");
                Toast.makeText(this, "Added to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
            //startActivity(new Intent(LabTestDetailsActivity.this, CartActivity.class));
        });


    }
}