package edu.sungshin.mlp_con;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class AddActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private EditText editText;
    private Button buttonSave, buttonCancel;
    private Alarm alarm;
    private boolean needRefresh;
    @RequiresApi(api=Build.VERSION_CODES.M)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        timePicker=findViewById(R.id.timePicker);
        editText=findViewById(R.id.name);
        buttonSave=findViewById(R.id.button_save);
        buttonCancel=findViewById(R.id.button_cancel);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour=timePicker.getCurrentHour();
                int minute=timePicker.getCurrentMinute();
                String name=editText.getText().toString();
                DataBaseHelper db=new DataBaseHelper(getApplicationContext());
                alarm=new Alarm(hour,minute,true,name);
                db.addAlarm(alarm);
                needRefresh=true;
                onBackPressed();

            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void finish(){
        Intent data=new Intent();
        data.putExtra("needRefresh",needRefresh);
        this.setResult(RESULT_OK,data);
        super.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu11:
                AlertDialog.Builder dlg=new AlertDialog.Builder(AddActivity.this);
                dlg.setTitle("알람 설정 방법");
                dlg.setMessage("오전과 오후를 설정하고 알람이 울리고자 하는 시간을 다이얼을 돌려가면서 설정한 후 알람 추가 버튼을 누르면 정해진 시간에 알람이 울립니다.");
                dlg.setPositiveButton("닫기",null);
                dlg.show();



        }
        return super.onOptionsItemSelected(item);
    }

}

