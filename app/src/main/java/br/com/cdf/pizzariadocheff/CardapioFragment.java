package br.com.cdf.pizzariadocheff;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

public class CardapioFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parentViewGroup, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cardapio, parentViewGroup, false);

        ArrayList<String> listaCodigo = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> descricao = new ArrayList<>();
        ArrayList<String> precoGrandes = new ArrayList<>();
        ArrayList<String> precoGigantes = new ArrayList<>();
        Integer[] imagens = {1};

        Toast.makeText(super.getActivity(),"Preços sujeitos à alteração",Toast.LENGTH_LONG).show();

        //recebe os dados do arquivo
        InputStream i = getResources().openRawResource(R.raw.menupizza3);
        CSVParser csvParser = new CSVParser(i);
        ArrayList<String[]> pizzas = csvParser.read();

        for(String[] pizza:pizzas) {
            listaCodigo.add(pizza[0].replace("\"", ""));
            lista.add(pizza[1].replace("\"", ""));
            descricao.add(pizza[2].replace("\"", ""));
            precoGrandes.add(pizza[3].replace("\"", ""));
            precoGigantes.add(pizza[4].replace("\"", ""));
        }

        ListAdapter listAdapter = new CustomAdapter(super.getActivity(),listaCodigo,lista,descricao, precoGrandes, precoGigantes);
        ListView lvCardapio = (ListView)rootView.findViewById(R.id.lvCardapio);
        lvCardapio.setAdapter(listAdapter);

        return rootView;

    }
}
