package com.example.myfunjoy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class LoginPage extends AppCompatActivity{

    private Button btnLogin;
    String userName = null;
    private String psw = null;//用户名，密码，加密密码
    private EditText et_user_name,etPsw;//用户名，密码
    private TextView tv_register,tv_find_psw;//注册账号和找回密码
    private ToggleButton tb_isShowpsw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        init();
    }


    private void init() {//初始化各个控件
        btnLogin = (Button) findViewById(R.id.btn_login);
        et_user_name = (EditText) findViewById(R.id.et_user_name);
        etPsw = (EditText) findViewById(R.id.et_password);
        tv_find_psw = (TextView) findViewById(R.id.tv_find_psw);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tb_isShowpsw = (ToggleButton) findViewById(R.id.tb_isShowPsw);
        tb_isShowpsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    etPsw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                else
                    etPsw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    System.out.println("adsfafafasdfasfas");
            }
        });
    btnLogin.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            userName = et_user_name.getText().toString();
            psw = etPsw.getText().toString();
        }
    });
    tv_register.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent(LoginPage.this,EnrollPage.class);
            startActivity(intent);
        }
    });
    }
//    @Override
//    protected void onActitvityResult(int requestCode,int resultCode,Intent data){
//        switch (requestCode){
//            case 1:
//                if(requestCode == RESULT_OK){
//                    String returnedUserID = data.getStringExtra("return_id");
//                    String returnedUserPSW = data.getStringExtra("return_psw");
//                    et_user_name.setText(returnedUserID);
//                    etPsw.setText(returnedUserPSW);
//                }
//                break;
//        }
//        default;
//    }
}
