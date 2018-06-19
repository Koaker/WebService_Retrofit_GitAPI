package com.example.a4july.webservice;
import com.example.a4july.webservice.ApiClient;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a4july.webservice.models.Repo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button botao;
    public static EditText getuser;
    public static String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        botao = (Button)findViewById(R.id.ListButton);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getuser   = (EditText)findViewById(R.id.etUser);
                user = getuser.getText().toString();
                Intent intent = new Intent( MainActivity.this, Listar.class);
                startActivity(intent);

                }


            });


        }

    }//Fim onCrate
 // FIm APP