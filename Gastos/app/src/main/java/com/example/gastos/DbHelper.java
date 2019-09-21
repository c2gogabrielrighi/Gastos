package com.example.gastos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DbHelper extends SQLiteOpenHelper {



    public static final String NOME_BANCO ="BaseCadastros.db";
    public static final String TABELA ="Cadastros";
    public static final String ID ="_id";
    public static final String DESPESA ="despesa";
    public static final String VALOR ="valor";
    public static final String DIA ="dia";
    public static final int VERSAO =1;

    public DbHelper(Context context){
        super(context,NOME_BANCO,null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlVersao1="CREATE TABLE "+TABELA+ " ("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + DESPESA + " TEXT NOT NULL, " + VALOR + " TEXT, "+ DIA + " INT)";
        db.execSQL(sqlVersao1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists "+ TABELA );
        onCreate(db);
    }
}

