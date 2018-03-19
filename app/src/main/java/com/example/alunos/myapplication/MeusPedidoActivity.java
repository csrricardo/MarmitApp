package com.example.alunos.myapplication;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MeusPedidoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_meus_pedido);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
        getSupportActionBar ().setHomeButtonEnabled (true);
        getSupportActionBar ().setTitle ("Meus Pedidos");

        ListView listView = (ListView) findViewById (R.id.listView2);

        String[] strings = new String[]{"Item1", "Item2", "Item3", "Item4", "Item5", "Item6", "Item7"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_dropdown_item_1line, strings);

        listView.setAdapter (adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();
        if (id == android.R.id.home) {
            this.finish ();
        }
        return super.onOptionsItemSelected (item);
    }

    public void abrirPedido(View view) {
        Intent intent = new Intent (this, PedidoActivity.class);
        startActivity (intent);
        finish ();
    }
}
