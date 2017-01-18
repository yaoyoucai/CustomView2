package shbd.customview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import shbd.customview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnDrawBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnDrawBitmap = (Button) findViewById(R.id.btn_check_button);

        mBtnDrawBitmap.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_check_button:

                break;
        }
    }
}
