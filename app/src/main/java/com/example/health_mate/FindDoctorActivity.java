package com.example.health_mate;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(view -> {
            startActivity(new android.content.Intent(FindDoctorActivity.this, HomeActivity.class));
        });
        CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(view -> {
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
            it.putExtra("title", "Family Physician");
            startActivity(it);

        });
        CardView dietician = findViewById(R.id.cardFDDitician);
        dietician.setOnClickListener(view -> {
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
            it.putExtra("title", "Dietician");
            startActivity(it);

        });
        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(view -> {
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
            it.putExtra("title", "Dentist");
            startActivity(it);

        });
        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(view -> {
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
            it.putExtra("title", "Surgeon");
            startActivity(it);

        });
        CardView cardilogists = findViewById(R.id.cardFDCardiologist);
        cardilogists.setOnClickListener(view -> {
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailActivity.class);
            it.putExtra("title", "Cardiologist");
            startActivity(it);

        });

    }

}