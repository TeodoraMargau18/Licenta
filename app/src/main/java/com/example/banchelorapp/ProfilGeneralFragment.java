package com.example.banchelorapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.banchelorapp.adapter.ListaVaccinuriAdapter;
import com.example.banchelorapp.utils.Animal;
import com.example.banchelorapp.utils.interventii.Vaccin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfilGeneralFragment extends Fragment {

    public static final String PROFILGENERAL_KEY ="transferAnimal";

    ExpandableListView expandableListView;
    ArrayList<String> listGroup;
    HashMap<String,List<String>> listItem;
    ExpandableAdapter adapter;

    public ProfilGeneralFragment() {
    }
    public static ProfilGeneralFragment newInstance(Animal animal){
        ProfilGeneralFragment fragment=new ProfilGeneralFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable(ProfilGeneralFragment.PROFILGENERAL_KEY,animal);
        fragment.setArguments(bundle);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.fragment_profil_general, container, false);

      //-------------

        expandableListView=view.findViewById(R.id.expLvProfilGeneral);

        Animal animal;
        if(getArguments()!=null){
            animal=getArguments().getParcelable(ProfilGeneralFragment.PROFILGENERAL_KEY);
            Log.e("ProfilGeneral fragment",String.valueOf( animal.getDataNasteriiAnimal()));
        }
        else
            animal=new Animal();

        listGroup=new ArrayList<>();
        listItem=new HashMap<>();

        adapter=new ExpandableAdapter(this.getContext(),listGroup,listItem);
        expandableListView.setAdapter(adapter);
        initListData(animal);
        //pana aici

        if(getContext()!=null)
        {
            ArrayList<Vaccin> listaVaccinuri=animal.getVaccinuriAnimal();
            ListaVaccinuriAdapter adapter=new ListaVaccinuriAdapter
                    (getContext().getApplicationContext(),
                            R.layout.lista_vaccinuri_adapter,
                            listaVaccinuri);
//            vaccinuriListView.setAdapter(adapter);
        }

      //-------------
    return view;
    }

    private void initListData(Animal animal){
        listGroup.add("Proprietar");
        listGroup.add("Descriere animal");
        listGroup.add("Identificare animal");
        listGroup.add("Prevenire si combatere");
        listGroup.add("Date fiziologice");

        ArrayList<String> array;
        //vectorul in care bag toate elementele unei liste expandabile

        ArrayList<String> list1=new ArrayList<>();
        array=new ArrayList<>();
        array.add("Nume proprietar");
        array.add("Prenume proprietar");
        array.add("Adresa proprietar");
        array.add("CNP proprietar");
        array.add("Numar telefon proprietar");
        for (String item : array) {
            list1.add(item);
        }

        ArrayList<String> list2=new ArrayList<>();
        array=new ArrayList<>();
        array.add("Nume animal");
        array.add("Rasa");
        array.add("Sexul");
        array.add("Data nasterii");
        array.add("Culoarea");
        for (String item : array) {
            list2.add(item);
        }

        ArrayList<String> list3=new ArrayList<>();
        array=new ArrayList<>();
        array.add("Numar CIP");
        array.add("Semne particulare");
        for (String item : array) {
            list3.add(item);
        }

        ArrayList<String> list4=new ArrayList<>();
        array=new ArrayList<>();
      array.add("Boala1");
        array.add("Boala2");
        array.add("Boala3");
        for (String item : array) {
            list4.add(item);
        }

        ArrayList<String> list5=new ArrayList<>();
        array=new ArrayList<>();
        array.add("Semne vitale normale | Caini  | Pisici    ");
        array.add("   Temperatura          | 38-39.2|  37.8-39.5");
        for (String item : array) {
            list5.add(item);
        }
        listItem.put(listGroup.get(0),list1);
        listItem.put(listGroup.get(1),list2);
        listItem.put(listGroup.get(2),list3);
        listItem.put(listGroup.get(3),list4);
        listItem.put(listGroup.get(4),list5);
        adapter.notifyDataSetChanged();

    }
}