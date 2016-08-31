package br.com.cdf.pizzariadocheff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jimy on 8/28/16.
 */
public class CustomAdapter extends ArrayAdapter{

    ArrayList<String> listaCodigo;
    ArrayList<String> listaItens;
    ArrayList<String> listaDescricao;
    ArrayList<String> precosGrandes;
    ArrayList<String> precosGigantes;

    public CustomAdapter(Context context, ArrayList<String> listaCodigo, ArrayList<String> listaItens, ArrayList<String> listaDescricao, ArrayList<String> precosGrandes, ArrayList<String> precosGigantes) {
        super(context, R.layout.custom_row, listaItens);
        this.listaCodigo = listaCodigo;
        this.listaItens = listaItens;
        this.listaDescricao = listaDescricao;
        this.precosGrandes = precosGrandes;
        this.precosGigantes = precosGigantes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        String item = listaCodigo.get(position)+" - "+listaItens.get(position);
        TextView tvItem = (TextView)customView.findViewById(R.id.tvItem);
        tvItem.setText(item);

        String descricao = listaDescricao.get(position);
        TextView tvDescricao = (TextView)customView.findViewById(R.id.tvDescricao);
        tvDescricao.setText(descricao);

        String precoGrande = "Grande: R$"+precosGrandes.get(position)+",00";
        TextView tvPrecoGrande = (TextView)customView.findViewById(R.id.tvPrecoGrande);
        tvPrecoGrande.setText(precoGrande);

        String precoGigante = "Gigante: R$"+precosGigantes.get(position)+",00";
        TextView tvPrecoGigante = (TextView)customView.findViewById(R.id.tvPrecoGigante);
        tvPrecoGigante.setText(precoGigante);

//        //// TODO: 8/28/16 setar imagem diinamicamente
//        ImageView ivImagem = (ImageView)customView.findViewById(R.id.ivImagem);
//        ivImagem.setImageResource(R.drawable.logocheff);

        return customView;
    }
}
