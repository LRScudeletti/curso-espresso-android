package br.com.lrssoftwares.expressoandroidtests;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class  LoginActivity extends AppCompatActivity {

    public String usuarioInformado = "Teste";
    public String senhaInformada = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.tela_login));
        }

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(view -> {
            EditText edtUsuario = findViewById(R.id.edtUsuario);
            EditText edtSenha = findViewById(R.id.edtSenha);

            if (!edtUsuario.getText().toString().equals("") && !edtSenha.getText().toString().equals("")) {
                login(view, edtUsuario.getText().toString(), edtSenha.getText().toString());
            } else {
                Snackbar.make(view, getString(R.string.preencha_todos_campos_login), Snackbar.LENGTH_LONG).setAction("", null).show();
            }
        });

        FloatingActionButton fabCadastrarUsuario = findViewById(R.id.fabCadastrarUsuario);
        fabCadastrarUsuario.setOnClickListener(view -> {
            //Intent intentCadastrarUsuario = new Intent(LoginActivity.this, CadastroUsuarioActivity.class);
            //startActivity(intentCadastrarUsuario);
        });
    }

    private void login(View view, String usuario, String senha) {
        if (usuario.equals(usuarioInformado) && senha.equals(senhaInformada)) {
            Intent intentEntrar = new Intent(LoginActivity.this, PrincipalActivity.class);
            startActivity(intentEntrar);
        } else {
            Snackbar.make(view, getString(R.string.usuario_senha_invalidos), Snackbar.LENGTH_LONG).setAction("", null).show();
        }
    }
}