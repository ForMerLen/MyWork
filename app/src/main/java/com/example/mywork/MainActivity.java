package com.example.mywork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getName();
    private ImageView iv_showCode;
    private EditText et_phoneCode;
    private Button login;
    private String realCode;
    private Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

        iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
        realCode = Code.getInstance().getCode().toLowerCase();

    }

    private void initEvent() {
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        iv_showCode.setOnClickListener(this);
    }

    private void initView() {
        login = (Button) findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);
        iv_showCode= (ImageView)findViewById(R.id.iv_showCode);
        et_phoneCode=(EditText)findViewById(R.id.et_phoneCodes);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.iv_showCode:
                iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
                realCode = Code.getInstance().getCode().toLowerCase();

                break;
            case R.id.login:
                String phoneCode = et_phoneCode.getText().toString().toLowerCase();
                String msg = "生成的验证码："+realCode+"输入的验证码:"+phoneCode;
                Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();

                if (phoneCode.equals(realCode)) {
                    Toast.makeText(MainActivity.this, phoneCode + "验证码正确", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, MainWin.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                } else {
                    iv_showCode.setImageBitmap(Code.getInstance().createBitmap());
                    realCode = Code.getInstance().getCode().toLowerCase();
                    et_phoneCode.setText("");
                }
                break;
            case R.id.register:
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Register.class);
                MainActivity.this.startActivity(intent);
                break;
        }
    }

}

