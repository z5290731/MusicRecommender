package au.edu.unsw.infs3634.musicrecommender;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Spannable;
import android.text.method.ScrollingMovementMethod;
import android.text.style.BackgroundColorSpan;
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

    public ImageButton Play, Stop, Pause, Help , YouTube, Spotify;

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
        YouTube = (ImageButton) findViewById(R.id.imageButton4);
        Spotify = (ImageButton) findViewById(R.id.imageButton3);
        //rectangle_at_the_top = (View) findViewById(R.id.rectangle_at_the_top);
        Help = (ImageButton) findViewById(R.id.help);

        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        //constraintLayout.setBackgroundColor(191414);

        /**
         * Programatically setting the colour of the SeekBar
         *
         */



        SeekBar.getProgressDrawable().setColorFilter(
                Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);

        /**
         * Scroll Bar Code to help enable a Scroll Code for the Description
         *
         */


        ListDescription.setMovementMethod(new ScrollingMovementMethod());



        Intent intent = getIntent();
        Bundle values = intent.getExtras();

        String songTitleCode = values.getString("music_title");

        System.out.println(songTitleCode + "HELLO THERE");

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

                /**
                 * Share Method to pass through Data from the app onto Android's Share Functionality,
                 * allowing for a message to be copied into clipboard or sent into other applications
                 */


                String shareBody = "My "  + "#" + ListRankingS + " favourite song on Music Recommender is: " + "\n" + ListTitleS + " " + "by" + " " + ListArtistS + "! ";
                String shareSub = "Share with Music Recommender";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });


        /**
         * Button onClick Listeners used Programatically rather than through the XML onClick
         * to help determine how the buttons should react. Disabling the buttons programtically to
         * prevent users from inducing non-logical items.
         */



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
                        mp.prepareAsync();
                        mp.start();
                    }
                });
                //mediaPlayer.prepareAsync();


                if(mediaPlayer.isPlaying()) {

                    mediaPlayer.stop();

                } else {

                    /**
                     * Try Catch Logging to Catch an Errors with MediaPlayer.
                     * This is to prevent the MediaPlayer Threading issues from crashing the app,
                     * with a toast prompt ensuring users can just restart the app and are aware that something is wrong,
                     * following the 10 heuristics.
                     */

                    try {

                        //mediaPlayer.seekTo(0);
                        mediaPlayer.start();

                    } catch(Exception e) {
                        System.out.print(e);
                        Toast.makeText(getApplicationContext(), "Error! Please restart the app and try again!",Toast.LENGTH_LONG).show();
                    }



                }

                /**
                 * Utilising if Statements to help set the SeekBar and ensure that it follows the music,
                 * following the 10 heuristics
                 */


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


        /**
         * Button onClick Listeners used Programatically rather than through the XML onClick
         * to help determine how the buttons should react. Disabling the buttons programtically to
         * prevent users from inducing non-logical items.
         */

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

                try {

                    if(mediaPlayer != null) {
                        mediaPlayer.stop();
                        Pause.setEnabled(false);
                        Play.setEnabled(false);

                    }

                    //mediaPlayer.reset();

                } catch(Exception e) {

                    Toast.makeText(getApplicationContext(), "Error! Please restart the app and try again!",Toast.LENGTH_LONG).show();

                }



            }
        });

        /**
         * Button onClick Listeners used Programatically rather than through the XML onClick
         * to help determine how the buttons should react. Disabling the buttons programtically to
         * prevent users from inducing non-logical items.
         *
         * These Buttons launched new intents to the YouTube and Spotify Pages, directly integrated to launch the app versions
         */


        YouTube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/results?search_query=" + ListTitle.getText().toString()));
                startActivity(intent);
            }
        });

        Spotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/search/" + ListTitle.getText().toString() + " " + ListArtist.getText().toString()));

                startActivity(intent);
            }
        });


    }

    /**
     * Utilising Palette Methods to auto-generate a color palette according to analysis of the Cover Photo. Used to set certain texts accordingly
     */

    public Palette createPaletteSync(Bitmap bitmap) {
        Palette p = Palette.from(bitmap).generate();
        return p;
    }

    public void setBackgroundColour(Bitmap bitmap) {
        Palette p = createPaletteSync(bitmap);
        Palette.Swatch vibrantSwatch = p.getVibrantSwatch();
        //rectangle_at_the_top = (View) findViewById(R.id.rectangle_at_the_top);
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

    /**
     * Launching the Help Page
     */

    public void HelpAbout(View view) {
        Intent intent = new Intent(this, HelpAbout.class);
        startActivity(intent);
    }



    /**
     * Method to help the SeekBar continually update with the timing of the MusicPlayer
     */



    Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();

            SeekBar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };



}