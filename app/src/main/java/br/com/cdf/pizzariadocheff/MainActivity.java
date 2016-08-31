package br.com.cdf.pizzariadocheff;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btCardapio, btContato;
    Button btLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCardapio = (Button)findViewById(R.id.btCardapio);
        btContato = (Button)findViewById(R.id.btContato);
        btLigar = (Button)findViewById(R.id.btLigar);

        btCardapio.setOnClickListener(this);
        btContato.setOnClickListener(this);
        btLigar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btCardapio:
                startActivity(new Intent(getApplicationContext(),Cardapio.class));
                break;
            case R.id.btContato:
                break;
            case R.id.btLigar:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:123456789"));
                startActivity(callIntent);
                break;
        }
    }
}
