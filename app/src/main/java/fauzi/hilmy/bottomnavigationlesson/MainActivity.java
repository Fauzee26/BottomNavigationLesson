package fauzi.hilmy.bottomnavigationlesson;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import fauzi.hilmy.bottomnavigationlesson.fragment.HomeFragment;
import fauzi.hilmy.bottomnavigationlesson.fragment.KulinerFragment;
import fauzi.hilmy.bottomnavigationlesson.fragment.WisataFragment;

public class MainActivity extends AppCompatActivity {

    //TODO Create Variable
    BottomNavigationView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Inisialisasi Variable
        view = findViewById(R.id.navigation);
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.mHome:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.mKuliner :
                        selectedFragment = new KulinerFragment();
                        break;
                    case R.id.mWisata :
                        selectedFragment = new WisataFragment();
                        break;
                }
                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.relativeLayout, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.relativeLayout, HomeFragment.newInstance());
        transaction.commit();
    }
}
