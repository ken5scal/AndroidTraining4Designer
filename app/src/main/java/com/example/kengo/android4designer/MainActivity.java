package com.example.kengo.android4designer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.non_layout_view, R.id.linearlayout_ex, R.id.relative_layout_ex, R.id.frame_layout_ex, R.id.assignment})
    public void onClickExample(View v) {
        Class clazz = LinearLayoutExampleActivity.class;
        switch (v.getId()) {
            case R.id.non_layout_view:
                clazz = NonLayoutActivity.class;
                break;
            case R.id.linearlayout_ex:
                break;
            case R.id.relative_layout_ex:
                clazz = RelativeLayoutExampleActivity.class;
                break;
            case R.id.frame_layout_ex:
                clazz = FrameLayoutExampleActivity.class;
                break;
            case R.id.assignment:
                clazz = AssignmentActivity.class;
                break;
        }
        startActivity(new Intent(this, clazz));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
