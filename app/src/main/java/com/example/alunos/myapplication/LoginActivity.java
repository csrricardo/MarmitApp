package com.example.alunos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alunos.myapplication.bo.LoginBO;
import com.example.alunos.myapplication.validation.LoginValidation;

public class LoginActivity extends AppCompatActivity {

    private TextView txtCadAqui;
    private EditText edtEmail;
    private EditText edtSenha;

    private Button btnLogin;

    private SharedPreferences preferences;

    private LoginBO loginBO;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_login);
        getSupportActionBar ().hide ();

        loginBO  = new LoginBO ();

        preferences = getSharedPreferences ("pref",Context.MODE_PRIVATE);
        String email = preferences.getString ("emal", null);
        String senha = preferences.getString ("senha",  null);
        if (email != null && senha != null){
            Intent intent = new Intent (LoginActivity.this, PedidoActivity.class);
            startActivity (intent);
            finish ();
        }

        txtCadAqui = (TextView) findViewById (R.id.txtCadAqui);
        txtCadAqui.setPaintFlags (txtCadAqui.getPaintFlags () | Paint.UNDERLINE_TEXT_FLAG);
        txtCadAqui.setTextColor (Color.BLACK);

        edtEmail = (EditText) findViewById (R.id.edtEmail);
        edtSenha = (EditText) findViewById (R.id.edtSenha);
        btnLogin = (Button) findViewById (R.id.btnLogin);

        btnLogin.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText ().toString ();
                String senha = edtSenha.getText ().toString ();

                LoginValidation validation = new LoginValidation ();
                validation.setActivity (LoginActivity.this);
                validation.setEdtEmail (edtEmail);
                validation.setEdtSenha (edtSenha);
                validation.setEmail (email);
                validation.setSenha (senha);

                boolean isValido = loginBO.validarCamposLogin (validation);
                if (isValido) {
                    Intent intent = new Intent (LoginActivity.this, PedidoActivity.class);
                    startActivity (intent);
                    finish ();
                }
            }
        });
    }

    public void abrirCadastro(View view) {
        Intent intent = new Intent (this, CadastroActivity.class);
        startActivity (intent);
    }
}
