package com.example.a4july.webservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4july.webservice.models.Repo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.a4july.webservice.MainActivity.user;

public class Listar extends AppCompatActivity {

    Button voltar;
    TextView TESTO;
    String userin = "Repositório do usuário " + user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        final ListView gitlist;

        gitlist = (ListView) findViewById(R.id.listagit);


        TESTO = findViewById(R.id.tvUser);


        TESTO.setText(userin);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        GitHubServices services = retrofit.create(GitHubServices.class);


        Call<List<Repo>> repos = services.listRepos(user);


        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                // Pega a lista de repositorios no corpo da requisição.
                List<Repo> reposResponse = response.body();

                List<String> username = new ArrayList<String >();

                // Percorre a lista e exibe o nome de cada repositório.

                if (reposResponse != null) for (Repo user : reposResponse) {
                    username.add(user.getmName());
                    Log.i("GitHubServices", user.getmName());



                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Usuário não encontrado";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1, username);
                gitlist.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }

    });//FIM ON CREAT

                voltar = (Button)findViewById(R.id.Backbutton);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Listar.this, MainActivity.class);
                startActivity(intent);
            }
        });


}//FIM APP

}


