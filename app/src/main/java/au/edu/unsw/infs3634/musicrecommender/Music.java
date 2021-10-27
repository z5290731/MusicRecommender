package au.edu.unsw.infs3634.musicrecommender;

import java.util.ArrayList;

public class Music {

    public Music(Integer rank, String name, String artist, Integer rating, String genre, String description,Integer code,Integer musicFile){
        this.rank = rank;
        this.name = name;
        this.artist = artist;
        this.rating = rating;
        this.genre = genre;
        this.description = description;
        this.code = code;
        this.musicFile = musicFile;

    }

    private Integer rank;
    private String name;
    private String artist;
    private Integer rating;
    private String genre;
    private String description;
    private Integer code;
    private Integer musicFile;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

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

    public void setMusicFile(Integer musicFile) {
        this.musicFile = musicFile;
    }

    public Integer getMusicFile() {
        return musicFile;
    }

    public static ArrayList<Music> getMusic() {
        ArrayList<Music> musicArray = new ArrayList<>();

        musicArray.add(new Music(1,"STAY", "The Kid Laroi",7,"Hip-Hop","Great Song!",R.drawable.stay_kid_laroi,R.raw.kl100));
        musicArray.add(new Music(2,"그때의 나, 그때의 우리", "Urban Zakapa(어반자카파)",8,"K-Ballad","Great Song!",R.drawable.when_we_were_two,R.raw.uz200));
        musicArray.add(new Music(3,"drivers license", "Olivia Rodrigo",10,"Pop","When I came up with 'Drivers License', I was going through a heartbreak that was so confusing to me",R.drawable.drivers_license,R.raw.dl300));
        musicArray.add(new Music(4,"Never Gonna Give You Up", "Rick Astley",7,"EDM","Great Song!",R.drawable.never_gonna_give_you_up,R.raw.ra400));
        musicArray.add(new Music(5,"i swear i'll never leave you again", "keshi",7,"R&B","Check out @jiraiya121's cover on TikTok!!", R.drawable.i_swear_ill_never_leave_you,R.raw.keshi500));
        musicArray.add(new Music(6,"STEREOTYPE", "STAYC",7,"Korean Pop","Great Song!",R.drawable.stereotype_stayc,R.raw.stayc600));
        musicArray.add(new Music(7,"Love Story (Taylor's Version)", "Taylor Swift",7,"Country Pop","Great Song!",R.drawable.love_story,R.raw.ts700));
        musicArray.add(new Music(8,"Visiting Hours", "Ed Sheeran",7,"Folk Pop","Great Song!",R.drawable.visiting_hours,R.raw.es800));
        musicArray.add(new Music(9,"Leave the Door Open", "Silk Sonic",7,"Soul","Great Song!",R.drawable.leave_the_door_open,R.raw.ltdr900));
        musicArray.add(new Music(10,"Empty Words (흔한 이별)", "Huh Gak (허각)",7,"K-Ballad","Great Song!",R.drawable.empty_words,R.raw.ew1000));

        return musicArray;

    }
}
