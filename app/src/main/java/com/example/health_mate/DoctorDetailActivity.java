package com.example.health_mate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"},
                    {"Doctor Name : Dr. A. K. M. Fazlul Haque", "Hospital Address : Dhaka Medical College Hospital", "Exp: 5 years", "Contact Number : 01711-111111", "600"}
            };
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family Physician") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Cardiologist") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details5;
        btn.setOnClickListener(view -> {
            startActivity(new android.content.Intent(DoctorDetailActivity.this, FindDoctorActivity.class));
        });
        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Fee: " + doctor_details[i][4] + "tk");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

    }
}