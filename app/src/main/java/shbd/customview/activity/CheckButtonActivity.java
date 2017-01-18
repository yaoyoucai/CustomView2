package shbd.customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import shbd.customview.view.CheckButtonView;
import shbd.customview.R;

/**
 * 项目名称：CustomView2
 * 类描述：
 * 创建人：yh
 * 创建时间：2017/1/18 9:13
 * 修改人：yh
 * 修改时间：2017/1/18 9:13
 * 修改备注：
 */
public class CheckButtonActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnCheck;
    private Button mBtnUnCheck;

    private CheckButtonView mCbtnView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_button);

        mBtnCheck = (Button) findViewById(R.id.btn_check);
        mBtnUnCheck = (Button) findViewById(R.id.btn_uncheck);
        mCbtnView = (CheckButtonView) findViewById(R.id.cbtn_view);

        mBtnCheck.setOnClickListener(this);
        mBtnUnCheck.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_check:
                mCbtnView.check();
                break;
            case R.id.btn_uncheck:
                mCbtnView.unCheck();
                break;
        }
    }
}
