package bjp.ftz.proxy_base.base;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by bjp on 2016/9/12 13:45
 * Fragment的公共类
 */
public abstract class BaseFragment extends Fragment implements IBaseAF,IBaseFragment {
    private long CurrTime; // 当前时间
    private IBaseAF mIBaseAF;

    /**
     * 从组件中获取字符串
     *
     * @param tv
     * @return
     */
    @Override
    public String getString(TextView tv) {
        return mIBaseAF.getString(tv);
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

    @Override
    public Activity getAct() {
        return mIBaseAF.getAct();
    }

    public View findViewById(int id) {
        return getView().findViewById(id);
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

    /**
     * 判断手机是否拥有Root权限。
     *
     * @return 有root权限返回true，否则返回false。
     */
    @Override
    public boolean isRoot() {
        return mIBaseAF.isRoot();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return CreateView(inflater, container, savedInstanceState);
    }

    public abstract View CreateView(LayoutInflater inflater,
                                    ViewGroup container, Bundle savedInstanceState);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseFragment fragment = getThisFragment();
        mIBaseAF = new IBaseAFImpl(getActivity());
        if (fragment instanceof IBaseFragment) { // 判断子类是否已经实现了Base接口 如果实现了的话
            // 就强转 并调用方法
            IBaseFragment i = (IBaseFragment) fragment;
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
    }

    /**
     * 获取Fragment
     *
     * @return
     */
    public abstract BaseFragment getThisFragment();

    public void initView() {
    }

    public void initData() {
    }

    public void initOperView() {
    }
}
