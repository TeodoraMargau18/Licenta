package com.example.banchelorapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.banchelorapp.R;
import com.example.banchelorapp.utils.interventii.Interventie;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.Date;

public class ListaInterventiiAdapter extends ArrayAdapter<Interventie> {
    private static final String TAG="ListaInterventiiAdapter";
    private Context mContext;
    int mResource;

    public ListaInterventiiAdapter(@NonNull Context context, int resource,
                                   @NonNull ArrayList<Interventie> objects){
        super(context, resource, objects);
        this.mContext = context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String tipInterventie=getItem(position).getTipInterventie();
        String medic=getItem(position).getMedic();
        Date dataInterventie=getItem(position).getDataInterventie();

      Interventie interventie=new Interventie(tipInterventie,dataInterventie,medic);
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvDataInterventie=convertView.findViewById(R.id.tvDataInterventie);
        TextView tvMedic=convertView.findViewById(R.id.tvNumeMedicInterventie);
        TextView tvTip=convertView.findViewById(R.id.tvTipInterventie);

        tvDataInterventie.setText("Data interventie :"+interventie.getDataInterventie());
        tvMedic.setText("Medic "+interventie.getMedic());
        tvTip.setText("Tip interventie: "+interventie.getTipInterventie());

        return convertView;
    }
}