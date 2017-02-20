package bjp.ftz.proxy_base.base;

/**
 * Created by bjp on 2016/9/12 14:22
 * Fragment抽取的接口
 */
public interface IBaseFragment {
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
