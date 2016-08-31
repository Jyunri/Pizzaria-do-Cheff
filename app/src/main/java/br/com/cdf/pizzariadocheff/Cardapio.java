package br.com.cdf.pizzariadocheff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Cardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        ArrayList<String> listaCodigo = new ArrayList<>();
        ArrayList<String> lista = new ArrayList<>();
        ArrayList<String> descricao = new ArrayList<>();
        ArrayList<String> precoGrandes = new ArrayList<>();
        ArrayList<String> precoGigantes = new ArrayList<>();
        Integer[] imagens = {1};

        //recebe os dados do arquivo
        InputStream i = getResources().openRawResource(R.raw.menupizza);
        CSVParser csvParser = new CSVParser(i);
        ArrayList<String[]> pizzas = csvParser.read();

        for(String[] pizza:pizzas) {
            listaCodigo.add(pizza[0].replace("\"", ""));
            lista.add(pizza[1].replace("\"", ""));
            descricao.add(pizza[2].replace("\"", ""));
            precoGrandes.add(pizza[3].replace("\"", ""));
            precoGigantes.add(pizza[4].replace("\"", ""));
        }

        ListAdapter listAdapter = new CustomAdapter(this,listaCodigo,lista,descricao, precoGrandes, precoGigantes);
        ListView lvCardapio = (ListView)findViewById(R.id.lvCardapio);
        lvCardapio.setAdapter(listAdapter);
    }
}
