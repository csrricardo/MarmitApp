package com.example.alunos.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtNomeCadastro, edtEmailCadastro, edtSenhaCadastro, edtConfirmaSenha;
    private Button btnSalvarCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_cadastro);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
        getSupportActionBar ().setTitle ("Cadastro");

        edtNomeCadastro = (EditText) findViewById (R.id.edtNomeCadastro);
        edtEmailCadastro  = (EditText) findViewById (R.id.edtEmailCadastro);
        edtSenhaCadastro = (EditText)findViewById (R.id.edtSenhaCadastro);
        edtConfirmaSenha = (EditText)findViewById (R.id.edtConfirmaSenha);
        btnSalvarCadastro  = (Button)findViewById (R.id.btnConfirmaPedido);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == android.R.id.home) {
            this.finish ();
        }
        return super.onOptionsItemSelected (item);
    }
}
