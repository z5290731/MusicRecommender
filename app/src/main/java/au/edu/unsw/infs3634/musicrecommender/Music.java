package au.edu.unsw.infs3634.musicrecommender;

import java.util.ArrayList;

public class Music {

    public Music(Integer rank, String name, String artist, Integer rating, String genre, String description){
        this.rank = rank;
        this.name = name;
        this.artist = artist;
        this.rating = rating;
        this.genre = genre;
        this.description = description;

    }

    private Integer rank;
    private String name;
    private String artist;
    private Integer rating;
    private String genre;
    private String description;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Music> getMusic() {
        ArrayList<Music> musicArray = new ArrayList<>();

        musicArray.add(new Music(1,"STAY", "The Kid Laroi feat Justin Bieber",7,"Hip-Hop","Great Song!"));
        musicArray.add(new Music(2,"When we were two(그때의 나, 그때의 우리)", "Urban Zakapa(어반자카파)",8,"K-Ballad","Great Song!"));
        musicArray.add(new Music(3,"drivers license", "Olivia Rodrigo",10,"Pop","When I came up with 'Drivers License', I was going through a heartbreak that was so confusing to me"));
        musicArray.add(new Music(4,"Never Gonna Give You Up", "Rick Astley",7,"Electronic Dance Music","Great Song!"));
        musicArray.add(new Music(5,"i swear i'll never leave you again", "keshi",7,"Rhythm and Blues","Great Song!"));
        musicArray.add(new Music(6,"STEREOTYPE", "STAYC",7,"Korean Pop","Great Song!"));
        musicArray.add(new Music(7,"Love Story (Taylor's Version)", "Taylor Swift",7,"Country Pop","Great Song!"));
        musicArray.add(new Music(8,"Visiting Hours", "Ed Sheeran",7,"Folk Pop","Great Song!"));
        musicArray.add(new Music(9,"Leave the Door Open", "Silk Sonic",7,"Philadelphia Soul","Great Song!"));
        musicArray.add(new Music(10,"Empty Words (흔한 이별)", "Huh Gak (허각)",7,"K-Ballad","Great Song!"));

        return musicArray;

    }
}
