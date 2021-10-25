package au.edu.unsw.infs3634.musicrecommender;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MusicSecondary extends AppCompatActivity {

    //public static final String INTENT_MESSAGE = "HELLO";

    public TextView ListTitle, ListArtist, ListRating, ListGenre, ListDescription, ListRanking, TestView;

    public ImageButton Play, Stop, Pause;

    public ImageView AlbumImage;

    public SeekBar SeekBar;

    public MediaPlayer mediaPlayer;

    public double finalTime = 0;

    public double startTime = 0;

    public static int oneTimeOnly = 0;

    public Handler myHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_secondary);
        TestView = (TextView) findViewById(R.id.textView2);
        ListTitle = (TextView) findViewById(R.id.s_title);
        ListArtist = (TextView) findViewById(R.id.s_artist);
        ListRating = (TextView) findViewById(R.id.s_rating);
        ListGenre = (TextView) findViewById(R.id.s_genre);
        ListDescription = (TextView) findViewById(R.id.s_description);
        ListRanking = (TextView) findViewById(R.id.s_rank);
        AlbumImage = (ImageView) findViewById(R.id.imageView);
        Play = (ImageButton) findViewById(R.id.Play);
        Pause = (ImageButton) findViewById(R.id.Pause);
        Stop = (ImageButton) findViewById(R.id.Stop);
        SeekBar = (SeekBar) findViewById(R.id.seekBar);








        Intent intent = getIntent();
        Bundle values = intent.getExtras();

        String songTitleCode = values.getString("music_title");

        System.out.println(songTitleCode);

        ArrayList<Music> musicTitle = Music.getMusic();


        ArrayList<Music> musicID = Music.getMusic();











        for(Music music: musicTitle) {
            if(music.getName().equals(songTitleCode)) {
                ListTitle.setText(music.getName());
                ListArtist.setText(music.getArtist());
                ListRating.setText(Integer.toString(music.getRating()) + "/10");
                ListGenre.setText(music.getGenre());
                ListRanking.setText(Integer.toString(music.getRank()));
                ListDescription.setText(music.getDescription());
                TestView.setText(Integer.toString(music.getCode()));
                System.out.println(music.getCode() + "HELLO CODE");

                Integer rank = Integer.parseInt((String) TestView.getText());


                for(Music musicR: musicID)
                    switch(rank) {
                        case 100:
                            AlbumImage.setImageResource(R.drawable.stay_kid_laroi);
                            mediaPlayer = MediaPlayer.create(this,R.raw.kl100);
                            System.out.println("100");
                            break;

                        case 200:
                            AlbumImage.setImageResource(R.drawable.when_we_were_two);
                            mediaPlayer = MediaPlayer.create(this,R.raw.uz200);
                            System.out.println("200");
                            break;

                        case 300:
                            AlbumImage.setImageResource(R.drawable.drivers_license);
                            mediaPlayer = MediaPlayer.create(this,R.raw.dl300);
                            System.out.println("300");
                            break;

                        case 400:
                            AlbumImage.setImageResource(R.drawable.never_gonna_give_you_up);
                            mediaPlayer = MediaPlayer.create(this,R.raw.ra400);
                            System.out.println("400");
                            break;

                        case 500:
                            AlbumImage.setImageResource(R.drawable.i_swear_ill_never_leave_you);
                            mediaPlayer = MediaPlayer.create(this,R.raw.keshi500);
                            System.out.println("500");
                            break;

                        case 600:
                            AlbumImage.setImageResource(R.drawable.stereotype_stayc);
                            mediaPlayer = MediaPlayer.create(this,R.raw.stayc600);
                            System.out.println("600");
                            break;

                        case 700:
                            AlbumImage.setImageResource(R.drawable.love_story);
                            mediaPlayer = MediaPlayer.create(this,R.raw.ts700);
                            System.out.println("700");
                            break;

                        case 800:
                            AlbumImage.setImageResource(R.drawable.visiting_hours);
                            mediaPlayer = MediaPlayer.create(this,R.raw.es800);
                            System.out.println("800");
                            break;

                        case 900:
                            AlbumImage.setImageResource(R.drawable.leave_the_door_open);
                            mediaPlayer = MediaPlayer.create(this,R.raw.ltdr900);
                            System.out.println("900");
                            break;

                        case 1000:
                            AlbumImage.setImageResource(R.drawable.empty_words);
                            mediaPlayer = MediaPlayer.create(this,R.raw.ew1000);
                            System.out.println("1000");
                            break;

                        default:
                            System.out.println("Fix your Switch");
                            break;

                    }


            }
        }

        Play.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Playing Music",Toast.LENGTH_SHORT).show();

                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();

                } else {
                    mediaPlayer.start();

                }


                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    SeekBar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                } else {
                    SeekBar.setMin((int) startTime);
                    oneTimeOnly = 0;
                }

                SeekBar.setProgress((int)startTime);
                myHandler.postDelayed(UpdateSongTime,100);
            }
        });

        Pause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Music Paused",Toast.LENGTH_SHORT).show();

                mediaPlayer.pause();
            }
        });

        Stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Music Stopped",Toast.LENGTH_SHORT).show();

                mediaPlayer.stop();
            }
        });

    }

    Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();

            SeekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };



}