package com.example.assholeapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assholeapp.api.CatApi;
import com.example.assholeapp.api.CatsService;
import com.example.assholeapp.db.CatDao;
import com.example.assholeapp.db.CatDb;
import com.example.assholeapp.db.CatsDatabase;
import com.example.assholeapp.mappers.CatApiToDbMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView catsView;
    private CatsAdapter catsAdapter;
    private List<CatApi> cats;
    private List<CatDb> catsForDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catsView = findViewById(R.id.catsView);

        CatsDatabase db = App.getInstance().getDatabase();
        final CatDao catDao = db.catDao();

        String header = "22206ce7-ff06-465e-99f8-7171e5dd9b13";
        String order = "DESC_ORDER";
        Integer limit = 50;
        Integer page = 4;
        CatsService.getInstance().getCatsApi().cats(header, limit, page, order).enqueue(new Callback<List<CatApi>>() {
            @Override
            public void onResponse(Call<List<CatApi>> call, Response<List<CatApi>> response) {
                cats = response.body();

                catsForDb = CatApiToDbMapper.catsApiToDb(cats);

                catDao.insert(catsForDb);

                catsView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                catsAdapter = new CatsAdapter(MainActivity.this, catsForDb);

                catsView.setAdapter(catsAdapter);
            }

            @Override
            public void onFailure(Call<List<CatApi>> call, Throwable t) {

                catsForDb = catDao.all();

                catsView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                catsAdapter = new CatsAdapter(MainActivity.this, catsForDb);

                catsView.setAdapter(catsAdapter);

                Log.d(MainActivity.class.getName(), "Падение");
            }
        });


        //catsAdapter.notifyDataSetChanged();


    }
}
