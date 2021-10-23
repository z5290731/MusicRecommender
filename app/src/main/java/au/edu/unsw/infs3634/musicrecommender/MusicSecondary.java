package au.edu.unsw.infs3634.musicrecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicSecondary extends AppCompatActivity {

    //public static final String INTENT_MESSAGE = "HELLO";

    public TextView ListTitle, ListArtist, ListRating, ListGenre, ListDescription, ListRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_secondary);
        ListTitle = (TextView) findViewById(R.id.s_title);
        ListArtist = (TextView) findViewById(R.id.s_artist);
        ListRating = (TextView) findViewById(R.id.s_rating);
        ListGenre = (TextView) findViewById(R.id.s_genre);
        ListDescription = (TextView) findViewById(R.id.s_description);
        ListRanking = (TextView) findViewById(R.id.s_rank);


        Intent intent = getIntent();
        Bundle values = intent.getExtras();

        String songTitleCode = values.getString("music_title");

        System.out.println(songTitleCode);

        ArrayList<Music> musicTitle = Music.getMusic();

        for(Music music: musicTitle) {
            if(music.getName().equals(songTitleCode)) {
                ListTitle.setText(music.getName());
                ListArtist.setText(music.getArtist());
                ListRating.setText(Integer.toString(music.getRating()) + "/10");
                ListGenre.setText(music.getGenre());
                ListRanking.setText(Integer.toString(music.getRank()));
                ListDescription.setText(music.getDescription());

            }
        }




    }


}