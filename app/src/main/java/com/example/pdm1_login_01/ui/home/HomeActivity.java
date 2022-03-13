package com.example.pdm1_login_01.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.example.pdm1_login_01.ui.login.LoginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.pdm1_login_01.R;

public class HomeActivity extends AppCompatActivity {

    Bundle pacote;
    TextView tvNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        conectarComViewport();
        receberPacote();
        apresentarNome();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginActivity();
            }
        });

    }

    private void conectarComViewport() {
        tvNome = findViewById(R.id.tv_nome);
    }

    public void receberPacote(){
        Intent i = getIntent();
        pacote = i.getExtras();
    }

    public void apresentarNome(){
        tvNome.setText("Seja bem vindo "+pacote.getString("username"));
    }

    public void goLoginActivity(){
        startActivity(new Intent(this, LoginActivity.class));
        finishAffinity();
        return;
    }
}