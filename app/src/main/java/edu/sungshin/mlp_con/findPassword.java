package edu.sungshin.mlp_con;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class findPassword extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseRef;
    private EditText editTextEmail;
    private Button mBtnSend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        editTextEmail = findViewById(R.id.sendEmail);
        mBtnSend = findViewById(R.id.btnSend);
        mAuth = FirebaseAuth.getInstance();

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = editTextEmail.getText().toString().trim();

                if(!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()) {
                    editTextEmail.setError("올바른 이메일 주소를 입력하세요.");
                    editTextEmail.requestFocus();
                    return;
                }
                mAuth.sendPasswordResetEmail(txtEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(findPassword.this, "비밀번호 재설정 메일이 발송되었습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(findPassword.this, LoginActivity.class);
                            startActivity(intent);

                        }

                        else {
                            Toast.makeText(findPassword.this, "메일 발송을 실패했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


}
