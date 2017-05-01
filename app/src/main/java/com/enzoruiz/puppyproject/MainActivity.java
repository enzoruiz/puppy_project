package com.enzoruiz.puppyproject;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.enzoruiz.puppyproject.adaptadores.PageAdapter;
import com.enzoruiz.puppyproject.fragments.ListaFragment;
import com.enzoruiz.puppyproject.fragments.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    public ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ListaFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    public void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_puppylist);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_puppyperfil);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mEstrella:
                Intent intentEstrella = new Intent(MainActivity.this, DetalleMascota.class);
                startActivity(intentEstrella);
                break;
            case R.id.mContacto:
                Intent intentContacto = new Intent(MainActivity.this, ContactoActivity.class);
                startActivity(intentContacto);
                break;
            case R.id.mAcercade:
                Intent intentAcercade = new Intent(MainActivity.this, Acercade.class);
                startActivity(intentAcercade);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_menus, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
