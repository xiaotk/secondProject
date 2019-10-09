package com.example.new_app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChoseImage extends AppCompatActivity implements View.OnClickListener {

    private ImageView image_1;
    private ImageView image_2;
    private ImageView image_3;
    private ImageView image_4;
    private ImageView image_5;
    private ImageView image_6;
    private Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_image);
        initView();
    }

    private void initView() {
        image_1 = (ImageView) findViewById(R.id.image_1);
        image_2 = (ImageView) findViewById(R.id.image_2);
        image_3 = (ImageView) findViewById(R.id.image_3);
        image_4 = (ImageView) findViewById(R.id.image_4);
        image_5 = (ImageView) findViewById(R.id.image_5);
        image_6 = (ImageView) findViewById(R.id.image_6);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        cancelBtn.setOnClickListener(this);
        image_1.setOnClickListener(this);
        image_2.setOnClickListener(this);
        image_3.setOnClickListener(this);
        image_4.setOnClickListener(this);
        image_5.setOnClickListener(this);
        image_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancelBtn:
//                Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.image_1:
                retImage(R.drawable.g2);
                break;
            case R.id.image_2:
                retImage(R.drawable.g1);
                break;
            case R.id.image_3:
                retImage(R.drawable.g3);
                break;
            case R.id.image_4:
                retImage(R.drawable.g4);
                break;
            case R.id.image_5:
                retImage(R.drawable.g5);
                break;
            case R.id.image_6:
                retImage(R.drawable.g6);
                break;
        }
    }

    /**
     * 返回Image的Id
     * @param imageId
     */
    private void retImage(int imageId) {
        Intent intent = new Intent();
        intent.putExtra("image",imageId);
        setResult(RESULT_OK,intent);
        finish();
    }
}
