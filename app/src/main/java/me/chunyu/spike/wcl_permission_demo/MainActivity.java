package me.chunyu.spike.wcl_permission_demo;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.MODIFY_AUDIO_SETTINGS
    };

    @Bind(R.id.main_t_toolbar) Toolbar mTToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mTToolbar);

        PermissionsChecker checker = new PermissionsChecker(this);

        // 缺少权限提示
        if (checker.lacksPermissions(PERMISSIONS)) {
            Snackbar.make(mTToolbar, R.string.no_permissions, Snackbar.LENGTH_INDEFINITE).show();
        }
    }
}
