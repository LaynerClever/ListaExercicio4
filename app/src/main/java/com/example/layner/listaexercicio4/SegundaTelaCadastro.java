package com.example.layner.listaexercicio4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class SegundaTelaCadastro extends AppCompatActivity {
    private Spinner spEstado, spCidade;
    private String Nome, Email, Telefone, Senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_tela_cadastro);

        Intent it = getIntent();
        if(it != null){
            Bundle bundle = it.getExtras();
            if (bundle != null){
                Nome = bundle.getString("Nome");
                Email = bundle.getString("Email");
                Telefone = bundle.getString("Telefone");
                Senha = bundle.getString("Senha");
            }
        }

        //Inicializar Componente Estados
        spEstado = findViewById(R.id.spEstado);

        //Populando estados manualmente
        List<String> EstadoList = new ArrayList<>();
        EstadoList.add("Minas Gerais");
        EstadoList.add("Goiás");
        EstadoList.add("São Paulo");

        ArrayAdapter<String> adapterEstados = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, EstadoList);

        adapterEstados.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstado.setAdapter(adapterEstados);

        //Inicializar Componente Cidades
        spCidade = findViewById(R.id.spCidade);

        //Populando Cidades manualmente
        List<String> CidadeList = new ArrayList<>();
        CidadeList.add("Uberlândia");
        CidadeList.add("Morrinhos");
        CidadeList.add("São Paulo");

        ArrayAdapter<String> adapterCidades = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, CidadeList);

        adapterCidades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCidade.setAdapter(adapterCidades);

        Button btConcluirCadastro = findViewById(R.id.btConcluirCadastro);

        btConcluirCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Dados",Nome.toString());
                Log.d("Dados",Telefone.toString());
                Log.d("Dados",Email.toString());
                Log.d("Dados",Senha.toString());

                //Inicializar Componente Sexo
                RadioGroup rgSexo = findViewById(R.id.RgSexo);

                //Identificar e exibir radiobutton selecionado
                int IdSelecionado = rgSexo.getCheckedRadioButtonId();
                RadioButton rbSexo = findViewById(IdSelecionado);
                Log.d("Dados", rbSexo.getText().toString());

                //Incializar Componente Idiomas
                CheckBox cbIngles = findViewById(R.id.cbIngles);
                CheckBox cbEspanhol = findViewById(R.id.cbEspanhol);
                CheckBox cbItaliano = findViewById(R.id.cbItaliano);
                CheckBox cbFrances = findViewById(R.id.cbFrances);

                    if (cbIngles.isChecked()){
                        Log.d("Dados", "Inglês");
                    }
                    if (cbEspanhol.isChecked()){
                        Log.d("Dados", "Espanhol");
                    }
                    if (cbItaliano.isChecked()){
                        Log.d("Dados","Italiano");
                    }
                    if (cbFrances.isChecked()){
                        Log.d("Dados","Francês");
                    }
                String EstadoSelecionado = spEstado.getSelectedItem().toString();
                Log.d("Dados",EstadoSelecionado);

                String CidadeSelecionada = spCidade.getSelectedItem().toString();
                Log.d("Dados",CidadeSelecionada);

                final ToggleButton tbSimNao = findViewById(R.id.tbSimNao);

                if (tbSimNao.isChecked()){
                    Log.d("Dados","Sim");
                }
                else {
                    Log.d("Dados","Não");
                }
            }
        });
    }
}
