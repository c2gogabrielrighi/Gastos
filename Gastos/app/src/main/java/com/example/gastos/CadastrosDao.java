package com.example.gastos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

    public class CadastrosDao {

        private SQLiteDatabase db;
        private  DbHelper banco;


        public CadastrosDao(Context context){
            banco = new DbHelper(context);
        }

        public String cadastrar (Cadastros cadastros){
            ContentValues valores;
            long resultado;
            db = banco.getWritableDatabase();
            try{
                valores=new ContentValues();
                valores.put(banco.DESPESA, cadastros.getDespesa());
                valores.put(banco.DIA, cadastros.getValor());
                int valor= Integer.valueOf(cadastros.getValor());
                valores.put(banco.VALOR,valor );
                resultado= db.insert(banco.TABELA,null,valores);
                db.close();
                if (resultado !=-1){

                    return "Despesa inserida ="+ cadastros.getDespesa();
                }
            }catch (SQLException e){
                Log.e("ERRO",e.getMessage());
            }

            return "Erro!";

        }


        public ArrayList<Cadastros> list(){
            ArrayList<Cadastros> lista= new ArrayList<>();
            Cursor cursor;
            String[] campos={DbHelper.ID, DbHelper.DESPESA, DbHelper.VALOR,DbHelper.DIA};
            db= banco.getReadableDatabase();
            cursor = db.query(DbHelper.TABELA,campos,null,null,null,null,null);
            if (cursor!=null){
                cursor.moveToFirst();
                while (cursor.moveToNext()){
                    int id= cursor.getInt(0) ;
                    String despesa = cursor.getString(1) ;
                    int valor = cursor.getInt(2) ;
                    String dia = cursor.getString(3) ;
                    Cadastros c= new Cadastros(id,despesa,valor,dia);
                    lista.add(c);
                }
                return lista;
            }
            return null;
        }

        public String deletar(Cadastros c){
            String where = DbHelper.ID+ "= " +c.getId();
            db= banco.getReadableDatabase();
            db.delete(DbHelper.TABELA,where,null);
            db.close();
            return "Removido";
        }



    }
