package br.com.cdf.pizzariadocheff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Cardapio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        String[] lista = {"Mussarela","Portuguesa"};
        String[] descricao = {"Mussarela","Presunto e ovo"};
        Integer[] imagens = {1};

        ListAdapter listAdapter = new CustomAdapter(this,lista,descricao, imagens);
        ListView lvCardapio = (ListView)findViewById(R.id.lvCardapio);
        lvCardapio.setAdapter(listAdapter);
    }
}
