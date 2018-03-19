package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.alunos.myapplication.entidade.Unidades;

import java.util.ArrayList;

public class PedidoActivity extends AppCompatActivity {



    private TextView txtTotal;
    private CheckBox ckbMP, ckbMM, ckbMG;
    private CheckBox ckbSucoA, ckbSucoL;
    private CheckBox ckbCoca, ckbGuarana;

    private Spinner spMP, spMM, spMG, spSA, spGA, spSL, spCC;

    private Button btnConfirmaPedido;

    double total = 0;
    double val_spinnerP = 0, val_spinnerM = 0, val_spinnerG = 0;
    double val_spinnerSA = 0, val_spinnerSL = 0, val_spinnerCC = 0, val_spinnerGA = 0;

    double precoMP = 8.00, precoMM = 9.00, precoMG = 10.00;
    double precoSucoAbacaxi = 4.00, precoSucoLaranja = 4.00;
    double precoRefriCoca = 6.00, precoRefriGuarana = 6.00;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pedido);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
        getSupportActionBar ().setTitle ("Cardápio");
        addListenerOnClick ();

        spMP.setEnabled (false);
        spMM.setEnabled (false);
        spMG.setEnabled (false);
        spSA.setEnabled (false);
        spSL.setEnabled (false);
        spGA.setEnabled (false);
        spCC.setEnabled (false);
        btnConfirmaPedido.setEnabled (false);
        btnConfirmaPedido.setBackgroundResource (R.color.colorGray);
        btnConfirmaPedido.setText ("ESCOLHER MARMITEX");

        spMP = (Spinner) findViewById (R.id.spMP);
        this.initUnidade ();
        spMP.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spMP.getSelectedItemPosition ();
                val_spinnerP = posicao * precoMP;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spMM = (Spinner) findViewById (R.id.spMM);
        this.initUnidade ();
        spMM.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spMM.getSelectedItemPosition ();
                val_spinnerM = posicao * precoMM;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spMG = (Spinner) findViewById (R.id.spMG);
        this.initUnidade ();
        spMG.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spMG.getSelectedItemPosition ();
                val_spinnerG = posicao * precoMG;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spSA = (Spinner) findViewById (R.id.spSA);
        this.initUnidade ();
        spSA.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spSA.getSelectedItemPosition ();
                val_spinnerSA = posicao * precoSucoAbacaxi;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spSL = (Spinner) findViewById (R.id.spSL);
        this.initUnidade ();
        spSL.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spSL.getSelectedItemPosition ();
                val_spinnerSL = posicao * precoSucoLaranja;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spCC = (Spinner) findViewById (R.id.spCC);
        this.initUnidade ();
        spCC.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spCC.getSelectedItemPosition ();
                val_spinnerCC = posicao * precoRefriCoca;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spGA = (Spinner) findViewById (R.id.spGA);
        this.initUnidade ();
        spGA.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int posicao, long id) {
                posicao = spGA.getSelectedItemPosition ();
                val_spinnerGA = posicao * precoRefriGuarana;
                total = val_spinnerG + val_spinnerM + val_spinnerP + val_spinnerSA + val_spinnerSL + val_spinnerCC + val_spinnerGA;
                txtTotal.setText ("VALOR TOTAL: " + String.format ("%.2f", total) + " R$. ");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void addListenerOnClick() {
        ckbMP = (CheckBox) findViewById (R.id.ckbMP);
        ckbMM = (CheckBox) findViewById (R.id.ckbMM);
        ckbMG = (CheckBox) findViewById (R.id.ckbMG);
        ckbSucoA = (CheckBox) findViewById (R.id.ckbSucoA);
        ckbSucoL = (CheckBox) findViewById (R.id.ckbSucoL);
        ckbCoca = (CheckBox) findViewById (R.id.ckbCoca);
        ckbGuarana = (CheckBox) findViewById (R.id.ckbGuarana);
        spMP = (Spinner) findViewById (R.id.spMP);
        spMM = (Spinner) findViewById (R.id.spMM);
        spMG = (Spinner) findViewById (R.id.spMG);
        spSA = (Spinner) findViewById (R.id.spSA);
        spSL = (Spinner) findViewById (R.id.spSL);
        spGA = (Spinner) findViewById (R.id.spGA);
        spCC = (Spinner) findViewById (R.id.spCC);
        txtTotal = (TextView) findViewById (R.id.txtTotal);
        btnConfirmaPedido = (Button) findViewById (R.id.btnConfirmaPedido);

        ckbMP.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if (ckbMP.isChecked ()) {
                    spMP.setSelection (1);
                    spMP.setEnabled (true);
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                } else {
                    spMP.setSelection (0);
                    spMP.setEnabled (false);
                    btnConfirmaPedido.setEnabled (false);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorGray);
                    btnConfirmaPedido.setText ("ESCOLHER MARMITEX");
                }
                if (ckbMM.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                }
                if (ckbMG.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                }
            }
        });
        ckbMM.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if (ckbMM.isChecked ()) {
                    spMM.setSelection (1);
                    spMM.setEnabled (true);
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                } else {
                    spMM.setSelection (0);
                    spMM.setEnabled (false);
                    btnConfirmaPedido.setEnabled (false);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorGray);
                    btnConfirmaPedido.setText ("ESCOLHER MARMITEX");
                }
                if (ckbMP.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                }
                if (ckbMG.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                }
            }
        });
        ckbMG.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (ckbMG.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    spMG.setSelection (1);
                    spMG.setEnabled (true);
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                } else {
                    spMG.setSelection (0);
                    spMG.setEnabled (false);
                    btnConfirmaPedido.setEnabled (false);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorGray);
                    btnConfirmaPedido.setText ("ESCOLHER MARMITEX");
                }
                if (ckbMP.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                }
                if (ckbMM.isChecked ()) {
                    btnConfirmaPedido.setEnabled (true);
                    btnConfirmaPedido.setBackgroundResource (R.color.colorPrimary);
                    btnConfirmaPedido.setText ("CONFIRMAR");
                }
            }
        });
        ckbSucoA.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (ckbSucoA.isChecked ()) {
                    spSA.setSelection (1);
                    spSA.setEnabled (true);
                } else {
                    spSA.setSelection (0);
                    spSA.setEnabled (false);
                }
            }
        });
        ckbSucoL.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (ckbSucoL.isChecked ()) {
                    spSL.setSelection (1);
                    spSL.setEnabled (true);
                } else {
                    spSL.setSelection (0);
                    spSL.setEnabled (false);
                }
            }
        });
        ckbCoca.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if (ckbCoca.isChecked ()) {
                    spCC.setSelection (1);
                    spCC.setEnabled (true);
                } else {
                    spCC.setSelection (0);
                    spCC.setEnabled (false);
                }
            }
        });
        ckbGuarana.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                if (ckbGuarana.isChecked ()) {
                    spGA.setSelection (1);
                    spGA.setEnabled (true);
                } else {
                    spGA.setSelection (0);
                    spGA.setEnabled (false);
                }
            }
        });
    }
    private void initUnidade(){
        ArrayList<String>unidades = new ArrayList<> ();
        for (Unidades u : Unidades.values ()){
            unidades.add (u.getQuantidade ());
        }
        ArrayAdapter arrayAdater = new ArrayAdapter( PedidoActivity.this, android.R.layout.simple_spinner_item, unidades);
        arrayAdater.setDropDownViewResource (android.R.layout.simple_dropdown_item_1line);
        spMP.setAdapter (arrayAdater);
        spMM.setAdapter (arrayAdater);
        spMG.setAdapter (arrayAdater);
        spGA.setAdapter (arrayAdater);
        spCC.setAdapter (arrayAdater);
        spSA.setAdapter (arrayAdater);
        spSL.setAdapter (arrayAdater);
    }

    public void openAddresPayment(View view) {
        String total = txtTotal.getText ().toString ().trim ();
        Intent intent = new Intent (getApplication (), AddressPaymentActivity.class);
        Bundle bundle = new Bundle ();

        bundle.putString ("TOTAL A PAGAR", total);
        intent.putExtras (bundle);
        startActivity (intent);
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