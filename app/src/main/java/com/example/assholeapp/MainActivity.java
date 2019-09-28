package com.example.assholeapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assholeapp.api.CatsService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Header;

public class MainActivity extends AppCompatActivity {

    private RecyclerView catsView;
    private CatsAdapter catsAdapter;
    private List<Cat> cats;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catsView = findViewById(R.id.catsView);

        String header = "22206ce7-ff06-465e-99f8-7171e5dd9b13";
        String order = "DESC_ORDER";
        Integer limit = 50;
        Integer page = 4;
        CatsService.getInstance().getCatsApi().cats(header, limit, page, order).enqueue(new Callback<List<Cat>>() {
            @Override
            public void onResponse(Call<List<Cat>> call, Response<List<Cat>> response) {
                cats = response.body();

                catsView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                catsAdapter = new CatsAdapter(MainActivity.this, cats);

                catsView.setAdapter(catsAdapter);
            }

            @Override
            public void onFailure(Call<List<Cat>> call, Throwable t) {
                Log.d(MainActivity.class.getName(), "Падение");
            }
        });





        //catsAdapter.notifyDataSetChanged();


    }
}
