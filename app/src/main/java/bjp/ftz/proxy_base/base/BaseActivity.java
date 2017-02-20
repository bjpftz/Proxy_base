package bjp.ftz.proxy_base.base;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by bjp on 2016/9/9 13:56
 * Activity的公共类
 */
public abstract class BaseActivity extends AppCompatActivity implements IBaseAF, IBaseActivity {
    private IBaseAF mIBaseAF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        //获取activity
        BaseActivity activity = getThisActivity();
        mIBaseAF = new IBaseAFImpl(activity);
        if (activity instanceof IBaseActivity) { // 判断子类是否已经实现了Base接口 如果实现了的话
            // 就强转 并调用方法
            IBaseActivity i = (IBaseActivity) activity;
            // 初始化视图
            i.initView();
            // 初始化数据
            i.initData();
            // 数据与视图绑定
            i.initOperView();
        } else {
            initView();
            initData();
            initOperView();
        }
//        //设置状态栏
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 设置状态栏透明
//            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            setColor(activity, getResources().getColor(R.color.colorAccent));
//        }
    }


    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }

    /**
     * @param resources 视图控件的ID
     * @return 返回该视图空间的实例 该控件可以是任何一类型的
     */

    public <T> T findView(int resources) {
        return mIBaseAF.findView(resources);
    }


    /**
     * @param view    根据指定 的视图控件 从中获取到视图控件
     * @param resouer 视图控件ID
     * @return 然会该视图控件
     */
    public <T> T findView(View view, int resouer) {
        return mIBaseAF.findView(view, resouer);
    }

    /**
     * 该方法中需要手动设置ContextView 设置布局文件 当子类实现了IBaseActiity接口的时候
     * IBaseActiity中的方法会在该方法执行完毕之后被依次调用: InitView - InitData - initEvent
     *
     * @return 返回当前子类Activity 子类实现该方法 替代onCreate方法 子类不需要重写onCreate
     */
    public abstract BaseActivity getThisActivity();

    /**
     * @return 返回父类中的activity引用
     */
    public BaseActivity getAct() {
        return (BaseActivity) mIBaseAF.getAct();
    }

    /**
     * 短土司
     *
     * @param t
     * @param <T>
     */
    public <T> void MySToast(T t) {
        mIBaseAF.MySToast(t);
    }

    /**
     * 长土司
     *
     * @param t
     * @param <T>
     */
    public <T> void MyLToast(T t) {
        mIBaseAF.MyLToast(t);
    }


    public void startActivity(@SuppressWarnings("rawtypes") Class c) {
        startActivity(new Intent(getAct(), c));
    }

    /**
     * 设置状态栏颜色 * * @param activity 需要设置的activity * @param color 状态栏颜色值
     */
    public View setColor(Activity activity, int color) {
        // 生成一个状态栏大小的矩形
        View statusView = createStatusView(activity, color);
        // 添加 statusView 到布局中
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        decorView.addView(statusView);
        // 设置根布局的参数
        ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        rootView.setFitsSystemWindows(true);
        rootView.setClipToPadding(true);
        return statusView;
    }

    /**
     * 生成一个和状态栏大小相同的矩形条 * * @param activity 需要设置的activity * @param color 状态栏颜色值 * @return 状态栏矩形条
     */
    public View createStatusView(Activity activity, int color) {
        // 获得状态栏高度
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        // 绘制一个和状态栏一样高的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }

    /**
     * 从组件中获取字符串
     *
     * @param tv
     * @return
     */
    public String getString(TextView tv) {
        return mIBaseAF.getString(tv);
    }

    /**
     * 获取SharedPreferences.Editor对象
     *
     * @param fileName
     * @return
     */
    @Override
    public SharedPreferences.Editor getEditor(String fileName) {
        return mIBaseAF.getEditor(fileName);
    }

    /**
     * 获取SharedPreferences对象
     *
     * @param fileName
     * @return
     */
    @Override
    public SharedPreferences getShared(String fileName) {
        return mIBaseAF.getShared(fileName);
    }

    /**
     * 判断手机是否拥有Root权限。
     *
     * @return 有root权限返回true，否则返回false。
     */
    public boolean isRoot() {
        return mIBaseAF.isRoot();
    }

    public void initView() {
    }

    public void initData() {
    }

    public void initOperView() {
    }
}
