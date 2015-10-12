package com.example.kengo.android4designer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class SingleAnimationExampleActivity extends Activity {

    private Animation mTranslateAnimator;
    private Animation mScaleAnimator;
    private Animation mRotateAnimator;
    private Animation mAlphaAnimator;

    @InjectView(R.id.logo_translate)
    View mTranslateView;
    @InjectView(R.id.logo_scale)
    View mScaleView;
    @InjectView(R.id.logo_rotate)
    View mRotateView;
    @InjectView(R.id.logo_alpha)
    View mAlphaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_animation_example);
        ButterKnife.inject(this);
        mTranslateAnimator = AnimationUtils.loadAnimation(this, R.anim.simple_translate);
        mScaleAnimator = AnimationUtils.loadAnimation(this, R.anim.simple_scale);
        mRotateAnimator = AnimationUtils.loadAnimation(this, R.anim.simple_rotate);
        mAlphaAnimator = AnimationUtils.loadAnimation(this, R.anim.simple_alpha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single_animation_example, menu);
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

    @OnClick(R.id.start_animation_button)
    void onClickAnimationStartButton() {
        mTranslateView.startAnimation(mTranslateAnimator);
        mScaleView.startAnimation(mScaleAnimator);
        mRotateView.startAnimation(mRotateAnimator);
        mAlphaView.startAnimation(mAlphaAnimator);
    }
}
