package com.example.alunos.myapplication.bo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.alunos.myapplication.validation.LoginValidation;

public class LoginBO {

    public boolean validarCamposLogin(LoginValidation validation) {
        boolean resultado = true;

        if (validation.getEmail () == null || "".equals (validation.getEmail ())) {
            validation.getEdtEmail ().setError ("Campo Obrigatorio!");
            resultado = false;
        } if (validation.getSenha () == null || "".equals (validation.getSenha ())) {
            validation.getEdtSenha ().setError ("Campo Obrigatorio!");
            resultado = false;
        } if (resultado) {
            if (!validation.getEmail ().equals ("admin@email.com") || !validation.getEmail ().equals ("admin@email.com")) {
                Toast.makeText (validation.getActivity (), "EMAIL INVALIDO!", Toast.LENGTH_LONG).show ();
                resultado = false;
            } if (!validation.getSenha ().equals ("admin") || !validation.getSenha ().equals ("admin")) {
                    Toast.makeText (validation.getActivity (), "SENHA INVALIDA!", Toast.LENGTH_LONG).show ();
                    resultado = false;
            } else {
                    SharedPreferences.Editor editor = validation.getActivity ().getSharedPreferences ("pref", Context.MODE_PRIVATE).edit ();
                    editor.putString ("email", validation.getEmail ());
                    editor.putString ("senha", validation.getSenha ());
                    editor.commit ();
                }
            }
            return resultado;
    }

}
