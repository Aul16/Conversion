package fr.aullgames.convert;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_distance;
    private Button btn_suface;
    private Button btn_volume;
    private Button btn_masse;
    private Button btn_temperature;
    private Button btn_money;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_distance = findViewById(R.id.btn_distance);
        btn_suface = findViewById(R.id.btn_surface);
        btn_volume = findViewById(R.id.btn_volume);
        btn_masse = findViewById(R.id.btn_masse);
        btn_temperature = findViewById(R.id.btn_temperature);
        btn_money = findViewById(R.id.btn_money);

        btn_distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DistanceActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_suface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SurfaceActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VolumeActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_masse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeightActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        btn_temperature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TempActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        btn_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MoneyActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}