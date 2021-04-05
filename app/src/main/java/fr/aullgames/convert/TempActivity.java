package fr.aullgames.convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TempActivity extends AppCompatActivity {

    private float Have;
    private float Want;

    private EditText et_tempFR;
    private EditText et_tempUS;

    private Button btn_submit;
    private Button btn_deleteFR;
    private Button btn_deleteUS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        et_tempFR = findViewById(R.id.et_tempFR);
        et_tempUS = findViewById(R.id.et_tempUS);

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!et_tempFR.getText().toString().equals("")) {
                    Have = Float.valueOf(et_tempFR.getText().toString());
                    Want = (Have * 1.8f) + 32;
                    et_tempUS.setText(String.valueOf(Want));
                }else if (!et_tempUS.getText().toString().equals("")){
                    Have = Float.valueOf(et_tempUS.getText().toString());
                    Want = ((Have - 32) / 1.8f);
                    et_tempFR.setText(String.valueOf(Want));
                }
            }
        });

        btn_deleteFR = findViewById(R.id.btn_deleteFR);
        btn_deleteFR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_tempFR.setText("");
            }
        });

        btn_deleteUS = findViewById(R.id.btn_deleteUS);
        btn_deleteUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_tempUS.setText("");
            }
        });
    }
}