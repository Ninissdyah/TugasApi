package com.example.tugasapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    TextView name, temperament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = findViewById(R.id.nameCat);
        temperament = findViewById(R.id.temperamentCat);

        //memanggil function
        getRandomBreedst();
    }

    //function untuk menampilkan data pada tampilan
    private void getRandomBreedst() {
        Call<List<cuteCat>> caller = RetrofitClient.getInstance().getApi().getRandomBreedss(1);
        caller.enqueue(new Callback<List<cuteCat>>() {
            @Override
            public void onResponse(Call<List<cuteCat>> call, Response<List<cuteCat>> response) {
                List<cuteCat> cuteCatList = response.body();
                //list kosong yg menampung data
                String catName = "";
                String catTemperament = "";

                //untuk menampilkan data dalam bentuk list
                for (int i=0; i<cuteCatList.size(); i++) {
                    cuteCat currentCat = cuteCatList.get(i);
                    catName = currentCat.getCatName();
                    catTemperament = currentCat.getCatTemperament();
                }

                //nge set teks dari hasil di atas di text view
                name.setText(catName);
                temperament.setText(catTemperament);
            }

            @Override
            public void onFailure(Call<List<cuteCat>> call, Throwable t) {

            }
        });
    }
}