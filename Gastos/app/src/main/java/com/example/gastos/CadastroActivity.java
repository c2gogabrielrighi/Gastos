package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;

public class CadastroActivity extends AppCompatActivity {

    EditText edtDespesa;
    EditText edtValor;
    EditText edtDia;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtDespesa = findViewById(R.id.edtDespesa);
        edtValor = findViewById(R.id.edtValor);
        edtDia = findViewById(R.id.edtDia);
        btnCadastrar = findViewById(R.id.btnCadastrar);


        btnCadastrar.setOnClickListener(onClick(v)){
        DbHelper db= new DbHelper(getBaseContext());
        Cadastros cadastro = new Cadastros(edtDespesa.getText().toString(),Integer.valueOf(edtValor.getText().toString()),edtDia.getText().toString());
        CadastrosDao cadastrosDao= new CadastrosDao(getBaseContext());
        String msg= cadastrosDao.cadastrar(cadastro);
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();

        });


        }
}
