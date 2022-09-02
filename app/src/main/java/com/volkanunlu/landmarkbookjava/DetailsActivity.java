package com.volkanunlu.landmarkbookjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.volkanunlu.landmarkbookjava.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

      //  Intent intent=getIntent(); //mainde oluşturulan intenti çekiyoruz.

        //(LandMark) Casting işlemi, landmark verisini gönderdiğimden eminim.Javaya böyle olduğunu teyitliyorum,eğer yanlış tanımladı isem
        //uygulamam çökecektir.
       // LandMark selectedLandMark=(LandMark)intent.getSerializableExtra("landmark");

        Singleton singleton=Singleton.getInstance();
        LandMark selectedLandMark=singleton.getSetLandMark();

        binding.nameText.setText(selectedLandMark.name);   //elementlerimi sırasıyla eşleştiriyorum.
        binding.countryText.setText(selectedLandMark.country); //elementlerimi sırasıyla eşleştiriyorum.
        binding.imageView.setImageResource(selectedLandMark.image); //elementlerimi sırasıyla eşleştiriyorum.
    }
}