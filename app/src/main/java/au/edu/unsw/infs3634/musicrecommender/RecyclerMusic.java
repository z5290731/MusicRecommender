package au.edu.unsw.infs3634.musicrecommender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecyclerMusic extends RecyclerView.Adapter<RecyclerMusic.MusicViewHolder> implements Filterable {


    public static final int SORT_METHOD_RATING = 1;
    public static final int SORT_METHOD_RANK = 2;


    private ArrayList<Music> mRecyclerMusic;
    private ArrayList<Music> RecyclerMusicFiltered;

    private RecyclerViewClickListener RecyclerListener;

    public RecyclerMusic (ArrayList<Music> RMusic, RecyclerViewClickListener RListener) {
        mRecyclerMusic = RMusic;
        RecyclerListener = RListener;
        RecyclerMusicFiltered = RMusic;



    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                System.out.println(charString);
                if(charString.isEmpty()) {
                    RecyclerMusicFiltered = mRecyclerMusic;

                } else {
                    ArrayList<Music> filteredList = new ArrayList<>();
                    for (Music musicD : mRecyclerMusic ) {
                        if (musicD.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(musicD);
                        }
                    }
                    RecyclerMusicFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = RecyclerMusicFiltered;
                return filterResults;



            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                System.out.println(results + "HELLO");
                RecyclerMusicFiltered = (ArrayList<Music>) results.values;
                notifyDataSetChanged();

            }
        };

    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String title);
    }




    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MusicViewHolder(v, RecyclerListener);

    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music music = RecyclerMusicFiltered.get(position);
        holder.ListTitle.setText(music.getName());
        System.out.println(position + "TESTING 12322");
        System.out.println(holder.ListTitle + "TESTING 123");

        holder.ListRanking.setText(Integer.toString(music.getRank()));
        holder.ListArtist.setText(music.getArtist());
        holder.ListRating.setText(Integer.toString(music.getRating()) + "/10");
        holder.ListGenre.setText(music.getGenre());
        holder.itemView.setTag(music.getName());
        holder.ImageAlbum.setImageResource(music.getCode());

        //holder.ListDescription.setText(music.getDescription());


    }

    @Override
    public int getItemCount() {
        return RecyclerMusicFiltered.size();
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView ListTitle, ListRanking, ListArtist, ListRating, ListGenre, ListDescription;
        public ImageView ImageAlbum;
        public RecyclerViewClickListener listener;



        public MusicViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
            ListTitle = itemView.findViewById(R.id.textView);
            ListRanking = itemView.findViewById(R.id.r_rank);
            ListArtist = itemView.findViewById(R.id.textView3);
            ListRating = itemView.findViewById(R.id.textView4);
            ListGenre = itemView.findViewById(R.id.r_genre);
            ImageAlbum = itemView.findViewById(R.id.imageView2);




            //ListDescription = itemView.findViewById();
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }

    }


    /**
     * Try and Catch used to help the user highlight any issues with the sorting methodology
     */


    public void sort(final int sortingMethod) {

        try {
            if (RecyclerMusicFiltered.size() > 0) {
                Collections.sort(RecyclerMusicFiltered, (o1, o2) -> {
                    if(sortingMethod == SORT_METHOD_RATING) {
                        return o2.getRating().compareTo(o1.getRating());
                    } else if (sortingMethod == SORT_METHOD_RANK) {
                        return o2.getRank().compareTo(o1.getRank());
                    }
                    return o2.getRank().compareTo(o1.getRank());
                });
            }
            notifyDataSetChanged();

        } catch (Exception e) {

            System.out.println(e + "Please restart the app immediately!");
        }

    }

}
