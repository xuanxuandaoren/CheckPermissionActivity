package com.zhuyuguang.checkpermissionactivity;

import android.Manifest;
import android.Manifest.permission;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by 玉光 on 2016-9-12.
 */
public class CheckPermissionExtendActivity extends Activity {

    public static final String CONTACTS = Manifest.permission_group.CONTACTS;
    public static final String WRITE_CONTACTS = permission.WRITE_CONTACTS;
    public static final String GET_ACCOUNTS = permission.GET_ACCOUNTS;
    public static final String READ_CONTACTS = permission.READ_CONTACTS;

    public static final String PHONE = Manifest.permission_group.PHONE;
    public static final String READ_CALL_LOG = permission.READ_CALL_LOG;
    public static final String READ_PHONE_STATE = permission.READ_PHONE_STATE;
    public static final String CALL_PHONE = permission.CALL_PHONE;
    public static final String WRITE_CALL_LOG = permission.WRITE_CALL_LOG;
    public static final String USE_SIP = permission.USE_SIP;
    public static final String PROCESS_OUTGOING_CALLS = permission.PROCESS_OUTGOING_CALLS;
    public static final String ADD_VOICEMAIL = permission.ADD_VOICEMAIL;

    public static final String CALENDAR = Manifest.permission_group.CALENDAR;
    public static final String READ_CALENDAR = permission.READ_CALENDAR;
    public static final String WRITE_CALENDAR = permission.WRITE_CALENDAR;

    public static final String GROUP_CAMERA = Manifest.permission_group.CAMERA;
    public static final String CAMERA = permission.CAMERA;

    public static final String SENSORS = Manifest.permission_group.SENSORS;
    public static final String BODY_SENSORS = permission.BODY_SENSORS;

    public static final String LOCATION = Manifest.permission_group.LOCATION;
    public static final String ACCESS_FINE_LOCATION = permission.ACCESS_FINE_LOCATION;
    public static final String ACCESS_COARSE_LOCATION = permission.ACCESS_COARSE_LOCATION;

    public static final String STORAGE = Manifest.permission_group.STORAGE;
    public static final String READ_EXTERNAL_STORAGE = permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = permission.WRITE_EXTERNAL_STORAGE;

    public static final String MICROPHONE = Manifest.permission_group.MICROPHONE;
    public static final String RECORD_AUDIO = permission.RECORD_AUDIO;

    public static final String SMS = Manifest.permission_group.SMS;
    public static final String READ_SMS = permission.READ_SMS;
    public static final String RECEIVE_WAP_PUSH = permission.RECEIVE_WAP_PUSH;
    public static final String RECEIVE_MMS = permission.RECEIVE_MMS;
    public static final String RECEIVE_SMS = permission.RECEIVE_SMS;
    public static final String SEND_SMS = permission.SEND_SMS;

    //    public static final String ADD_VOICEMAIL =Manifest.permission.READ_CELL_BROADCASTS;

    /**
     * 检查权限是否存在，如不存在就申请
     *
     * @param activity
     * @param permission
     * @param checkCode
     */
    public void checkPermission(Activity activity, String permission, int checkCode) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{permission},
                    checkCode);

        } else {
            //
            selectMethod(permission, checkCode, true);
        }

    }

    /**
     * 根据权限判断调用哪个方法
     *
     * @param permission
     * @param checkCode
     * @param isSucess
     */
    private void selectMethod(String permission, int checkCode, boolean isSucess) {
        if (CONTACTS.equals(permission)) {
            onContactsResult(checkCode, isSucess);
        } else if (WRITE_CONTACTS.equals(permission)) {
            onWriteContactResult(checkCode, isSucess);
        } else if (GET_ACCOUNTS.equals(permission)) {
            onGetAccountsResult(checkCode, isSucess);
        } else if (READ_CONTACTS.equals(permission)) {
            onReadContactsResult(checkCode, isSucess);

        } else if (PHONE.equals(permission)) {
            onPhoneResult(checkCode, isSucess);
        } else if (READ_CALL_LOG.equals(permission)) {
            onReadCallLogResult(checkCode, isSucess);
        } else if (READ_PHONE_STATE.equals(permission)) {
            onReadPhoneStateResult(checkCode, isSucess);
        } else if (CALL_PHONE.equals(permission)) {
            onCallPhoneResult(checkCode, isSucess);
        } else if (WRITE_CALL_LOG.equals(permission)) {
            onWriteCallLogResult(checkCode, isSucess);
        } else if (USE_SIP.equals(permission)) {
            onUseSipResult(checkCode, isSucess);
        } else if (PROCESS_OUTGOING_CALLS.equals(permission)) {
            onProcessOutGoingCallResult(checkCode, isSucess);
        } else if (ADD_VOICEMAIL.equals(permission)) {
            onAddVoicEmailResult(checkCode, isSucess);
        } else if (CALENDAR.equals(permission)) {
            onCalenderResult(checkCode, isSucess);
        } else if (READ_CALENDAR.equals(permission)) {
            onReadCalendarResult(checkCode, isSucess);
        } else if (WRITE_CALENDAR.equals(permission)) {
            onWriteCalendarResult(checkCode, isSucess);
        } else if (GROUP_CAMERA.equals(permission)) {
            onGroupCameraResult(checkCode, isSucess);
        } else if (CAMERA.equals(permission)) {
            onCameraResult(checkCode, isSucess);
        } else if (SENSORS.equals(permission)) {
            onSensorsResult(checkCode, isSucess);
        } else if (BODY_SENSORS.equals(permission)) {
            onBodySensorsResult(checkCode, isSucess);
        } else if (LOCATION.equals(permission)) {
            onLocationResult(checkCode, isSucess);
        } else if (ACCESS_FINE_LOCATION.equals(permission)) {
            onAccessFineLocationResult(checkCode, isSucess);
        } else if (ACCESS_COARSE_LOCATION.equals(permission)) {
            onAccessCoarserLocationResult(checkCode, isSucess);
        } else if (STORAGE.equals(permission)) {
            onStorageResult(checkCode, isSucess);
        } else if (READ_EXTERNAL_STORAGE.equals(permission)) {
            onReadExternalStoragerResult(checkCode, isSucess);
        } else if (WRITE_EXTERNAL_STORAGE.equals(permission)) {
            onWriteExternalStoragerResult(checkCode, isSucess);
        } else if (MICROPHONE.equals(permission)) {
            onMicrophoneResult(checkCode, isSucess);
        } else if (RECORD_AUDIO.equals(permission)) {
            onRecordAudioResult(checkCode, isSucess);
        } else if (SMS.equals(permission)) {
            onSmsResult(checkCode, isSucess);
        } else if (READ_SMS.equals(permission)) {
            onReadSmsResult(checkCode, isSucess);
        } else if (RECEIVE_WAP_PUSH.equals(permission)) {
            onReceiveWapPushResult(checkCode, isSucess);
        } else if (RECEIVE_MMS.equals(permission)) {
            onReceiveMmsResult(checkCode, isSucess);
        } else if (RECEIVE_SMS.equals(permission)) {
            onReceivesmsResult(checkCode, isSucess);
        } else if (READ_SMS.equals(permission)) {
            onReadSmsResult(checkCode, isSucess);
        } else {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // If request is cancelled, the result arrays are empty.
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            selectMethod(permissions[0], requestCode, true);
            // permission was granted, yay! Do the
            // contacts-related task you need to do.

        } else {
            selectMethod(permissions[0], requestCode, false);

            // permission denied, boo! Disable the
            // functionality that depends on this permission.
        }
    }


    protected void onContactsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onContactsRefuse(int requestCode) {
//    }

    ;

    protected void onWriteContactResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onWritecontactRefuse(int requestCode) {
//    }

    ;

    /**
     * GET_ACCOUNTS
     *
     * @param requestCode
     */
    protected void onGetAccountsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onGetContactsRefuse(int requestCode) {
//    }

    ;

    protected void onReadContactsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReadContactsRefuse(int requestCode) {
//    }

    ;

    protected void onPhoneResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onPhoneRefuse(int requestCode) {
//    }

    ;

    protected void onReadCallLogResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReadCallLogRefuse(int requestCode) {
//    }

    ;

    protected void onReadPhoneStateResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReadPhoneStateRefuse(int requestCode) {
//    }

    ;

    protected void onCallPhoneResult(int requestCode, boolean isSucess) {
    }

    ;
//
//    protected void onCallPhoneRefuse(int requestCode) {
//    }

    ;

    protected void onWriteCallLogResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onWriteCallLogRefuse(int requestCode) {
//    }

    ;

    protected void onUseSipResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onUseSipRefuse(int requestCode) {
//    }

    ;

    protected void onProcessOutGoingCallResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void oProcessOutGoingCallRefuse(int requestCode) {
//    }

    ;

    protected void onAddVoicEmailResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onAddVoicEmailRefuse(int requestCode) {
//    }

    ;

    protected void onCalenderResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onCalenderRefuse(int requestCode) {
//    }

    ;

    protected void onReadCalendarResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReadCalendarRefuse(int requestCode) {
//    }

    ;

    protected void onWriteCalendarResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onWriteCalendarRefuse(int requestCode) {
//    }

    ;

    protected void onGroupCameraResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onGroupCameraRefuse(int requestCode) {
//    }

    ;

    protected void onCameraResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onCameraRefuse(int requestCode) {
//    }

    ;

    protected void onSensorsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onSensorsRefuse(int requestCode) {
//    }

    ;

    protected void onBodySensorsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onBodySensorsRefuse(int requestCode) {
//    }

    ;

    protected void onLocationResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onLocationRefuse(int requestCode) {
//    }

    ;

    protected void onAccessFineLocationResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onAccessFineLocationRefuse(int requestCode) {
//    }

    ;

    protected void onAccessCoarserLocationResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onAccessCoarserLocationRefuse(int requestCode) {
//    }

    ;

    protected void onStorageResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onStorageRefuse(int requestCode) {
//    }

    ;

    protected void onReadExternalStoragerResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReadExternalStoragerRefuse(int requestCode) {
//    }

    ;

    protected void onWriteExternalStoragerResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onWriteExternalStoragerRefuse(int requestCode) {
//    }

    ;

    protected void onMicrophoneResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onMicrophonesRefuse(int requestCode) {
//    }

    ;

    protected void onRecordAudioResult(int requestCode, boolean isSucess) {
    }

    ;
//
//    protected void onRecordAudioRefuse(int requestCode) {
//    }

    ;

    protected void onSmsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onSmsRefuse(int requestCode) {
//    }

    ;

    protected void onReadSmsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReadSmsRefuse(int requestCode) {
//    }

    ;

    protected void onReceiveWapPushResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReceiveWapPushRefuse(int requestCode) {
//    }

    ;

    protected void onReceiveMmsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReceiveMmsRefuse(int requestCode) {
//    }

    ;

    protected void onReceivesmsResult(int requestCode, boolean isSucess) {
    }

    ;

//    protected void onReceivesmsRefuse(int requestCode) {
//    }

    ;

    protected void onSendSmsResult(int requestCode, boolean isSucess) {
    }

    ;
    //
    //    protected void onSendSmsRefuse(int requestCode) {
    //    }

    ;

}
