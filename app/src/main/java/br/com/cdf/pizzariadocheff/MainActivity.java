package br.com.cdf.pizzariadocheff;

import android.app.FragmentTransaction;
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
                    //// TODO: 8/31/16 melhorar para o primeiro acesso
                    case (R.id.tab_ligar):
                        fm.beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                        fm.beginTransaction().addToBackStack(null);
                        break;
                    case (R.id.tab_cardapio):
                        fm.beginTransaction().replace(R.id.fragment_container, new CardapioFragment()).commit();
                        fm.beginTransaction().addToBackStack(null);
                        break;
                    case (R.id.tab_localizacao):
                        break;
                    case (R.id.tab_facebook):
                        break;
                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                switch (tabId) {
                    //// TODO: 8/31/16 melhorar para o primeiro acesso
                    case (R.id.tab_ligar):
                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:123456789"));
                        startActivity(callIntent);
                        break;
                    case (R.id.tab_cardapio):
                        fm.beginTransaction().replace(R.id.fragment_container, new CardapioFragment()).commit();
                        fm.beginTransaction().addToBackStack(null);
                        break;
                    case (R.id.tab_localizacao):
                        break;
                    case (R.id.tab_facebook):
                        break;
                }
            }
        });
    }
}
