package br.com.cdf.pizzariadocheff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jimy on 8/28/16.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    String[] listaItens;
    String[] listaDescricao;
    Integer[] listaImagens;

    public CustomAdapter(Context context, String[] listaItens, String[] listaDescricao, Integer[] listaImagens) {
        super(context, R.layout.custom_row, listaItens);
        this.listaItens = listaItens;
        this.listaDescricao = listaDescricao;
        this.listaImagens = listaImagens;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String item = listaItens[position];
        TextView tvItem = (TextView)customView.findViewById(R.id.tvItem);
        tvItem.setText(item);

        String descricao = listaDescricao[position];
        TextView tvDescricao = (TextView)customView.findViewById(R.id.tvDescricao);
        tvDescricao.setText(descricao);

        //// TODO: 8/28/16 setar imagem diinamicamente 
        ImageView ivImagem = (ImageView)customView.findViewById(R.id.ivImagem);
        ivImagem.setImageResource(R.drawable.logocheff);

        return customView;
    }
}
