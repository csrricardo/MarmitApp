package com.example.alunos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class AddressPaymentActivity extends AppCompatActivity {

    private CheckBox ckbEntrega = null;
    private CheckBox ckbRetirarLocal = null;
    private CheckBox ckbCartao = null;
    private CheckBox ckbDinheiro = null;

    private EditText edtNome = null;
    private EditText edtRua = null;
    private EditText edtNumero = null;
    private EditText edtBairro = null;

    private TextView txtTotalResultado = null;
    private Button btnFinalizar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_address_payment);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
        getSupportActionBar ().setTitle ("Endereço / Pagamento");
        addListenerOnClick ();

        edtNome.setEnabled (false);
        edtRua.setEnabled (false);
        edtNumero.setEnabled (false);
        edtBairro.setEnabled (false);
        ckbCartao.setEnabled (false);
        ckbDinheiro.setEnabled (false);

        btnFinalizar.setEnabled (false);
        btnFinalizar.setText ("ESCOLHER CARTÃO OU DINHEIRO");
        btnFinalizar.setBackgroundResource (R.color.colorGray);

        txtTotalResultado = (TextView) findViewById (R.id.txtTotalResultado);

        Intent intent = getIntent ();

        Bundle bundle = intent.getExtras ();

        if (bundle != null) {
            String total = bundle.getString ("TOTAL A PAGAR");
            txtTotalResultado.setText (total);
        }
    }

    private void addListenerOnClick() {

        ckbEntrega = (CheckBox) findViewById (R.id.ckbEntrega);
        ckbRetirarLocal = (CheckBox) findViewById (R.id.ckbRetirarLocal);
        ckbCartao = (CheckBox) findViewById (R.id.ckbCartao);
        ckbDinheiro = (CheckBox) findViewById (R.id.ckbDinheiro);
        edtNome = (EditText) findViewById (R.id.edtNome);
        edtRua = (EditText) findViewById (R.id.edtRua);
        edtNumero = (EditText) findViewById (R.id.edtNumero);
        edtBairro = (EditText) findViewById (R.id.edtBairro);
        btnFinalizar = (Button) findViewById (R.id.btnFinalizar);

        final String nome = edtNome.getText ().toString ();
        String rua = edtRua.getText ().toString ();
        String numero = edtNumero.getText ().toString ();
        String bairro = edtBairro.getText ().toString ();

        ckbEntrega.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ckbEntrega.isChecked ()) {
                    ckbEntrega.setChecked (true);
                    ckbRetirarLocal.setChecked (false);
                    edtNome.setFilters (new InputFilter[]{new InputFilter.AllCaps ()});
                    edtNome.setEnabled (true);
                    edtRua.setFilters (new InputFilter[]{new InputFilter.AllCaps ()});
                    edtRua.setEnabled (true);
                    edtNumero.setEnabled (true);
                    edtBairro.setFilters (new InputFilter[]{new InputFilter.AllCaps ()});
                    edtBairro.setEnabled (true);
                    edtNome.setError ("Campo Obrigatorio!");
                    edtRua.setError ("Campo Obrigatorio!");
                    edtNumero.setError ("Campo Obrigatorio!");
                    edtBairro.setError ("Campo Obrigatorio!");
                    ckbCartao.setEnabled (true);
                    ckbDinheiro.setEnabled (true);
                } else {
                    edtNome.setEnabled (false);
                    edtNome.setText ("");
                    edtRua.setEnabled (false);
                    edtRua.setText ("");
                    edtNumero.setEnabled (false);
                    edtNumero.setText ("");
                    edtBairro.setEnabled (false);
                    edtBairro.setText ("");
                    edtNome.setError (null);
                    edtRua.setError (null);
                    edtNumero.setError (null);
                    edtBairro.setError (null);
                    ckbCartao.setEnabled (false);
                    ckbDinheiro.setEnabled (false);
                }
            }
        });
        ckbRetirarLocal.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ckbRetirarLocal.isChecked ()) {
                    ckbRetirarLocal.setChecked (true);
                    ckbEntrega.setChecked (false);
                    edtNome.setFilters (new InputFilter[]{new InputFilter.AllCaps ()});
                    edtNome.setEnabled (true);
                    edtNome.setError ("Campo Obrigatorio!");
                    ckbCartao.setEnabled (true);
                    ckbDinheiro.setEnabled (true);
                } else {
                    edtNome.setEnabled (false);
                    edtNome.setText ("");
                    edtNome.setError (null);
                    ckbCartao.setEnabled (false);
                    ckbDinheiro.setEnabled (false);
                }
            }
        });
        ckbCartao.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ckbCartao.isChecked ()) {
                    ckbCartao.setChecked (true);
                    ckbDinheiro.setChecked (false);
                    btnFinalizar.setEnabled (true);
                    btnFinalizar.setText ("FINALIZAR PEDIDO");
                    btnFinalizar.setBackgroundResource (R.color.colorPrimary);
                } else {
                    btnFinalizar.setEnabled (false);
                    btnFinalizar.setText ("ESCOLHER CARTÃO OU DINHEIRO");
                    btnFinalizar.setBackgroundResource (R.color.colorGray);
                }
            }
        });
        ckbDinheiro.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener () {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ckbDinheiro.isChecked ()) {
                    ckbDinheiro.setChecked (true);
                    ckbCartao.setChecked (false);
                    btnFinalizar.setEnabled (true);
                    btnFinalizar.setText ("FINALIZAR PEDIDO");
                    btnFinalizar.setBackgroundResource (R.color.colorPrimary);
                } else {
                    btnFinalizar.setEnabled (false);
                    btnFinalizar.setText ("ESCOLHER CARTÃO OU DINHEIRO");
                    btnFinalizar.setBackgroundResource (R.color.colorGray);
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == android.R.id.home) {
            this.finish ();
        }
        return super.onOptionsItemSelected (item);
    }

    public void abrirFinalizar(View view) {
        vibrate ();
        String nome = edtNome.getText ().toString ().trim ();
        String total = txtTotalResultado.getText ().toString ().trim ();
        Intent intent = new Intent (getApplication (), FinalizarActivity.class);
        Bundle bundle = new Bundle ();

        bundle.putString ("NOME", nome);
        bundle.putString ("TOTAL", total);
        intent.putExtras (bundle);
        startActivity (intent);
    }

    private void vibrate(){
        Vibrator vibrator  = (Vibrator)getSystemService (Context.VIBRATOR_SERVICE);
        long i = 1000;
        vibrator.vibrate (i);
    }
}
