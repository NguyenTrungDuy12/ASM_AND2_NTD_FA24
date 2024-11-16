package com.example.asm_and2_ntd_fa24;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.asm_and2_ntd_fa24.DAO.UserDAO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    EditText edtUser,  edtName;
    Button btnBack;
    TextView tvSignup;
    private UserDAO userDAO;
    private TextInputEditText passwordEditText, passwordEditText1;
    private TextInputLayout passwordTextInputLayout, passwordTextInputLayout1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        init();

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtName.setError("Vui lòng nhập họ tên");
                } else {
                    edtName.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edtUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    edtUser.setError("Vui lòng nhập họ tên");
                } else {
                    edtUser.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tvSignup.setOnClickListener(v -> {
            String user = edtUser.getText().toString();
            String pass = passwordEditText.getText().toString();
            String repass = passwordEditText1.getText().toString();
            String name = edtName.getText().toString();

            if (user.equals("") || pass.equals("") || repass.equals("") || name.equals("")) {
                if (user.equals("")) {
                    edtUser.setError("Vui lòng nhập tên đăng nhập");
                } else {
                    edtUser.setError(null);
                    if (!isValidEmail(user)){
                        edtUser.setError("Email không hợp lệ");
                    }
                    else {
                        edtUser.setError(null);
                    }
                }

                if (pass.equals("") && repass.equals("")) {
                    passwordEditText.setError("Vui lòng nhập mật khẩu");
                    passwordEditText1.setError("Vui lòng nhập lại mật khẩu");
                } else {
                    passwordEditText.setError(null);
                    passwordEditText1.setError(null);
                    if (!pass.equals(repass)){
                        passwordEditText.setError("Mật khẩu không khớp");
                        passwordEditText1.setError("Mật khẩu không khớp");
                    }
                    else {
                        passwordEditText.setError(null);
                        passwordEditText1.setError(null);
                    }
                }

                if(name.equals("")){
                    edtName.setError("Vui lòng nhập họ tên");
                }
                else {
                    edtName.setError(null);
                }
            }
            else {
                showToast("Dang ky thanh cong");
                Intent intent = new Intent();
                intent.putExtra("user", user);
                intent.putExtra("name", name);
                setResult(1, intent);
                finish();
            }


        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });

    }

//                if(!pass.equals(repass)){
//                    Toast.makeText(RegisterActivity.this, "Nhập hai mk không trung nhau", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    boolean check = userDAO.checkRegister(user, pass, name);
//                    if(check){
//                        Toast.makeText(RegisterActivity.this, "Register succesful", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                    else {
//                        Toast.makeText(RegisterActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
//                    }
//                }







    private boolean isValidEmail(String user) {
            return Patterns.EMAIL_ADDRESS.matcher(user).matches();
    }

    public void showToast(String t){
        Toast.makeText(this, t, Toast.LENGTH_SHORT).show();
    }

    public void init(){
        edtUser = findViewById(R.id.edtUser);
        edtName = findViewById(R.id.edtName);
        tvSignup = findViewById(R.id.tvSignup);
        btnBack = findViewById(R.id.btnBack);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordEditText1 = findViewById(R.id.passwordEditText1);
        passwordTextInputLayout = findViewById(R.id.passwordTextInputLayout);
        passwordTextInputLayout1 = findViewById(R.id.passwordTextInputLayout1);
        passwordTextInputLayout.setPasswordVisibilityToggleEnabled(true);
        passwordTextInputLayout1.setPasswordVisibilityToggleEnabled(true);
    }
}