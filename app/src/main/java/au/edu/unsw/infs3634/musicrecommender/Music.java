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

        musicArray.add(new Music(1,"STAY", "The Kid Laroi",8,"Hip-Hop","I do the same thing I told you that I never would\n" +
                "I told you I'd change, even when I knew I never could\n" +
                "Know that I can't find nobody else as good as you\n" +
                "I need you to stay, need you to stay, hey (oh)\n" +
                "I get drunk, wake up, I'm wasted still\n" +
                "I realize the time that I wasted here\n" +
                "I feel like you can't feel the way I feel\n" +
                "Oh, I'll be fucked up if you can't be right here\n" +
                "Oh-oh-oh-whoa (oh-oh-whoa, oh-oh-whoa)\n" +
                "Oh-oh-oh-whoa (oh-oh-whoa, oh-oh-whoa)\n" +
                "Oh-oh-oh-whoa (oh-oh-whoa, oh-oh-whoa)\n" +
                "Oh, I'll be fucked up if you can't be right here\n" +
                "I do the same thing I told you that I never would\n" +
                "I told you I'd change, even when I knew I never could\n" +
                "Know that I can't find nobody else as good as you\n" +
                "I need you to stay, need you to stay, hey\n" +
                "I do the same thing I told you that I never would\n" +
                "I told you I'd change even when I knew I never could\n" +
                "Know that I can't find nobody else as good as you\n" +
                "I need you to stay, need you to stay, hey\n" +
                "When I'm away from you, I miss your touch (ooh-ooh)\n" +
                "You're the reason I believe in love\n" +
                "It's been difficult for me to trust (ooh-ooh)\n" +
                "And I'm afraid that I'ma fuck it up\n" +
                "Ain't no way that I can leave you stranded\n" +
                "'Cause you ain't ever left me empty-handed\n" +
                "And you know that I know that I can't live without you\n" +
                "So, baby, stay\n" +
                "Oh-oh-oh-whoa (oh-oh-whoa, oh-oh-whoa)\n" +
                "Oh-oh-oh-whoa (oh-oh-whoa, oh-oh-whoa)\n" +
                "Oh-oh-oh-whoa (oh-oh-whoa, oh-oh-whoa)\n" +
                "I'll be fucked up if you can't be right here\n" +
                "I do the same thing I told you that I never would\n" +
                "I told you I'd change, even when I knew I never could\n" +
                "Know that I can't find nobody else as good as you\n" +
                "I need you to stay, need you to stay, hey\n" +
                "I do the same thing I told you that I never would\n" +
                "I told you I'd change even when I knew I never could\n" +
                "Know that I can't find nobody else as good as you\n" +
                "I need you to stay, need you to stay, hey\n" +
                "Oh-oh-oh\n" +
                "I need you to stay, need you to stay, hey",R.drawable.stay_kid_laroi,R.raw.kl100));
        musicArray.add(new Music(2,"그때의 나, 그때의 우리", "Urban Zakapa(어반자카파)",4,"K-Ballad","그때의 나 그때의 우리\n" +
                "참 어리석고 어렸지\n" +
                "그때의 우리 아무것도 아닌 일에\n" +
                "다투던 초라할 무렵에 기억\n" +
                "달 밝은 날에 하늘을 보면\n" +
                "우리 상처들이 떠 있고\n" +
                "밤 또 늦은 밤에 거릴 거닐면\n" +
                "그때의 추억이 선명하게 따라와\n" +
                "네가 그립거나 보고프거나\n" +
                "그런 쉬운 감정이 아니야\n" +
                "난 그때의 우리가 세상에\n" +
                "우리밖에 없었던 그때가 그리울 뿐\n" +
                "그때의 우리 소홀함과 편안함\n" +
                "그 안에서 부숴질 듯 아파했던\n" +
                "달 밝은 날에 하늘을 보면\n" +
                "우리 상처들이 떠 있고\n" +
                "밤 또 늦은 밤에 거릴 거닐면\n" +
                "그때의 추억이 선명하게 따라와\n" +
                "네가 그립거나 보고프거나\n" +
                "그런 쉬운 감정이 아니야\n" +
                "난 그때의 우리가 세상에\n" +
                "우리밖에 없었던 그때가 그리워\n" +
                "다시 그 시간으로 돌아가고픈\n" +
                "가벼운 순간의 감정이 아냐\n" +
                "난 그때의 우리가 너와 내가\n" +
                "이 세상 전부였던 그때가 그리울 뿐\n" +
                "그때의 나 그때의 우리",R.drawable.when_we_were_two,R.raw.uz200));
        musicArray.add(new Music(3,"drivers license", "Olivia Rodrigo",10,"Pop","I got my driver's license last week\n" +
                "Just like we always talked about\n" +
                "'Cause you were so excited for me\n" +
                "To finally drive up to your house\n" +
                "But today I drove through the suburbs\n" +
                "Crying 'cause you weren't around\n" +
                "And you're probably with that blonde girl\n" +
                "Who always made me doubt\n" +
                "She's so much older than me\n" +
                "She's everything I'm insecure about\n" +
                "Yeah, today I drove through the suburbs\n" +
                "'Cause how could I ever love someone else?\n" +
                "And I know we weren't perfect but I've never felt this way for no one\n" +
                "And I just can't imagine how you could be so okay now that I'm gone\n" +
                "Guess you didn't mean what you wrote in that song about me\n" +
                "'Cause you said forever, now I drive alone past your street\n" +
                "And all my friends are tired\n" +
                "Of hearing how much I miss you, but\n" +
                "I kinda feel sorry for them\n" +
                "'Cause they'll never know you the way that I do, yeah\n" +
                "Today I drove through the suburbs\n" +
                "And pictured I was driving home to you\n" +
                "And I know we weren't perfect\n" +
                "But I've never felt this way for no one, oh\n" +
                "And I just can't imagine how you could be so okay, now that I'm gone\n" +
                "I guess you didn't mean what you wrote in that song about me\n" +
                "'Cause you said forever, now I drive alone past your street\n" +
                "Red lights, stop signs\n" +
                "I still see your face in the white cars, front yards\n" +
                "Can't drive past the places we used to go to\n" +
                "'Cause I still fuckin' love you, babe (ooh, ooh, ooh, ooh)\n" +
                "Sidewalks we crossed\n" +
                "I still hear your voice in the traffic, we're laughing\n" +
                "Over all the noise\n" +
                "God, I'm so blue, know we're through\n" +
                "But I still fuckin' love you, babe (ooh, ooh, ooh, ooh)\n" +
                "I know we weren't perfect but I've never felt this way for no one\n" +
                "And I just can't imagine how you could be so okay, now that I'm gone\n" +
                "'Cause you didn't mean what you wrote in that song about me\n" +
                "'Cause you said forever, now I drive alone past your street\n" +
                "Yeah, you said forever, now I drive alone past your street"
                ,R.drawable.drivers_license,R.raw.dl300));
        musicArray.add(new Music(4,"Never Gonna Give You Up", "Rick Astley",7,"EDM","We're no strangers to love\n" +
                "You know the rules and so do I\n" +
                "A full commitment's what I'm thinking of\n" +
                "You wouldn't get this from any other guy\n" +
                "I just wanna tell you how I'm feeling\n" +
                "Gotta make you understand\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "We've known each other for so long\n" +
                "Your heart's been aching but you're too shy to say it\n" +
                "Inside we both know what's been going on\n" +
                "We know the game and we're gonna play it\n" +
                "And if you ask me how I'm feeling\n" +
                "Don't tell me you're too blind to see\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna give, never gonna give\n" +
                "(Give you up)\n" +
                "We've known each other for so long\n" +
                "Your heart's been aching but you're too shy to say it\n" +
                "Inside we both know what's been going on\n" +
                "We know the game and we're gonna play it\n" +
                "I just wanna tell you how I'm feeling\n" +
                "Gotta make you understand\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye\n" +
                "Never gonna tell a lie and hurt you\n" +
                "Never gonna give you up\n" +
                "Never gonna let you down\n" +
                "Never gonna run around and desert you\n" +
                "Never gonna make you cry\n" +
                "Never gonna say goodbye",R.drawable.never_gonna_give_you_up,R.raw.ra400));
        musicArray.add(new Music(5,"i swear i'll never leave you again", "keshi",9,"R&B","Check out @jiraiya121's cover on TikTok!!\n" +
                "Mirror on the wall\n" +
                "Can you tell me who I am?\n" +
                "I think that I forgot\n" +
                "So remind me once again\n" +
                "Maybe I was going too fast\n" +
                "Babe, I'd give it all to go back (Yeah-hea-eah)\n" +
                "Baby I'm better, I promise\n" +
                "Know that I've never been honest\n" +
                "Maybe I never forgot it (Forgot it)\n" +
                "Daily reminder\n" +
                "Tattoos of tigers\n" +
                "Cigarette lighters\n" +
                "Laughter and cider\n" +
                "Ohh (Ohh)\n" +
                "Ohh (Yeah)\n" +
                "(Hea-hea-hea)\n" +
                "I don't deserve this\n" +
                "All in your arms\n" +
                "All your forgiveness\n" +
                "I don't belong\n" +
                "I swear\n" +
                "I swear I'll never leave again\n" +
                "So this is love\n" +
                "Just hold me close\n" +
                "I'll never leave\n" +
                "I won't let go\n" +
                "Oh, I swear I'll never leave again", R.drawable.i_swear_ill_never_leave_you,R.raw.keshi500));
        musicArray.add(new Music(6,"STEREOTYPE", "STAYC",3,"Korean Pop","There's something to tell you\n" +
                "You want me to share it with you?\n" +
                "STAYC girls, it's going down\n" +
                "오늘 유난히 티가 더 나는 걸\n" +
                "모두 쳐다보는 게 다 보여\n" +
                "왠지 그럴수록 더 난 당당해져\n" +
                "기분 좋아지는 걸\n" +
                "머릴 넘기며 어디든 지나가네\n" +
                "내 달콤한 향수가 흩날리게 yeah\n" +
                "항상 날 꾸미는 게 좋아\n" +
                "예쁜 게 좋아 근데 들어봐 yeah\n" +
                "나도 알아 내 모습이\n" +
                "이뻐 보일지도 당돌한 걸지도\n" +
                "자꾸만 널 유혹하듯\n" +
                "보이겠지만 미안하지만\n" +
                "색안경을 끼고 보지 마요\n" +
                "난 좀 다른 여자인데\n" +
                "겉은 화려해도 아직 두려운 걸 you should know\n" +
                "I'm a good girl yeah\n" +
                "너무 세게 안으면 숨 막혀요\n" +
                "조금 서투를지도 난 아직도\n" +
                "색안경을 끼고 보지 마요\n" +
                "Oh, baby, baby, baby\n" +
                "패션은 과감한 게 좋아 like it uh huh\n" +
                "튀는 게 좋아 어떻게든 소화 yeah\n" +
                "가끔 나조차 진짜 내 맘을 몰라\n" +
                "그런 나지만\n" +
                "나도 알아 내 모습이\n" +
                "이뻐 보일지도 당돌한 걸지도\n" +
                "자꾸만 널 유혹하듯\n" +
                "보이겠지만 미안하지만\n" +
                "색안경을 끼고 보지 마요\n" +
                "난 좀 다른 여자인데\n" +
                "겉은 화려해도 아직 두려운 걸 you should know\n" +
                "I'm a good girl yeah\n" +
                "너무 세게 안으면 숨 막혀요\n" +
                "조금 서투를지도 난 아직도\n" +
                "색안경을 끼고 보지 마요\n" +
                "Oh, baby, baby, baby\n" +
                "Alright (alright), alright (alright) 드러나는 모습뿐인걸\n" +
                "Oh why (oh why), oh why (oh why) 눈으로만 날 판단하지 않길\n" +
                "Oh 꾸미지 않은 내 모습\n" +
                "Oh 있는 그대로의 모습\n" +
                "좋아해 줘 아직 여린 내 맘\n" +
                "꼭 알아줬으면 해 yeah\n" +
                "색안경을 끼고 보지 마요\n" +
                "난 좀 다른 여자인데\n" +
                "겉은 화려해도 아직 두려운 걸 you should know\n" +
                "I'm a good girl yeah (oh yeah yeah)\n" +
                "너무 세게 안으면 숨 막혀요\n" +
                "조금 서투를지도 난 아직도\n" +
                "색안경을 끼고 보지 마요\n" +
                "Oh, baby, baby, baby (ah)",R.drawable.stereotype_stayc,R.raw.stayc600));
        musicArray.add(new Music(7,"Love Story (Taylor's Version)", "Taylor Swift",10,"Country Pop","We were both young when I first saw you\n" +
                "I close my eyes and the flashback starts\n" +
                "I'm standin' there\n" +
                "On a balcony in summer air\n" +
                "See the lights, see the party, the ball gowns\n" +
                "See you make your way through the crowd\n" +
                "And say, \"Hello\"\n" +
                "Little did I know\n" +
                "That you were Romeo, you were throwin' pebbles\n" +
                "And my daddy said, \"Stay away from Juliet\"\n" +
                "And I was cryin' on the staircase\n" +
                "Beggin' you, \"Please don't go, \" and I said\n" +
                "Romeo, take me somewhere we can be alone\n" +
                "I'll be waiting, all there's left to do is run\n" +
                "You'll be the prince and I'll be the princess\n" +
                "It's a love story, baby, just say, \"Yes\"\n" +
                "So I sneak out to the garden to see you\n" +
                "We keep quiet, 'cause we're dead if they knew\n" +
                "So close your eyes\n" +
                "Escape this town for a little while, oh oh\n" +
                "'Cause you were Romeo, I was a scarlet letter\n" +
                "And my daddy said, \"Stay away from Juliet\"\n" +
                "But you were everything to me\n" +
                "I was beggin' you, \"Please don't go, \" and I said\n" +
                "Romeo, take me somewhere we can be alone\n" +
                "I'll be waiting, all there's left to do is run\n" +
                "You'll be the prince and I'll be the princess\n" +
                "It's a love story, baby, just say, \"Yes\"\n" +
                "Romeo, save me, they're tryna tell me how to feel\n" +
                "This love is difficult, but it's real\n" +
                "Don't be afraid, we'll make it out of this mess\n" +
                "It's a love story, baby, just say, \"Yes\"\n" +
                "Oh, oh\n" +
                "I got tired of waiting\n" +
                "Wonderin' if you were ever comin' around\n" +
                "My faith in you was fading\n" +
                "When I met you on the outskirts of town, and I said\n" +
                "Romeo, save me, I've been feeling so alone\n" +
                "I keep waiting for you, but you never come\n" +
                "Is this in my head? I don't know what to think\n" +
                "He knelt to the ground and pulled out a ring\n" +
                "And said, \"Marry me, Juliet\n" +
                "You'll never have to be alone\n" +
                "I love you and that's all I really know\n" +
                "I talked to your dad, go pick out a white dress\n" +
                "It's a love story, baby, just say, \"Yes\"\n" +
                "Oh, oh, oh\n" +
                "Oh, oh, oh, oh\n" +
                "'Cause we were both young when I first saw you",R.drawable.love_story,R.raw.ts700));
        musicArray.add(new Music(8,"Visiting Hours", "Ed Sheeran",6,"Folk Pop","I wish that Heaven had visiting hours\n" +
                "So I could just show up and bring the news\n" +
                "That she's gettin' older and I wish that you'd met her\n" +
                "The things that she'll learn from me\n" +
                "I got them all from you\n" +
                "Can I just stay a while and we'll put all the world to rights?\n" +
                "The little ones will grow, and I'll still drink your favorite wine\n" +
                "And soon they're goin' to close, but I'll see you another day\n" +
                "So much has changed since you've been away\n" +
                "I wish that Heaven had visiting hours\n" +
                "So I could just swing by and ask your advice\n" +
                "What would you do in my situation?\n" +
                "I haven't a clue how I'd even raise them\n" +
                "What would you do?\n" +
                "'Cause you always do what's right\n" +
                "Can we just talk a while until my worries disappear?\n" +
                "I'd tell you that I'm scared of turning out a failure\n" +
                "You'd say, \"Remember that the answer's in the love that we create\"\n" +
                "So much has changed since you've been away\n" +
                "I wish that Heaven had visiting hours\n" +
                "And I would ask them if I could take you home\n" +
                "But I know what they'd say, that it's for the best\n" +
                "So I will live life the way you taught me\n" +
                "And make it on my own\n" +
                "I will close the door, but I will open up my heart\n" +
                "And everyone I love will know exactly who you are\n" +
                "'Cause this is not goodbye, it is just 'til we meet again\n" +
                "So much has changed since you've been away",R.drawable.visiting_hours,R.raw.es800));
        musicArray.add(new Music(9,"Leave the Door Open", "Silk Sonic",4,"Soul","Said baby, said baby, said baby\n" +
                "What you doing? (What you doing?)\n" +
                "Where you at? (Where you at?)\n" +
                "Oh, you got plans? (You got plans?)\n" +
                "Don't say that (shut your trap)\n" +
                "I'm sipping wine (sip, sip) in a robe (drip, drip)\n" +
                "I look too good (look too good) to be alone (woo-woo)\n" +
                "My house clean (house clean), my pool warm (pool warm)\n" +
                "Just shaved (smooth like a newborn)\n" +
                "We should be dancing, romancing\n" +
                "In the east wing and the west wing\n" +
                "Of this mansion, what's happening?\n" +
                "I ain't playing no games\n" +
                "Every word that I say is coming straight from the heart\n" +
                "So if you tryna lay in these arms\n" +
                "I'ma leave the door open\n" +
                "(I'ma leave the door open)\n" +
                "I'ma leave the door open, girl\n" +
                "(I'ma leave the door open hoping)\n" +
                "That you feel the way I feel\n" +
                "And you want me like I want you tonight, baby\n" +
                "(Tell me that you're coming through)\n" +
                "Ooh, you're so sweet (so sweet), so tight (so tight)\n" +
                "I won't bite (ah-ah), unless you like (unless you like)\n" +
                "If you smoke (what you smoke?) I got the haze (Purple Haze)\n" +
                "And if you're hungry, girl, I got filets (woo-woo)\n" +
                "Ooh, baby, don't keep me (waiting)\n" +
                "There's so much love we could be making (shamone)\n" +
                "I'm talking kissing, cuddling\n" +
                "Rose petals in the bathtub\n" +
                "Girl, let's jump in, it's bubbling\n" +
                "I ain't playing no games\n" +
                "Every word that I say is coming straight from the heart\n" +
                "So (if you) if you (tryna) tryna lay in these arms\n" +
                "I'ma leave the door open\n" +
                "(I'ma leave the door open)\n" +
                "I'ma leave the door open, girl\n" +
                "(I'ma leave the door open hoping)\n" +
                "That you feel the way I feel\n" +
                "And you want me like I want you tonight, baby\n" +
                "(Tell me that you're coming through) come on, girl\n" +
                "La-la-la, la-la-la-la (I need you, baby)\n" +
                "La-la-la, la-la-la-la (I gotta see you, baby)\n" +
                "La-la-la, la-la-la-la (girl, I'm tryna give you this)\n" +
                "Ah-ah-ah-ah, ah-ah\n" +
                "Hey-hey, I'ma leave my door open, baby (I'ma leave the door open)\n" +
                "I'ma leave, I'ma leave my door open, girl\n" +
                "(I'ma leave the door open, hoping) and I'm hoping, hoping\n" +
                "That you feel the way I feel\n" +
                "And you want me like I want you tonight, baby\n" +
                "(Tell me that you're coming through) woo!\n" +
                "La-la-la, la-la-la-la (tell me)\n" +
                "(Tell me that you're coming through)\n" +
                "Woo-woo-woo-woo, woo-woo-woo, woo-woo-woo\n" +
                "Woo-woo-woo-woo, woo-woo-woo, woo-woo\n" +
                "La-la-la, la-la-la-la (la-la-la, la-la)\n" +
                "(Tell me that you're coming through)\n" +
                "Girl, I'm here just waiting for you (oh!)\n" +
                "Come on over, I'll adore you (I gotta know!)\n" +
                "La-la-la, la-la-la-la (I'm waiting, waiting, waiting)\n" +
                "(Tell me that you're coming through) for you\n" +
                "Girl, I'm here just waiting for you\n" +
                "Come on over, I'll adore you\n" +
                "La-la-la, la-la-la-la (la-la, la-la)",R.drawable.leave_the_door_open,R.raw.ltdr900));
        musicArray.add(new Music(10,"Empty Words (흔한 이별)", "Huh Gak (허각)",10,"K-Ballad","매일 집으로 돌아가는\n" +
                "익숙한 골목 거리 사이\n" +
                "불어온 볼 스치는 차가워진\n" +
                "이 바람을 따라\n" +
                "걷다가 네 생각이 나 잘 지내니\n" +
                "많이 바쁘게 지냈나 봐\n" +
                "너 없는 하루가 왜 그리\n" +
                "느리게만 가는지 했던 게\n" +
                "어제 일만 같은데\n" +
                "어느새 까맣게 잊고 살았나 봐\n" +
                "\n" +
                "이 계절이 널 기억하고 있나 봐\n" +
                "우리가 헤어진 게 이맘때였어\n" +
                "그때는 왜 그렇게\n" +
                "세상을 다 잃은 것만 같던지\n" +
                "지나 지나고 보니\n" +
                "\n" +
                "흔한 이별인 듯 살아져\n" +
                "너도 나처럼 어느새 잊었을까\n" +
                "참 사랑했었던 애틋했던\n" +
                "우리 사이 이젠\n" +
                "남들과 같나 봐\n" +
                "지나보니 알 것 같아\n" +
                "다 내 잘못이었다는 걸\n" +
                "들릴 듯 말 듯하게\n" +
                "나 혼잣말로 미안했다며\n" +
                "별일은 없는지 너를 불러봐\n" +
                "\n" +
                "이 계절이 널 기억하고 있나 봐\n" +
                "우리가 헤어진 게 이맘때였어\n" +
                "그때는 왜 그렇게\n" +
                "세상을 다 잃은 것만 같던지\n" +
                "지나 지나고 보니\n" +
                "\n" +
                "흔한 이별인 듯 살아져\n" +
                "너도 나처럼 어느새 잊었을까\n" +
                "참 사랑했었던 애틋했던\n" +
                "우리 사이 이젠\n" +
                "남들과 같나 봐\n" +
                "\n" +
                "생각보다 많이 무뎌진 것만 같아서\n" +
                "조심스레 괜찮다 말해\n" +
                "볼 스치는 바람 따라\n" +
                "살며시 너를 싣고서\n" +
                "이젠 보내줄래",R.drawable.empty_words,R.raw.ew1000));

        return musicArray;

    }
}
