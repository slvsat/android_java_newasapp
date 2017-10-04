package sattar.androidnewsapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        String title = intent.getStringExtra("News_title");
        String content = intent.getStringExtra("News_content");
        String imagePath = intent.getStringExtra("News_imagePath");

        int resId = getResources().getIdentifier(imagePath, "drawable", getPackageName());

        CollapsingToolbarLayout tbar = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        tbar.setTitle(title);

        ImageView img = (ImageView) findViewById(R.id.news_image);
        img.setImageResource(resId);

        TextView newsContent = (TextView) findViewById(R.id.news_content);
        newsContent.setText(content);

    }
}
