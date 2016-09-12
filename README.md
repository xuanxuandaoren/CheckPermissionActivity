#简化安卓6.0权限代码
最近业余时间在写一个APP,由于时间比较赶，要在半个月内写好，二三十页面，光是运行时权限代码就让我写的欲仙欲死，于是就痛下决心，一定要把这个给干掉，于是写完之后就立马写了两个基类，简化运行时权限代码
##用法
与自定义控件不一样，不能先展示效果图了，那就只能展示一下怎么用，大家看一看有没有简单一些，如果觉得有什么不妥的欢迎大家指出
###1，继承CheckPermissionActivity
去github上下载CheckPermissionActivity，把要处理的运行权限的activity继承CheckPermissionActivity

```
public class MainActivity extends CheckPermissionActivity implements View.OnClickListener {
```

CheckPermissionActivity下载地址→[点击此处进入下载页面](https://github.com/xuanxuandaoren/CheckPermissionActivity)
##调用  checkPermission(this,CALL_PHONE,3);方法
调用  checkPermission(this,CALL_PHONE,3);，其中第一个参数就是Activity，第二个参数就是自己想要获取的权限，第三个就是请求码。

```
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                checkPermission(this,CALL_PHONE,3);
                break;
            case R.id.button3:
                checkPermission(this,WRITE_EXTERNAL_STORAGE,1);
                break;
        }
    }
```
###重写onPermissionResult(String permission, int requestCode，boolean isSucess)方法，
重写onRequestPermissionsResult(String permission, int requestCode,boolean isSucess)，他会把请求的权限和请求码回调回来，然后可以根据自己的请求码和权限判断是哪一次请求并进行处理，第一个参数是请求的权限，第二个是请求码,第三个是是否获取权限

```

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
                ;
            }

        }
    }
```
怎么样，是不是比之前简单多了，当然你要是觉得还有点麻烦的话可以继承CheckPermissionExtendActivity
###CheckPermissionExtendActivity
####下载并继承CheckPermissionExtendActivity
CheckPermissionExtendActivity下载地址→[点击此处进入下载页面](https://github.com/xuanxuandaoren/CheckPermissionActivity)

```
public class MainActivity extends CheckPermissionExtendActivity implements View.OnClickListener {
```
####调用checkPermission(this,CALL_PHONE,3)

```
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                checkPermission(this,CALL_PHONE,3);
                break;
            case R.id.button3:
                checkPermission(this,WRITE_EXTERNAL_STORAGE,1);
                break;
        }
    }
```
####重写onXXXResult(int requestCode, boolean isSucess)方法
重写onXXXResult(int requestCode, boolean isSucess)方法，其中xxx就是请求权限的单词，比如说，申请的CALL_PHONE权限，则需要重写onCallPhoneResult，申请的是WRITE_EXTERNAL_STORAGE权限，重写的就是onWriteExternalStoragerResult，这样就可以不用根据返回的permission进行判断了，其中requestcode是请求码，issucess代表用户是否授权

```
    @Override
    protected void onCallPhoneResult(int requestCode, boolean isSucess) {
        text.setText("callphone"+requestCode+isSucess);
    }

    @Override
    protected void onWriteExternalStoragerResult(int requestCode, boolean isSucess) {
        text.setText("writeextera"+requestCode+isSucess);
    }
```
##源码解析

###定义一个检查额权限的函数

```
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
```
###定义一个回调函数

```
 /**
     * 请求调的函数
     * @param permission 权限
     * @param requestCode 请求码
     */
    protected void onPermissionResult(String permission,int requestCode,boolean isSucess){};
    
###进行回调
首先在检查权限时，如果有权限就直接回调

```
    public void checkPermission(Activity activity, String permission, int checkCode) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{permission},
                    checkCode);

        } else {
            //
            onPermissionResult(permission,checkCode,true);
        }

    }
```
如果是没有权限则申请权限，并在结果里进行回调

```
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
```
好了，一个简单的封装就完成了。
