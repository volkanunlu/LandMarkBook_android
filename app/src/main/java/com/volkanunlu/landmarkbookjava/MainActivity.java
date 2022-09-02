package com.volkanunlu.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.volkanunlu.landmarkbookjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayList<LandMark> landMarkArrayList; //başka metotlardan da ulaşabilmek adına burada tanımladık.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        landMarkArrayList = new ArrayList<>();

        //Data
        LandMark pisa = new LandMark("Pisa", "Italy", R.drawable.pisa);
        LandMark eiffel = new LandMark("Eiffel", "France", R.drawable.eiffel);
        LandMark ayasofya = new LandMark("Ayasofya", "Turkey", R.drawable.ayasofya);
        LandMark londoneye = new LandMark("London Eye", "United Kingdom", R.drawable.londoneye);

        landMarkArrayList.add(pisa);  //diziye değerlerimizi ekledik.
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(ayasofya);
        landMarkArrayList.add(londoneye);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandMarkAdapter landMarkAdapter = new LandMarkAdapter(landMarkArrayList); //adaptere liste boyutunu verdik, getItemcount kullansın diye.

        binding.recyclerView.setAdapter(landMarkAdapter); //binding ile recyclerView'i landmarkadaptera bağladık.Veri aktarım gösterimi.



    }



}