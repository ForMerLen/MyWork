package com.example.mywork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        initView();
        initEvent();

        iv_code.setImageBitmap(Code.getInstance().createBitmap());

    }

    private void initEvent() {
        iv_code.setOnClickListener(this);
    }

    private void initView() {
        iv_code = (ImageView)findViewById(R.id.iv_code);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.iv_code:
                iv_code.setImageBitmap(Code.getInstance().createBitmap());
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
