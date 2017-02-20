package bjp.ftz.proxy_base.base;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bjp on 2016/9/19 10:07
 * Activity与Fragmengt的公共方法
 */
public interface IBaseAF {
    /**
     * 长土司
     *
     * @param t
     * @param <T>
     */
    <T> void MyLToast(T t);

    /**
     * 短土司
     *
     * @param t
     * @param <T>
     */
    <T> void MySToast(T t);

    /**
     * 是否有网络
     *
     * @return
     */
    boolean isRoot();

    /**
     * 从组件中获取字符串
     *
     * @param tv
     * @return
     */
    String getString(TextView tv);

    /**
     * 获取组件对象
     *
     * @param Resources
     * @param <T>
     * @return
     */
    <T> T findView(int Resources);

    /**
     * @param view    根据指定 的视图控件 从中获取到视图控件
     * @param resouer 视图控件ID
     * @return 然会该视图控件
     */
    <T> T findView(View view, int resouer);

    /**
     * @return 返回父类中的activity引用
     */
    Activity getAct();

    /**
     * 获取SharedPreferences对象
     *
     * @param fileName
     * @return
     */
    SharedPreferences getShared(String fileName);

    /**
     * 获取Editor对象
     *
     * @param fileName
     * @return
     */
    SharedPreferences.Editor getEditor(String fileName);

    /**
     * intent传输Apk下载更新路径
     */
    public static final String apkUrl = "apkUrl";

}