package edu.sungshin.mlp_con;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    InfoFragment infoFragment;
    RecommendFragment recommendFragment;
    private final long finishtimeed = 1000;
    private long presstime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeFragment=new HomeFragment();
        infoFragment=new InfoFragment();
        recommendFragment=new RecommendFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();
        NavigationBarView navigationBarView=findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.recommend:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,recommendFragment).commit();
                        return true;
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();
                        return true;
                    case R.id.info:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,infoFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
    private long backKeyPressedTime=0;
    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis()>backKeyPressedTime+2000){
            backKeyPressedTime=System.currentTimeMillis();
            Toast.makeText(this,"\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.",Toast.LENGTH_SHORT).show();
            return;
        }
        if(System.currentTimeMillis()<=backKeyPressedTime+2000){
            ActivityCompat.finishAffinity(this);
            System.exit(0);
        }
    }


}