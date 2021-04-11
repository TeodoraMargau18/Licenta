package com.example.banchelorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.banchelorapp.utils.Salon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SalonSelectatActivity extends AppCompatActivity {

    public static String SERVICII_KEY="transferServicii";
    ViewFlipper viewFlipper;
    Intent intent;
    Bundle bundle;
    Salon salon;
    TextView tvNume;
    ListView lvProgram;

    public void goToServiciiActivity(View view){
        bundle=new Bundle();
        if(salon!=null) {
            bundle.putParcelable(SERVICII_KEY, salon);
            intent=new Intent(getApplicationContext(),ServiciiActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else{
            Log.e("goToServiciiActivity","Salonul este null");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon_selectat);
        viewFlipper=findViewById(R.id.viewFlipperSalon);
        intent=getIntent();
        salon=intent.getParcelableExtra(ListaSaloaneActivity.SALON_KEY);
        if(salon!=null)
            Log.e("SalonSelectat", "S-a preluat salonul");
        Log.e("Sunt in salon selectat si am  atatea servicii ",String.valueOf(salon.getServicii().size()));
//        flipperImages(R.drawable.salon1,3000);

        List<String> images=salon.getPozeSalon();
        tvNume=findViewById(R.id.tvNumeSalonSelectat);
        lvProgram =findViewById(R.id.tvProgram);

        List<String> listaPrograme=new ArrayList<>();
        listaPrograme=salon.getProgram();

        tvNume.setText(salon.getNumeSalon());
        ArrayAdapter<String> programAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listaPrograme );
        lvProgram.setAdapter(programAdapter);

        for(String image:images){
            Log.i("SalonSelectatActivity","Am intrat in for");
            flipperImages(image,3000);
        }

    }

    public void flipperImages(String image, int interval) {
        ImageView img=new ImageView(this);
        Log.e("ListView Adapter","Inainte de imagine");
        Log.e("Ce imagine am aici ?",image);
        Picasso.get().load(image.trim()).into(img);
        Log.e("ListView Adapter","Dupa  imagine");


        viewFlipper.addView(img);
        viewFlipper.setFlipInterval(interval);
        viewFlipper.startFlipping();

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);

    }

    public void goToProgramarileMeleActivity(View view) {
    }
}