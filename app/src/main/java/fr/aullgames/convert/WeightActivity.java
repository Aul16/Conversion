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

public class WeightActivity extends AppCompatActivity {

    private EditText et_weightFR;
    private EditText et_weightUS;

    private Button btn_submit;
    private Button btn_deleteFR;
    private Button btn_deleteUS;

    private Spinner spin_weightFR;
    private Spinner spin_weightUS;

    private float Have;
    private float Want;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        et_weightFR = findViewById(R.id.et_weightFR);
        et_weightUS = findViewById(R.id.et_weightUS);

        spin_weightFR = findViewById(R.id.spin_weightUnitFR);
        spin_weightUS = findViewById(R.id.spin_weightUnitUS);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convert("t", "lb", Have, Want, 2204.622622f);
                convert("t", "oz", Have, Want, 35273.96195f);
                convert("t", "ton", Have, Want, 0.984207f);
                convert("kg", "lb", Have, Want, 2.204623f);
                convert("kg", "oz", Have, Want, 35.273962f);
                convert("kg", "ton", Have, Want, 0.000984f);
                convert("g", "lb", Have, Want, 0.002205f);
                convert("g", "oz", Have, Want, 0.035274f);
                convert("g", "ton", Have, Want, 0.000001f);
            }
        });

        btn_deleteFR = findViewById(R.id.btn_deleteFR);
        btn_deleteFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_weightFR.setText("");
            }
        });

        btn_deleteUS = findViewById(R.id.btn_deleteUS);
        btn_deleteUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_weightUS.setText("");
            }
        });
    }

    private void convert(String spinFR, String spinUS, float _Have, float _Want, float Convert){
        if (!et_weightFR.getText().toString().equals("")) {
            _Have = Float.valueOf(et_weightFR.getText().toString());

            if (spin_weightFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_weightUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have * Convert;
                et_weightUS.setText(String.valueOf(_Want));
            }
        }else if (!et_weightUS.getText().toString().equals("")){
            _Have = Float.valueOf(et_weightUS.getText().toString());

            if (spin_weightFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_weightUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have / Convert;
                et_weightFR.setText(String.valueOf(_Want));
            }
        }
    }

}
