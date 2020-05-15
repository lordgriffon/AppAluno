package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase db = openOrCreateDatabase("dbAlunos",MODE_PRIVATE,null);

            db.execSQL("CREATE TABLE IF NOT EXISTS tbAlunos (nome VARCHAR, email VARCHAR, telefone VARCHAR)");

            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Leonardo','leo@example.com','95687-5689')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Ana','aninha@example.com','98467-0256')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Ricardo','ricardo@example.com','95970-5236')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Amelia','amelia@example.com','90015-6552')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Eleanor','eleanor@example.com','90014-0235')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Tiago','tiago@example.com','90258-3201')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Roberta','roberta@example.com','98530-0358')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Mario','mario@example.com','99870-9602')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Leia','leia@example.com','95036-2459')");
            db.execSQL("INSERT INTO tbAlunos(nome,email,telefone) VALUES ('Lucas','lucas@example.com','97569-9863')");

            Cursor cursor = db.rawQuery("SELECT nome,email,telefone FROM tbAlunos",null);

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceEmail = cursor.getColumnIndex("email");
            int indiceTelefone = cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while(cursor != null){
                Log.i("Resultado - Nome",cursor.getString(indiceNome));
                Log.i("Resultado - Email",cursor.getString(indiceEmail));
                Log.i("Resultado - Telefone",cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
