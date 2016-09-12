package com.zhuyuguang.checkpermissionactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends CheckPermissionActivity implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        button3 = (Button) findViewById(R.id.button3);
        text = (TextView) findViewById(R.id.text);

        button1.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                checkPermission(this, CALL_PHONE, 3);
                break;
            case R.id.button3:
                checkPermission(this, WRITE_EXTERNAL_STORAGE, 1);
                break;
        }
    }
//
//    @Override
//    protected void onCallPhoneResult(int requestCode, boolean isSucess) {
//        text.setText("callphone"+requestCode+isSucess);
//    }
//
//    @Override
//    protected void onWriteExternalStoragerResult(int requestCode, boolean isSucess) {
//        text.setText("writeextera"+requestCode+isSucess);
//    }


    @Override
    protected void onPermissionResult(String permission, int requestCode, boolean isSucess) {
        if (permission.equals(CALL_PHONE)) {
            if (isSucess) {
                text.setText(permission + ":" + requestCode + "true" + "callphone");
            } else {
                text.setText(permission + ":" + requestCode + "flase" + "callphone");
            }
        } else if (permission.equals(WRITE_EXTERNAL_STORAGE)) {
            if (isSucess) {
                text.setText(permission + ":" + requestCode + "true" + "write");
            } else {
                text.setText(permission + ":" + requestCode + "false" + "write");
            }

        }
    }


}
