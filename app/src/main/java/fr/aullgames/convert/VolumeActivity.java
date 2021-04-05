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

public class VolumeActivity extends AppCompatActivity {

    private EditText et_volumeFR;
    private EditText et_volumeUS;

    private Button btn_submit;
    private Button btn_deleteFR;
    private Button btn_deleteUS;

    private Spinner spin_volumeFR;
    private Spinner spin_volumeUS;

    private float Have;
    private float Want;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        et_volumeFR = findViewById(R.id.et_volumeFR);
        et_volumeUS = findViewById(R.id.et_volumeUS);

        spin_volumeFR = findViewById(R.id.spin_volumeUnitFR);
        spin_volumeUS = findViewById(R.id.spin_volumeUnitUS);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convert("km³", "tsp", Have, Want, 202884136211058f);
                convert("km³", "tbsp", Have, Want, 67628045403686f);
                convert("km³", "cp", Have, Want, 4226752837730.375f);
                convert("km³", "gal", Have, Want, 264172052358.14844f);
                convert("km³", "pt", Have, Want, 2113376418865.1875f);
                convert("km³", "qt", Have, Want, 1056688209432.5938f);
                convert("m³", "tsp", Have, Want, 202884.136211f);
                convert("m³", "tbsp", Have, Want, 67628.045404f);
                convert("m³", "cp", Have, Want, 4226.752838f);
                convert("m³", "gal", Have, Want, 264.172052f);
                convert("m³", "pt", Have, Want, 2113.376419f);
                convert("m³", "qt", Have, Want, 1056.688209f);
                convert("cm³", "tsp", Have, Want, 0.202884f);
                convert("cm³", "tbsp", Have, Want, 0.067628f);
                convert("cm³", "cp", Have, Want, 0.004227f);
                convert("cm³", "gal", Have, Want, 0.000264f);
                convert("cm³", "pt", Have, Want, 0.002112f);
                convert("cm³", "qt", Have, Want, 0.001056f);
                convert("L", "tsp", Have, Want, 202.884136f);
                convert("L", "tbsp", Have, Want, 67.628045f);
                convert("L", "cp", Have, Want, 4.226753f);
                convert("L", "gal", Have, Want, 0.264172f);
                convert("L", "pt", Have, Want, 2.113376f);
                convert("L", "qt", Have, Want, 1.056688f);
                convert("cl", "tsp", Have, Want, 2.028841f);
                convert("cl", "tbsp", Have, Want, 0.67628f);
                convert("cl", "cp", Have, Want, 0.042268f);
                convert("cl", "gal", Have, Want, 0.002642f);
                convert("cl", "pt", Have, Want, 0.021134f);
                convert("cl", "qt", Have, Want, 0.010567f);
            }
        });

        btn_deleteFR = findViewById(R.id.btn_deleteFR);
        btn_deleteFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_volumeFR.setText("");
            }
        });

        btn_deleteUS = findViewById(R.id.btn_deleteUS);
        btn_deleteUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_volumeUS.setText("");
            }
        });
    }

    private void convert(String spinFR, String spinUS, float _Have, float _Want, float Convert){
        if (!et_volumeFR.getText().toString().equals("")) {
            _Have = Float.valueOf(et_volumeFR.getText().toString());

            if (spin_volumeFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_volumeUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have * Convert;
                et_volumeUS.setText(String.valueOf(_Want));
            }
        }else if (!et_volumeUS.getText().toString().equals("")){
            _Have = Float.valueOf(et_volumeUS.getText().toString());

            if (spin_volumeFR.getSelectedItem().toString().equals(spinFR) &&
                    spin_volumeUS.getSelectedItem().toString().equals(spinUS)) {
                _Want = _Have / Convert;
                et_volumeFR.setText(String.valueOf(_Want));
            }
        }
    }

}
