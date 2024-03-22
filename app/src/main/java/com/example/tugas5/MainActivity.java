package com.example.tugas5;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextInputEditText tetNamaPembeli = findViewById(R.id.tetNamaPembeli);
        TextInputEditText tetKodeBarang = findViewById(R.id.tetKodeBarang);
        TextInputEditText tetJumlahBarang = findViewById(R.id.tetJumlahBarang);
        tetJumlahBarang.setInputType(InputType.TYPE_CLASS_NUMBER);
        RadioGroup rgMember = findViewById(R.id.rgMember);
        Button btnProses = findViewById(R.id.btnProses);
        Button btnReset = findViewById(R.id.btnReset);


        btnProses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaPembeli = tetNamaPembeli.getText().toString();
                int selectedId = rgMember.getCheckedRadioButtonId();
                RadioButton rbSelected = findViewById(selectedId);
                String tipeMember = rbSelected != null ? rbSelected.getText().toString() : "";
                String kodeBarang = tetKodeBarang.getText().toString().toUpperCase();
                String jumlahBarangStr = tetJumlahBarang.getText().toString();

                if (namaPembeli.isEmpty() || tipeMember.isEmpty() || kodeBarang.isEmpty() || jumlahBarangStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Harap lengkapi semua input", Toast.LENGTH_SHORT).show();
                    return;
                }

                int jumlahBarang = Integer.parseInt(jumlahBarangStr);

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("namaPembeli", namaPembeli);
                intent.putExtra("tipeMember", tipeMember);
                intent.putExtra("kodeBarang", kodeBarang);
                intent.putExtra("jumlahBarang", jumlahBarang);

                startActivity(intent);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tetNamaPembeli.setText("");
                tetKodeBarang.setText("");
                tetJumlahBarang.setText("");
                rgMember.clearCheck();
            }
        });
    }
}