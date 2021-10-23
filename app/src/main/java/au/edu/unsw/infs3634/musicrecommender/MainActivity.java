package au.edu.unsw.infs3634.musicrecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView RRecyclerView;
    private RecyclerMusic RecyclerAdapter;
    //public static final String EXTRA_MESSAGE = "US";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RRecyclerView = findViewById(R.id.Music_Recycler);
        RRecyclerView.setHasFixedSize(true);
        RecyclerMusic.RecyclerViewClickListener RListener = new RecyclerMusic.RecyclerViewClickListener() {
            @Override
            public void onClick (View v, String title) {
                launchMusicSecondary(title);

            }
        };

        RecyclerAdapter = new RecyclerMusic(Music.getMusic(), RListener);
        RRecyclerView.setAdapter(RecyclerAdapter);
        RRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                RecyclerAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                RecyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_rank:
                RecyclerAdapter.sort(RecyclerMusic.SORT_METHOD_RANK);
                return true;

            case R.id.sort_rating:
                RecyclerAdapter.sort(RecyclerMusic.SORT_METHOD_RATING);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }





    /** Called when the user taps the Send button */
    public void launchMusicSecondary(String message) {
        Intent intent = new Intent(this, MusicSecondary.class);

        intent.putExtra("music_title", message);

        startActivity(intent);
    }
}