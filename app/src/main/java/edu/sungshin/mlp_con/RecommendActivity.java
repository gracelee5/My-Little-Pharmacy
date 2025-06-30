package edu.sungshin.mlp_con;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class RecommendActivity extends AppCompatActivity{

    Button re1, re2, re3, re4, re5, re6, re7,re8;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recommend_item);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("영양제 추천");


        Intent intent2 = getIntent(); //전달할 데이터를 받을 Intent
        //text 키값으로 데이터를 받는다. String을 받아야 하므로 getStringExtra()를 사용함
        int CChecked[] = intent2.getIntArrayExtra("CCheck");
        int WChecked[] = intent2.getIntArrayExtra("WCheck");

        re1 = findViewById(R.id.re1);
        re2 = findViewById(R.id.re2);
        re3 = findViewById(R.id.re3);
        re4 = findViewById(R.id.re4);
        re5 = findViewById(R.id.re5);
        re6 = findViewById(R.id.re6);
        re7 = findViewById(R.id.re7);
        re8 = findViewById(R.id.re8);

        // 피부 건강
        if(WChecked[0]==1) {
            re1.setVisibility(View.VISIBLE);
            re1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        // 눈 건강
        if(WChecked[1]==1) {
            re2.setVisibility(View.VISIBLE);
            re2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain3.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        //간 건강
        if(WChecked[2]==1) {
            re3.setVisibility(View.VISIBLE);
            re3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain2.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        // 뼈 건강
        if(WChecked[3]==1) {
            re4.setVisibility(View.VISIBLE);
            re4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain4.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        // 스트레스
        if(WChecked[4]==1) {
            re5.setVisibility(View.VISIBLE);
            re5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain7.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        // 피로
        if(WChecked[5]==1) {
            re6.setVisibility(View.VISIBLE);
            re6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain5.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        // 면역력
        if(WChecked[6]==1) {
            re7.setVisibility(View.VISIBLE);
            re7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain6.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });
        }
        // 종합
        if(WChecked[7]==1) {
            re8.setVisibility(View.VISIBLE);
            re8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent db_intent = new Intent(getApplicationContext(), RecommendItemMain8.class);
                    db_intent.putExtra("CCheck", CChecked);
                    startActivity(db_intent);
                }
            });

        }


    }

}