package bjp.ftz.proxy_base;

import android.os.Bundle;
import android.view.View;

import bjp.ftz.proxy_base.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public BaseActivity getThisActivity() {
        setContentView(R.layout.activity_main);
        return this;
    }

}
