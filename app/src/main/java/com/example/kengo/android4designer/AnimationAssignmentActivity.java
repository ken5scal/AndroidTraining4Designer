package com.example.kengo.android4designer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class AnimationAssignmentActivity extends Activity {

    private Animation mFocusedAnimator;
    private Animation mUnfocusedAnimator;
    private Animation mSimpleAlpha;
    private Boolean isFocusedOnce = false;

    @InjectView(R.id.logo_scale_up)
    View mScaleUpView;
    @InjectView(R.id.logo_scale_down_tint)
    View mScaleDownAndTintView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_assignment);
        ButterKnife.inject(this);

        mFocusedAnimator = AnimationUtils.loadAnimation(this, R.anim.anim_focused_category_icon);
        mUnfocusedAnimator = AnimationUtils.loadAnimation(this, R.anim.anim_unfocused_category_icon);
        mSimpleAlpha = AnimationUtils.loadAnimation(this, R.anim.simple_alpha);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animation_assignment, menu);
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

    @OnClick({R.id.logo_scale_up, R.id.logo_scale_down_tint})
    void onClickLogos(View v) {
        switch (v.getId()) {
            case R.id.logo_scale_up:
                mScaleUpView.startAnimation(mFocusedAnimator);
                if (isFocusedOnce) {
                    mScaleDownAndTintView.startAnimation(mUnfocusedAnimator);
                } else {
                    mScaleDownAndTintView.startAnimation(mSimpleAlpha);
                }

                break;
            case R.id.logo_scale_down_tint:
                if (isFocusedOnce) {
                    mScaleUpView.startAnimation(mUnfocusedAnimator);
                } else {
                    mScaleUpView.startAnimation(mSimpleAlpha);
                }
                mScaleDownAndTintView.startAnimation(mFocusedAnimator);
                break;
        }
        isFocusedOnce = true;
    }

}
