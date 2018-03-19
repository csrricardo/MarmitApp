package com.example.alunos.myapplication.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncUsuario extends AsyncTask<String, String, String> {
    private Activity activity;

    public AsyncUsuario(Activity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(String... url) {
        StringBuilder resultado = new StringBuilder ("");
        try {
            URL urlNet  = new URL (url [0]);
            HttpURLConnection con = (HttpURLConnection) urlNet.openConnection ();
            con.setRequestMethod ("POST");
            con.setRequestProperty ("Accept", "application/json");
            con.setRequestProperty ("Content-type", "application/json");
            con.setDoInput (true);
            con.setDoOutput (true);
            con.connect ();

            InputStream inp  = con.getInputStream ();

            BufferedReader bufferedReader =  new BufferedReader (new InputStreamReader (inp));

            String linha = "";
            while ((linha = bufferedReader.readLine ()) != null){
                resultado.append (linha);
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return resultado.toString ();
    }
    @Override
    protected void onPostExecute (String resultado){
        Toast.makeText (activity, resultado, Toast.LENGTH_SHORT).show ();

    }

}
