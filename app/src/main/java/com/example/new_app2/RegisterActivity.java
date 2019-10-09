package com.example.new_app2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameET;
    private EditText passwordET;
    private EditText confirmPasswordET;
    private RadioButton manRBtn;
    private RadioButton womanRBtn;
    private ImageView headIV;
    private Button registerBtn;
    private Button cancelRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        nameET = (EditText) findViewById(R.id.nameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        confirmPasswordET = (EditText) findViewById(R.id.confirmPasswordET);
        manRBtn = (RadioButton) findViewById(R.id.manRBtn);
        womanRBtn = (RadioButton) findViewById(R.id.womanRBtn);
        headIV = (ImageView) findViewById(R.id.headIV);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        cancelRegBtn = (Button) findViewById(R.id.cancelRegBtn);

        registerBtn.setOnClickListener(this);
        cancelRegBtn.setOnClickListener(this);
        headIV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerBtn:
                submit();
                break;
            case R.id.cancelRegBtn:
                finish();
                break;
            case R.id.headIV:
                Intent intent = new Intent(RegisterActivity.this, ChoseImage.class);
                startActivityForResult(intent,1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 选择头像的回调
         */
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                int image = data.getIntExtra("image",0);
                if(image != 0){
                    headIV.setImageResource(image);
                }
            }
        }
    }

    private void submit() {
        // validate
        String nameETString = nameET.getText().toString().trim();
        if (TextUtils.isEmpty(nameETString)) {
            Toast.makeText(this, "nameETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordETString = passwordET.getText().toString().trim();
        if (TextUtils.isEmpty(passwordETString)) {
            Toast.makeText(this, "passwordETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String confirmPasswordETString = confirmPasswordET.getText().toString().trim();
        if (TextUtils.isEmpty(confirmPasswordETString)) {
            Toast.makeText(this, "confirmPasswordETString不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!passwordETString.equals(confirmPasswordETString)){
            Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
