package com.example.alunos.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.alunos.myapplication.async.AsyncUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        //new AsyncUsuario (this).execute ("http://192.168.1.101:8080/rest-web/rest/alo/param/cesar");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater ().inflate (R.menu.menu_main, menu);

        menu.add(0, 1, 1, menuIconWithText(getResources().getDrawable(R.drawable.user), getResources().getString(R.string.login)));
        menu.add(0, 2, 3, menuIconWithText(getResources().getDrawable(R.drawable.list), getResources().getString(R.string.meus_pedido)));
        menu.add(0, 3, 3, menuIconWithText(getResources().getDrawable(R.drawable.calendar), getResources().getString(R.string.cardapio_da_semana)));
        menu.add(0, 4, 4, menuIconWithText(getResources().getDrawable(R.drawable.sair), getResources().getString(R.string.sair)));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();

        switch (item.getItemId ()) {
            case 1:
                Intent intent = new Intent (this, LoginActivity.class);
                startActivity (intent);
                return true;

            case 2:
                Intent intent2 = new Intent (this, MeusPedidoActivity.class) ;
                startActivity (intent2);
                return true;

            case 3:
                Intent intent3 = new Intent (this, CardapioActivity.class) ;
                startActivity (intent3);
                return true;

            case 4:
                SharedPreferences.Editor editor = getSharedPreferences ("pref",Context.MODE_PRIVATE).edit ();
                editor.remove ("email");
                editor.remove ("senha");
                editor.commit ();

                finish ();
                Intent intent4 = new Intent (MainActivity.this, LoginActivity.class);
                startActivity (intent4);

                return true;
        }

        return super.onOptionsItemSelected (item);
    }
    private CharSequence menuIconWithText(Drawable r, String title) {

        r.setBounds(0, 0, r.getIntrinsicWidth(), r.getIntrinsicHeight());
        SpannableString sb = new SpannableString("    " + title);
        ImageSpan imageSpan = new ImageSpan(r, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        return sb;
    }

    public void abrirPedido(View view) {
        Intent intent = new Intent (this, PedidoActivity.class);
        startActivity (intent);
    }

    public void abrirCadastro(View view) {
        Intent intent = new Intent (this, CadastroActivity.class);
        startActivity (intent);
    }
}


