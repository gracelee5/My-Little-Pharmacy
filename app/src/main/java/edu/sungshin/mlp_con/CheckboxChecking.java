package edu.sungshin.mlp_con;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class CheckboxChecking extends AppCompatActivity {

    CheckBox worry1;
    CheckBox worry2;
    CheckBox worry3;
    CheckBox worry4;
    CheckBox worry5;
    CheckBox worry6;
    CheckBox worry7;
    CheckBox worry8;

    Button btnNext;

    CheckBox[] worryBoxes;

    int WChecked[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_checking);


        WChecked = new int[8];
        for (int a=0; a<8; a++) WChecked[a] = 0;


        worry1 = findViewById(R.id.worry1);
        worry2 = findViewById(R.id.worry2);
        worry3 = findViewById(R.id.worry3);
        worry4 = findViewById(R.id.worry4);
        worry5 = findViewById(R.id.worry5);
        worry6 = findViewById(R.id.worry6);
        worry7 = findViewById(R.id.worry7);
        worry8 = findViewById(R.id.worry8);
        worryBoxes = new CheckBox[8];
        worryBoxes[0] = worry1;
        worryBoxes[1] = worry2;
        worryBoxes[2] = worry3;
        worryBoxes[3] = worry4;
        worryBoxes[4] = worry5;
        worryBoxes[5] = worry6;
        worryBoxes[6] = worry7;
        worryBoxes[7] = worry8;


        worryBoxes[0].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[0].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[0] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[0] = 0;
                }
            }
        });
        worryBoxes[1].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[1].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[1] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[1] = 0;
                }
            }
        });
        worryBoxes[2].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[2].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[2] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[2] = 0;
                }
            }
        });
        worryBoxes[3].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[3].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[3] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[3] = 0;
                }
            }
        });
        worryBoxes[4].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[4].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[4] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[4] = 0;
                }
            }
        });
        worryBoxes[5].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[5].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[5] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[5] = 0;
                }
            }
        });
        worryBoxes[6].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[6].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[6] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[6] = 0;
                }
            }
        });
        worryBoxes[7].setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO : process the click event.
                if(worryBoxes[7].isChecked()) {    //체크 박스가 체크 된 경우
                    WChecked[7] = 1;
                }
                else {   //체크 박스가 해제 된 경우
                    WChecked[7] = 0;
                }
            }
        });


        btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 다음버튼 - 페이지 넘어가야함
                for(int b=0; b<8; b++) android.util.Log.i("테스트", String.valueOf(WChecked[b]));
                //finish();
                Intent intent1 = new Intent(getApplicationContext(), RecommendActivity.class);
                intent1.putExtra("WCheck", WChecked);
                startActivity(intent1);
            }
        });

    }
}