package com.example.alunos.myapplication.validation;

import android.app.Activity;
import android.widget.EditText;

public class LoginValidation {

    private String email;
    private String senha;

    private EditText edtEmail;
    private EditText edtSenha;

    private Activity activity;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public EditText getEdtEmail() {
        return edtEmail;
    }

    public void setEdtEmail(EditText edtEmail) {
        this.edtEmail = edtEmail;
    }

    public EditText getEdtSenha() {
        return edtSenha;
    }

    public void setEdtSenha(EditText edtSenha) {
        this.edtSenha = edtSenha;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
