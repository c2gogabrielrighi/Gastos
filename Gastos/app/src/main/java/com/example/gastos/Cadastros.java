package com.example.gastos;


           public class Cadastros {


            private int _id;
            private String despesa;
            private int valor;
            private int dia;


            public Cadastros( String despesa, int valor, int dia) {
                this.despesa = despesa;
                this.valor = valor;
                this.dia = dia;
            }

            public Cadastros(int id,String despesa, int valor, int dia){
                this.despesa = despesa;
                this.valor = valor;
                this.dia = dia;
                this._id=id;
            }

            public String getDespesa(){ return despesa;}

            public int getValor(){ return valor;}

            public int getDia(){ return dia;}

            public int getId(){return _id;}
            @Override

            public String toString(){
                return "Cadastros{" +
                        "despesa='" + despesa + '\'' +
                        ", valor=" + valor +
                        ", dia='" + dia + '\'' +
                        '}';


            }

        }











