import java.util.Random;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + " - " + artist;
    }
}

class Playlist {
    private Song[] songs;
    private int count;
    private int currentSong;

    public Playlist(int size) {
        songs = new Song[size];
        count = 0;
        currentSong = 0;
    }

    public void addSong(Song song) {
        if (count < songs.length) {
            songs[count++] = song;
        }
    }

    public void displayPlaylist() {
        System.out.println("\n===== PLAYLIST =====");

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + songs[i]);
        }

        System.out.println("\nTotal Songs: " + count);
    }

    public void shufflePlaylist() {
        Random random = new Random();

        for (int i = count - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Song temp = songs[i];
            songs[i] = songs[j];
            songs[j] = temp;
        }

        System.out.println("\nPlaylist Shuffled!");
    }

    public void searchSong(String title) {

        for (int i = 0; i < count; i++) {

            if (songs[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("\nFound:");
                System.out.println(songs[i]);
                return;
            }
        }

        System.out.println("\nSong Not Found!");
    }

    public void removeSong(String title) {

        for (int i = 0; i < count; i++) {

            if (songs[i].getTitle().equalsIgnoreCase(title)) {

                for (int j = i; j < count - 1; j++) {
                    songs[j] = songs[j + 1];
                }

                songs[count - 1] = null;
                count--;

                System.out.println("\nSong Removed!");
                return;
            }
        }

        System.out.println("\nSong Not Found!");
    }

    public void playNext() {

        if (count == 0) {
            System.out.println("Playlist Empty!");
            return;
        }

        System.out.println("\nNow Playing:");
        System.out.println(songs[currentSong]);

        currentSong++;

        if (currentSong >= count) {
            currentSong = 0;
        }
    }
}

public class MusicPlaylistManagementSystem {

    public static void main(String[] args) {

        Playlist playlist = new Playlist(250);

        // SONGS GO HERE

                // Taylor Swift
        playlist.addSong(new Song("Love Story", "Taylor Swift"));
        playlist.addSong(new Song("Blank Space", "Taylor Swift"));
        playlist.addSong(new Song("Style", "Taylor Swift"));
        playlist.addSong(new Song("Cruel Summer", "Taylor Swift"));
        playlist.addSong(new Song("Anti Hero", "Taylor Swift"));
        playlist.addSong(new Song("Cardigan", "Taylor Swift"));
        playlist.addSong(new Song("Willow", "Taylor Swift"));
        playlist.addSong(new Song("Enchanted", "Taylor Swift"));
        playlist.addSong(new Song("Fearless", "Taylor Swift"));
        playlist.addSong(new Song("Delicate", "Taylor Swift"));

        // Kanye West
        playlist.addSong(new Song("Stronger", "Kanye West"));
        playlist.addSong(new Song("Power", "Kanye West"));
        playlist.addSong(new Song("Heartless", "Kanye West"));
        playlist.addSong(new Song("Runaway", "Kanye West"));
        playlist.addSong(new Song("Gold Digger", "Kanye West"));
        playlist.addSong(new Song("Flashing Lights", "Kanye West"));
        playlist.addSong(new Song("Champion", "Kanye West"));
        playlist.addSong(new Song("Good Life", "Kanye West"));
        playlist.addSong(new Song("Homecoming", "Kanye West"));
        playlist.addSong(new Song("Good Morning", "Kanye West"));

        // Kendrick Lamar
        playlist.addSong(new Song("HUMBLE.", "Kendrick Lamar"));
        playlist.addSong(new Song("DNA.", "Kendrick Lamar"));
        playlist.addSong(new Song("Money Trees", "Kendrick Lamar"));
        playlist.addSong(new Song("Alright", "Kendrick Lamar"));
        playlist.addSong(new Song("LOVE.", "Kendrick Lamar"));
        playlist.addSong(new Song("King Kunta", "Kendrick Lamar"));
        playlist.addSong(new Song("Swimming Pools", "Kendrick Lamar"));
        playlist.addSong(new Song("N95", "Kendrick Lamar"));
        playlist.addSong(new Song("PRIDE.", "Kendrick Lamar"));
        playlist.addSong(new Song("LOYALTY.", "Kendrick Lamar"));

        // Drake
        playlist.addSong(new Song("God's Plan", "Drake"));
        playlist.addSong(new Song("One Dance", "Drake"));
        playlist.addSong(new Song("Hotline Bling", "Drake"));
        playlist.addSong(new Song("Passionfruit", "Drake"));
        playlist.addSong(new Song("Started From The Bottom", "Drake"));
        playlist.addSong(new Song("In My Feelings", "Drake"));
        playlist.addSong(new Song("Nonstop", "Drake"));
        playlist.addSong(new Song("Take Care", "Drake"));
        playlist.addSong(new Song("Headlines", "Drake"));
        playlist.addSong(new Song("Nice For What", "Drake"));

        // Travis Scott
        playlist.addSong(new Song("FE!N", "Travis Scott"));
        playlist.addSong(new Song("SICKO MODE", "Travis Scott"));
        playlist.addSong(new Song("Goosebumps", "Travis Scott"));
        playlist.addSong(new Song("MELTDOWN", "Travis Scott"));
        playlist.addSong(new Song("Highest In The Room", "Travis Scott"));
        playlist.addSong(new Song("90210", "Travis Scott"));
        playlist.addSong(new Song("Butterfly Effect", "Travis Scott"));
        playlist.addSong(new Song("I KNOW ?", "Travis Scott"));
        playlist.addSong(new Song("HYAENA", "Travis Scott"));
        playlist.addSong(new Song("Telekinesis", "Travis Scott"));

                Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" MUSIC PLAYLIST MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Display Playlist");
            System.out.println("2. Search Song");
            System.out.println("3. Remove Song");
            System.out.println("4. Shuffle Playlist");
            System.out.println("5. Play Next Song");
            System.out.println("6. Add New Song");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    playlist.displayPlaylist();
                    break;

                case 2:
                    System.out.print("Enter Song Name: ");
                    String searchSong = sc.nextLine();
                    playlist.searchSong(searchSong);
                    break;

                case 3:
                    System.out.print("Enter Song Name To Remove: ");
                    String removeSong = sc.nextLine();
                    playlist.removeSong(removeSong);
                    break;

                case 4:
                    playlist.shufflePlaylist();
                    break;

                case 5:
                    playlist.playNext();
                    break;

                case 6:

                    System.out.print("Enter Song Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Artist Name: ");
                    String artist = sc.nextLine();

                    playlist.addSong(new Song(title, artist));

                    System.out.println("Song Added Successfully!");
                    break;

                case 7:
                    System.out.println("Thank You For Using Music Playlist System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}