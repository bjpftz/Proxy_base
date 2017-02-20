package bjp.ftz.proxy_base.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.File;

import bjp.ftz.proxy_base.R;

/**
 * Created by bjp on 2016/9/19 10:26
 * Activity与Fragment的公共实现类
 */
public class IBaseAFImpl implements IBaseAF {
    private long CurrTime; // 当前时间
    private Activity activity;

    public IBaseAFImpl(Activity activity) {
        this.activity = activity;
    }

    @Override
    public <T> void MyLToast(T t) {
        MyToast(t, false);
    }

    @Override
    public <T> void MySToast(T t) {
        MyToast(t, true);
    }

    @Override
    public boolean isRoot() {
        boolean bool = false;
        try {
            bool = (!new File("/system/bin/su").exists()) || (!new File("/system/xbin/su").exists());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bool;
    }

    @Override
    public String getString(TextView tv) {
        return ((TextView) tv).getText().toString().trim();
    }

    @Override
    public <T> T findView(int Resources) {
        return (T) activity.findViewById(Resources);
    }

    @Override
    public <T> T findView(View view, int resouer) {
        return (T) view.findViewById(resouer);
    }

    @Override
    public Activity getAct() {
        return activity;
    }

    @Override
    public SharedPreferences getShared(String fileName) {
        return activity.getSharedPreferences(fileName, activity.MODE_PRIVATE);
    }

    @Override
    public SharedPreferences.Editor getEditor(String fileName) {
        return activity.getSharedPreferences(fileName, activity.MODE_PRIVATE).edit();
    }

    /**
     * 自定义吐司 flag：true为短吐司 false为长吐司
     */
    private <T> void MyToast(T t, boolean flag) {
        long CurrTime = System.currentTimeMillis();
        if ((CurrTime - this.CurrTime) < 2000) { // 如果当前时间减去上次触发的时间 小于两秒的话
            // 则不执行任何操作
            return;
        }
        this.CurrTime = CurrTime;
        Toast toast = new Toast(activity);
//        //判断软键盘是否弹出  如果弹出的话  则Toast显示在中间   如果没有弹出的话 则默认显示在下方
//        if (getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
//            toast.setGravity(Gravity.CENTER, 0, 0);
//        }
        LinearLayout layout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.toast_mytoast, null);
        TextView tv = (TextView) layout.findViewById(R.id.toast_mytoast_tv);
        tv.setText(t.toString());
        toast.setView(layout);
        if (flag) {
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
