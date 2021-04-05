package fr.aullgames.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DistanceActivity extends AppCompatActivity {

    private EditText et_distanceFR;
    private EditText et_distanceUS;

    private Button btn_submit;
    private Button btn_deleteFR;
    private Button btn_deleteUS;

    private Spinner spin_distanceFR;
    private Spinner spin_distanceUS;

    private float Have;
    private float Want;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        et_distanceFR = findViewById(R.id.et_distanceFR);
        et_distanceUS = findViewById(R.id.et_distanceUS);

        spin_distanceFR = findViewById(R.id.spin_distanceUnitFR);
        spin_distanceUS = findViewById(R.id.spin_distanceUnitUS);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    convert("km", "in", Have, Want, 39370.000000f);
                    convert("km", "ft", Have, Want, 3280.840000f);
                    convert("km", "yd", Have, Want, 1093.610000f);
                    convert("km", "mi", Have, Want, 0.621371f);
                    convert("m", "in", Have, Want, 39.370100f);
                    convert("m", "ft", Have, Want, 3.280840f);
                    convert("m", "yd", Have, Want, 1.093610f);
                    convert("m", "mi", Have, Want, 0.000621371f);
                    convert("cm", "in", Have, Want, 0.393701f);
                    convert("cm", "ft", Have, Want, 0.0328084f);
                    convert("cm", "yd", Have, Want, 0.0109361f);
                    convert("cm", "mi", Have, Want, 0.000006213712f);
            }
        });

        btn_deleteFR = findViewById(R.id.btn_deleteFR);
        btn_deleteFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_distanceFR.setText("");
            }
        });

        btn_deleteUS = findViewById(R.id.btn_deleteUS);
        btn_deleteUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_distanceUS.setText("");
            }
        });
    }

    private void convert(String spinFR, String spinUS, float _Have, float _Want, float Convert){
        if (!et_distanceFR.getText().toString().equals("")) {
            _Have = Float.valueOf(et_distanceFR.getText().toString());

            if (spin_distanceFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_distanceUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have * Convert;
                et_distanceUS.setText(String.valueOf(_Want));
            }
        }else if (!et_distanceUS.getText().toString().equals("")){
            _Have = Float.valueOf(et_distanceUS.getText().toString());

            if (spin_distanceFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_distanceUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have / Convert;
                et_distanceFR.setText(String.valueOf(_Want));
            }
        }
    }

}
