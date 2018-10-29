package com.example.layner.listaexercicio4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btProximo = findViewById(R.id.btProximo);
        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Campos
                EditText edtNome = findViewById(R.id.edtNome);
                String Nome = edtNome.getText().toString();
                EditText edtEmail = findViewById(R.id.edtEmail);
                String Email = edtEmail.getText().toString();
                EditText edtTelefone = findViewById(R.id.edtTelefone);
                String Telefone = edtTelefone.getText().toString();
                EditText edtSenha = findViewById(R.id.edtSenha);
                String Senha = edtSenha.getText().toString();

                Intent itSegundaTelaCadastro = new Intent(MainActivity.this, SegundaTelaCadastro.class);

                Bundle bundle = new Bundle();
                bundle.putString("Nome", Nome);
                bundle.putString("Email", Email);
                bundle.putString("Telefone", Telefone);
                bundle.putString("Senha", Senha);

                itSegundaTelaCadastro.putExtras(bundle);

                startActivity(itSegundaTelaCadastro);
            }
        });
    }
}
