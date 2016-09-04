package br.com.cdf.pizzariadocheff;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;


public class MainActivity extends AppCompatActivity{

    boolean firstAccess;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.fragment_container, new HomeFragment()).commit();

        firstAccess = true;
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case (R.id.tab_ligar):
                        homefragment();
                        if(!firstAccess) ligarfragment();
                        else    firstAccess = false;
                        break;
                    case (R.id.tab_cardapio):
                        cardapiofragment();
                        break;
                    case (R.id.tab_localizacao):
                        localizacaofragment();
                        break;
                    case (R.id.tab_facebook):
                        facebookfragment();
                        break;
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                switch (tabId) {
                    case (R.id.tab_ligar):
                        ligarfragment();
                        break;
                    case (R.id.tab_cardapio):
                        cardapiofragment();
                        break;
                    case (R.id.tab_localizacao):
                        localizacaofragment();
                        break;
                    case (R.id.tab_facebook):
                        facebookfragment();
                        break;
                }
            }
        });
    }

    private void ligarfragment() {
        String title = "Ligar";
        String message = "Deseja discar para "+getString(R.string.telefonepizzaria)+"?";
        customDialog(title, message);
    }


    private void homefragment() {
        fm.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        fm.beginTransaction().addToBackStack(null);
        return;
    }

    private void cardapiofragment() {
        fm.beginTransaction().replace(R.id.fragment_container, new CardapioFragment()).commit();
        fm.beginTransaction().addToBackStack(null);
    }

    private void localizacaofragment(){
        fm.beginTransaction().replace(R.id.fragment_container, new MapsActivity()).commit();
        fm.beginTransaction().addToBackStack(null);

    }

    private void facebookfragment() {
        String title;
        String message;
        title = "Facebook";
        message = "Deseja entrar no facebook da Pizzaria do Cheff?";
        customDialog(title, message);
    }

    public void customDialog(final String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        //builder.setCancelable(true);
        builder.setPositiveButton("Sim",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        switch (title){
                            case "Ligar":
                                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                                callIntent.setData(Uri.parse("tel:"+getString(R.string.telefonepizzaria)));
                                startActivity(callIntent);
                                break;
                            case "Facebook":
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pizza.do.cheff"));
                                startActivity(browserIntent);
                                break;
                        }
                    }
                });
        builder.setNegativeButton(
                "Nao",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        switch (title){
                            case "Ligar": dialog.cancel(); break;
                            case "Facebook": dialog.cancel(); break;
                        }
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
