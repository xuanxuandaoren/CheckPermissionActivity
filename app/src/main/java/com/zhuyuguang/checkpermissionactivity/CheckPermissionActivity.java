package com.zhuyuguang.checkpermissionactivity;

import android.Manifest;
import android.Manifest.permission;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by 玉光 on 2016-9-12.
 */
public class CheckPermissionActivity extends Activity {
    /**
     * 请求权限的码
     */
    public int requestCode = -1;

    public static final String CONTACTS = Manifest.permission_group.CONTACTS;
    public static final String WRITE_CONTACTS = Manifest.permission.WRITE_CONTACTS;
    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;
    public static final String READ_CONTACTS = Manifest.permission.READ_CONTACTS;

    public static final String PHONE = Manifest.permission_group.PHONE;
    public static final String READ_CALL_LOG = Manifest.permission.READ_CALL_LOG;
    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String WRITE_CALL_LOG = Manifest.permission.WRITE_CALL_LOG;
    public static final String USE_SIP = Manifest.permission.USE_SIP;
    public static final String PROCESS_OUTGOING_CALLS = Manifest.permission.PROCESS_OUTGOING_CALLS;
    public static final String ADD_VOICEMAIL = Manifest.permission.ADD_VOICEMAIL;

    public static final String CALENDAR = Manifest.permission_group.CALENDAR;
    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;
    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;

    public static final String GROUP_CAMERA = Manifest.permission_group.CAMERA;
    public static final String CAMERA = Manifest.permission.CAMERA;

    public static final String SENSORS = Manifest.permission_group.SENSORS;
    public static final String BODY_SENSORS = Manifest.permission.BODY_SENSORS;

    public static final String LOCATION = Manifest.permission_group.LOCATION;
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    public static final String STORAGE = Manifest.permission_group.STORAGE;
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    public static final String MICROPHONE = Manifest.permission_group.MICROPHONE;
    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;

    public static final String SMS = Manifest.permission_group.SMS;
    public static final String READ_SMS = Manifest.permission.READ_SMS;
    public static final String RECEIVE_WAP_PUSH = Manifest.permission.RECEIVE_WAP_PUSH;
    public static final String RECEIVE_MMS = Manifest.permission.RECEIVE_MMS;
    public static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;

    //    public static final String ADD_VOICEMAIL =Manifest.permission.READ_CELL_BROADCASTS;

    /**
     * 检查权限的函数，如果有就直接调用，没有则申请后调用
     * @param activity 调用的activity
     * @param permission 检查的权限
     * @param checkCode 请求码
     */
    public void checkPermission(Activity activity, String permission, int checkCode) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{permission},
                    checkCode);

        } else {
            //
            onPermissionResult(permission,checkCode,true);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // permission was granted, yay! Do the
            // contacts-related task you need to do.
            onPermissionResult(permissions[0],requestCode,true);

        } else {

            // permission denied, boo! Disable the
            // functionality that depends on this permission.
            onPermissionResult(permissions[0],requestCode,false);
        }
    }

    /**
     * 请求调的函数
     * @param permission 权限
     * @param requestCode 请求码
     */
    protected void onPermissionResult(String permission,int requestCode,boolean isSucess){};




}
