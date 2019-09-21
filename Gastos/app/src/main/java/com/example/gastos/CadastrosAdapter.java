package com.example.gastos;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


    public class CadastrosAdapter extends ArrayAdapter {
        public CadastrosAdapter( Context context,  List<com.example.gastos.Cadastros> objetcts) {
            super(context, 0, objetcts);
        }

        public View getView(int position, View convertView, ViewGroup parent){
            View listItemView =convertView;

            if(listItemView==null) {
                listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_cadastros, parent, false);
            }
            com.example.gastos.Cadastros current = (com.example.gastos.Cadastros) getItem(position);
            TextView despesa = (TextView) listItemView.findViewById(R.id.txtDespesa);
            TextView valor = (TextView) listItemView.findViewById(R.id.txtValor);
            TextView dia = (TextView) listItemView.findViewById(R.id.txtDia);
            despesa.setText(current.getDespesa().toString());
            valor.setText(current.getValor().toString());
            dia.setText(current.getDia().toString());

            return  listItemView;


        }

    }

