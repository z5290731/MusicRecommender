package au.edu.unsw.infs3634.musicrecommender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecyclerMusic extends RecyclerView.Adapter<RecyclerMusic.MusicViewHolder> implements Filterable {

    public static final int SORT_METHOD_RATING = 1;
    public static final int SORT_METHOD_RANK = 2;
    // INCLUDE MORE SORTING (ALPHABAETICAL)//
    // INCLUE MORE SORTING (ARTIST)//

    private ArrayList<Music> mRecyclerMusic;
    private ArrayList <Music> RecyclerMusicFiltered;

    private RecyclerViewClickListener RecyclerListener;

    public RecyclerMusic (ArrayList<Music> RMusic, RecyclerViewClickListener RListener) {
        mRecyclerMusic = RMusic;
        RecyclerListener = RListener;
        RecyclerMusicFiltered = RMusic;



    }

    public interface RecyclerViewClickListener {
        void onClick(View view, String title);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    RecyclerMusicFiltered = mRecyclerMusic;

                } else {
                    ArrayList<Music> filteredList = new ArrayList<>();
                    for (Music music : mRecyclerMusic) {
                        if(music.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(music);
                        }
                    }
                    RecyclerMusicFiltered = filteredList;
                }
                FilterResults filteredResults = new FilterResults();
                filteredResults.values = RecyclerMusicFiltered;
                return filteredResults;



            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                RecyclerMusicFiltered = (ArrayList<Music>) results.values;
                notifyDataSetChanged();

            }
        };

    }



    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MusicViewHolder(v, RecyclerListener);

    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        Music music = mRecyclerMusic.get(position);
        holder.ListTitle.setText(music.getName());

        System.out.println(holder.ListTitle);

        holder.ListRanking.setText(Integer.toString(music.getRank()));
        holder.ListArtist.setText(music.getArtist());
        holder.ListRating.setText(Integer.toString(music.getRating()));
        holder.ListGenre.setText(music.getGenre());
        holder.itemView.setTag(music.getName());
        //holder.ListDescription.setText(music.getDescription());


    }

    @Override
    public int getItemCount() {
        return RecyclerMusicFiltered.size();
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView ListTitle, ListRanking, ListArtist, ListRating, ListGenre, ListDescription;
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
            //ListDescription = itemView.findViewById();
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, (String) v.getTag());
        }

    }

    public void sort(final int sortingMethod) {
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
    }

}