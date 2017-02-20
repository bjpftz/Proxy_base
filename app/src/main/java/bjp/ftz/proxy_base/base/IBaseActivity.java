package bjp.ftz.proxy_base.base;

import android.view.View;

/**
 * Created by bjp on 2016/9/9 17:26
 * Activity抽取接口
 */
public interface IBaseActivity {
    /**
     * 初始化组件
     */
    void initView();

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 绑定数据
     */
    void initOperView();
}
