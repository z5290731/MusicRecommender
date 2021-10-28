package au.edu.unsw.infs3634.musicrecommender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class HelpAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_about);

        WebView HelpWebView = (WebView) findViewById(R.id.WebView);
        HelpWebView.loadUrl("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
    }

    public void HOME(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
