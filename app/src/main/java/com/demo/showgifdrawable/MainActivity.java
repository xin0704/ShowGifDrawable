package com.demo.showgifdrawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.demo.showgifdrawable.util.GifAnimationDrawable;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnShowGif;
    private ImageView mImgGif;

    private GifAnimationDrawable gifAnimationDrawable;

    private void initViews() {
        mBtnShowGif = (Button) findViewById(R.id.click_to_show_gif);
        mImgGif = (ImageView) findViewById(R.id.gif_img);
        mBtnShowGif.setOnClickListener(this);

        try {
            //加载GIF资源文件
            gifAnimationDrawable = new GifAnimationDrawable(getResources().openRawResource(R.raw.pic));
            //设置GIF图片是否只播放一次  true--> 播放一次   false--> 重复播放
            gifAnimationDrawable.setOneShot(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        initViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_to_show_gif:

                Log.d("=============", "显示gif图片");

                mImgGif.setImageDrawable(gifAnimationDrawable);
                gifAnimationDrawable.setVisible(true, true);

                break;
        }
    }
}
