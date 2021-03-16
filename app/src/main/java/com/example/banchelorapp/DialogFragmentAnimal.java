package com.example.banchelorapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogFragmentAnimal extends DialogFragment {

    EditText et;
    Button btnInchide;
    Button btnSalveaza;
    DialogFragmentAnimal dlg;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.dialog_fragment_animal,container,false);
        et=view.findViewById(R.id.etNotite);
        btnInchide=view.findViewById(R.id.dialogFragmentInchide);
        btnSalveaza=view.findViewById(R.id.dialogFragmentSalveaza);
        dlg=this;

        btnInchide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=et.getText().toString();
                et.setText(text);
                dlg.dismiss();
            }
        });

        return view;
    }
}
