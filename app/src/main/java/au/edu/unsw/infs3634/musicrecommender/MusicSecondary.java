package au.edu.unsw.infs3634.musicrecommender;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
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

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class MusicSecondary extends AppCompatActivity {

    //public static final String INTENT_MESSAGE = "HELLO";

    public TextView ListTitle, ListArtist, ListRating, ListGenre, ListDescription, ListRanking, TestView;

    public ImageButton share;

    public ImageButton Play, Stop, Pause;

    public ImageView AlbumImage;

    public SeekBar SeekBar;

    public MediaPlayer mediaPlayer;

    public View rectangle_at_the_top;

    public MediaItem mediaItem;

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
        share = (ImageButton) findViewById(R.id.share1);
        rectangle_at_the_top = (View) findViewById(R.id.rectangle_at_the_top);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        //constraintLayout.setBackgroundColor(191414);





        Intent intent = getIntent();
        Bundle values = intent.getExtras();

        String songTitleCode = values.getString("music_title");

        System.out.println(songTitleCode);

        ArrayList<Music> musicTitle = Music.getMusic();


        ArrayList<Music> musicID = Music.getMusic();

        SimpleExoPlayer player = new SimpleExoPlayer.Builder(this).build();



        for(Music music: musicTitle) {
            if(music.getName().equals(songTitleCode)) {
                ListTitle.setText(music.getName());
                ListArtist.setText(music.getArtist());
                ListRating.setText(Integer.toString(music.getRating()) + "/10");
                ListGenre.setText(music.getGenre());
                ListRanking.setText(Integer.toString(music.getRank()));
                ListDescription.setText(music.getDescription());
                TestView.setText(Integer.toString(music.getCode()));
                AlbumImage.setImageResource(music.getCode());
                System.out.println(music.getCode() + "HELLO CODE");
                mediaPlayer = MediaPlayer.create(this,music.getMusicFile());



                //LyricsClient client = new LyricsClient();


                Integer code = Integer.parseInt((String) TestView.getText());

                InputStream inputStream  = getResources().openRawResource(music.getCode());
                DataInputStream dataInputStream = new DataInputStream(inputStream);

            }
        }

        BitmapDrawable drawable = (BitmapDrawable) AlbumImage.getDrawable();
        Bitmap bitmapA = drawable.getBitmap();
        setBackgroundColour(bitmapA);
        
        

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String ListRankingS = String.valueOf(ListRanking.getText());
                String ListTitleS = String.valueOf(ListTitle.getText());
                String ListArtistS = String.valueOf(ListArtist.getText());

                String shareBody = "My "  + "#" + ListRankingS + " favourite song on Music Recommender is: " + "\n" + ListTitleS + " " + "by" + " " + ListArtistS + "! ";
                String shareSub = "Share with Music Recommender";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });





        Play.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Playing Music",Toast.LENGTH_SHORT).show();

                player.prepare();
                player.play();

                System.out.println("HELLO" + player.isPlaying());

                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();
                    }
                });
                //mediaPlayer.prepareAsync();


                if(mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();

                } else {
                    player.prepare();
                    player.play();
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
                mediaPlayer.seekTo(0);

            }
        });

    }

    public Palette createPaletteSync(Bitmap bitmap) {
        Palette p = Palette.from(bitmap).generate();
        return p;
    }

    public void setBackgroundColour(Bitmap bitmap) {
        Palette p = createPaletteSync(bitmap);
        Palette.Swatch vibrantSwatch = p.getVibrantSwatch();
        rectangle_at_the_top = (View) findViewById(R.id.rectangle_at_the_top);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        int backgroundColor = ContextCompat.getColor(MusicSecondary.this, R.color.design_default_color_on_primary);

        int textColor = ContextCompat.getColor(MusicSecondary.this, R.color.design_default_color_on_primary);

        int bodyTextColor = ContextCompat.getColor(MusicSecondary.this, R.color.design_default_color_on_primary);


        if(vibrantSwatch != null){
            backgroundColor = vibrantSwatch.getRgb();
            textColor = vibrantSwatch.getTitleTextColor();
            bodyTextColor = vibrantSwatch.getBodyTextColor();

        }
        //constraintLayout.setBackgroundColor(backgroundColor);
        //rectangle_at_the_top.setBackgroundColor(backgroundColor);

        //ListTitle.setTextColor(textColor);
        //ListArtist.setTextColor(textColor);
        //ListRating.setTextColor(textColor);
        //ListGenre.setTextColor(textColor);
        //ListRanking.setTextColor(textColor);
        //ListDescription.setTextColor(bodyTextColor);



    }





    Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();

            SeekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };



}