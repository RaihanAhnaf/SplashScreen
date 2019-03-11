package com.example.coba.variabelparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.coba.variabelparsing.Main2Activity;
import com.example.coba.variabelparsing.R;


public class MainActivity extends AppCompatActivity {
    Button btnSubmit, btnHapus;
    EditText editNama, editTahun, editAlamat, editTelepon, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnHapus = (Button) findViewById(R.id.btnHapus);
        editNama = (EditText) findViewById(R.id.editNama);
        editTahun = (EditText) findViewById(R.id.editTahun);
        editAlamat = (EditText) findViewById(R.id.editAlamat);
        editTelepon = (EditText) findViewById(R.id.editTelepon);
        editEmail = (EditText) findViewById(R.id.editEmail);

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editNama.setText("");
                editTahun.setText("");
                editAlamat.setText("");

                editTelepon.setText("");
                editEmail.setText("");
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = editNama.getText().toString();
                String tahun = editTahun.getText().toString();
                String alamat = editAlamat.getText().toString();
                String telepon = editTelepon.getText().toString();
                String email = editEmail.getText().toString();
                if(TextUtils.isEmpty(nama)){
                    editNama.setError("Nama Tidak Boleh Kosong");
                    return;
                } else if(TextUtils.isEmpty(tahun)){
                    editTahun.setError("Tahun Tidak Boleh Kosong");
                    return;
                } else if(TextUtils.isEmpty(alamat)) {
                    editAlamat.setError("Alamat Tidak Boleh Kosong");
                    return;
                } else if(TextUtils.isEmpty(telepon)) {
                    editTelepon.setError("Telepon Tidak Boleh Kosong");
                    return;
                } else if(TextUtils.isEmpty(email)) {
                    editEmail.setError("Email Tidak Boleh Kosong");
                    return;
                }
                Intent i = null;
                i = new
                        Intent(MainActivity.this, Main2Activity.class);
                Bundle
                        b = new Bundle();
                b.putString("parse_nama", nama);
                b.putString("parse_tahun", tahun);
                b.putString("parse_alamat", alamat);
                b.putString("parse_telepon", telepon);
                b.putString("parse_email", email);
                ((Intent) i).putExtras(b);
                startActivity(i);
            }
        });
    }
}

