package com.example.alunos.myapplication.entidade;

public enum Unidades {

  ZERO("0 un."), UM("1 un."), DOIS("2  un."), TRES("3 un."), QUATRO("4 un."), CINCO("5 un.");

  private Unidades (String quantidade){
      this.quantidade = quantidade;

  }
  private String quantidade;

  public String getQuantidade(){
      return quantidade;
  }



}
