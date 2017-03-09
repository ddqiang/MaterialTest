package com.example.yangxc.materialtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/2/25.
 */

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 沉浸式状态栏使用用法
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//            //设置透明,当然还可以根据你的需求来设置颜色。注意还需要在 xml 布局里 指定
//            // android:fitsSystemWindows="true" 属性，注意是你当前布局倒数第二级的布局里添加，不然发生错位的问题。
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//
//        }
        setContentView(R.layout.activity_fruit);
        String fruitName = getIntent().getStringExtra(FRUIT_NAME);
        int fruitImageId = getIntent().getIntExtra(FRUIT_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout layout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView fruitImage = (ImageView) findViewById(R.id.fruit_image_view);
        TextView fruitContext = (TextView) findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        layout.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(fruitImage);
        String fruitContent = generateFruitContent(fruitName);
        fruitContext.setText(fruitContent);
    }

    private String generateFruitContent(String fruitName) {

        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 500; i++) {
            fruitContent.append(fruitName);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
