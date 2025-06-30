package edu.sungshin.mlp_con;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText mEtEmail, mEtPwd, mEtCPwd;
    private Button mBtnRegister, mBtnFind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("MLP");

        mEtCPwd = findViewById(R.id.pwCheckEditText);
        mEtEmail = findViewById(R.id.idEditText);
        mEtPwd = findViewById(R.id.pwEditText);
        mBtnRegister = findViewById(R.id.btnJoin);
        mBtnFind = findViewById(R.id.btnRst);

        mBtnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),findPassword.class);
                startActivity(intent);
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strEmail = mEtEmail.getText().toString().trim();
                String strPwd = mEtPwd.getText().toString();
                String strCPwd = mEtCPwd.getText().toString();
                if(!Patterns.EMAIL_ADDRESS.matcher(strEmail).matches()){
                    mEtEmail.setError("올바른 이메일 주소를 입력하세요");
                    mEtEmail.requestFocus();
                    return;
                }

                if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$", strPwd)) {
                    Toast.makeText(RegisterActivity.this, "비밀번호 형식을 지켜주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (strEmail.length() != 0 && strPwd.length() != 0 && strCPwd.length() != 0) {
                    if(strPwd.equals(strCPwd)) {
                        mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                                    UserAccount account = new UserAccount();
                                    account.setIdToken(firebaseUser.getUid());
                                    account.setEmailId(firebaseUser.getEmail());
                                    account.setPassword(strPwd);

                                    mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);


                                    Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }else {
                        Toast.makeText(RegisterActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(RegisterActivity.this, "각 란의 입력을 완료하여 주십사오.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
