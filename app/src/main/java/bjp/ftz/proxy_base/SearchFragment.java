package bjp.ftz.proxy_base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bjp.ftz.proxy_base.base.BaseFragment;

/**
 * Created by bjp on 2017/2/20 11:45
 */
public class SearchFragment extends BaseFragment {
    @Override
    public View CreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, null, false);
    }

    @Override
    public BaseFragment getThisFragment() {
        return this;
    }
}
