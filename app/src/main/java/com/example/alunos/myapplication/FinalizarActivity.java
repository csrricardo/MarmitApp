package com.example.alunos.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class FinalizarActivity extends AppCompatActivity {

    private TextView txtFinalizarNome = null;
    private TextView txtTotalFim = null;
    private TextView txtData = null;
    private TextView txtHora = null;
    private TextView txtPedidoNumero = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_finalizar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
        getSupportActionBar ().setTitle ("Pedido Finalizado");
        numeroDoPedido ();

        txtPedidoNumero = (TextView) findViewById (R.id.txtPedidoNumero);
        txtFinalizarNome = (TextView) findViewById (R.id.txtFinalizarNome);
        txtTotalFim = (TextView) findViewById (R.id.txtTotalFim);
        txtData = (TextView) findViewById (R.id.txtData);
        txtHora = (TextView) findViewById (R.id.txtHora);


        SimpleDateFormat data = new SimpleDateFormat ("dd/MM/yyyy");
        String currentDate = data.format (new Date ());
        txtData.setText ("DATA: " + currentDate + ".");

        SimpleDateFormat hora = new SimpleDateFormat ("HH:mm:ss");
        String currentTime = hora.format (new Date ());
        txtHora.setText ("HORA: " + currentTime + ".");

        Intent intent = getIntent ();

        Bundle bundle = intent.getExtras ();

        if (bundle != null) {
            String nome = bundle.getString ("NOME");
            String total = bundle.getString ("TOTAL");

            txtFinalizarNome.setText ("NOME: " + nome + ".");
            txtTotalFim.setText (total);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == android.R.id.home) {
            this.finish ();
        }
        return super.onOptionsItemSelected (item);
    }

    public void abrirInicio(View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity (intent);
        finish ();
    }

    public void numeroDoPedido() {
        Random random = new Random ();
        int numeroPedido = random.nextInt (9999) + 1;
        txtPedidoNumero = (TextView) findViewById (R.id.txtPedidoNumero);
        String string = String.valueOf (numeroPedido);
        txtPedidoNumero.setText (String.valueOf ("NÚMERO DO PEDIDO: " + String.valueOf (string)));
    }
}
