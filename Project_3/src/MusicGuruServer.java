import java.io.*;
import java.net.*;
import java.util.*;

public class MusicGuruServer {
    private static Map<Integer, List<String>> songYears = new HashMap<>();
    private static final int min = 1990;
    private static final int max = 1999;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MusicGuruServer <port>");
            return;
        }

        int port = Integer.parseInt(args[0]);
        musicDataset(); // Populate the dataset for each year

        try (ServerSocket s = new ServerSocket(port)) { // server
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket c = s.accept(); // client
                System.out.println("Client connected: " + c.getInetAddress());

                new ClientHandler(c).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void musicDataset() {
        //1990 song top 10
        songYears.put(1990, Arrays.asList(
            "1. ‘Nothing Compares 2 U’ by Sinead O’Connor",
            "2. ‘Enjoy The Silence’ by Depeche Mode",
            "3. ‘U Can’t Touch This’ by MC Hammer",
            "4. ‘Vogue’ by Madonna",
            "5. ‘Groove is in the Heart’ by Deee-Lite",
            "6. ‘Thunderstruck’ by AC/DC",
            "7. More Than Words by Extreme",
            "8. Man In The Box by Alice In Chains",
            "9. Vision of Love by Mariah Carey",
            "10. Wind of Change by Scorpions"
        ));

        //1991 song top 10
        songYears.put(1991, Arrays.asList(
            "1. ‘Smells Like Teen Spirit’ by Nirvana",
            "2. ‘Losing My Religion’ by R.E.M.",
            "3. 'One' by U2",
            "4. ‘Under The Bridge’ by Red Hot Chili Peppers",
            "5. ‘Jeremy’ by Pearl Jam",
            "6. ‘Enter Sandman’ by Metallica",
            "7. ‘Come As You Are’ by Nirvana",
            "8. ‘Alive’ by Pearl Jam",
            "9. ‘November Rain’ by Guns N’ Roses",
            "10.‘Black or White’ by Michael Jackson"
        )); 

        //1992 song top 10
        songYears.put(1992, Arrays.asList(
        "1. ‘Nuthin’ But a “G” Thang’ by Dr. Dre",
            "2. ‘Creep’ by Radiohead",
            "3. ‘Tears In Heaven’ by Eric Clapton",
            "4. ‘Jump Around’ by House of Pain",
            "5. ‘Killing In The Name’ by Rage Against The Machine",
            "6. ‘It was a Good Day’ by Ice Cube",
            "7. ‘Baby Got Back’ by Sir Mix-a-Lot",
            "8. ‘Everybody Hurts’ by R.E.M.",
            "9. ‘Friday I’m in Love’ by The Cure",
            "10. ‘What’s Up’ by 4 Non Blondes"
            // Add other songs for 1992...
        ));

        //1993 song top 10
        songYears.put(1993, Arrays.asList(
        "1. ‘Loser’ by Beck",
            "2. ‘Heart-Shaped Box by Nirvana",
            "3. ‘Gin & Juice’ by Snoop Dogg",
            "4. ‘Mr. Jones’ by Counting Crows",
            "5. ‘C.R.E.A.M.’ by Wu Tang Clan",
            "6. ‘Insane in the Brain’ by Cypress Hill",
            "7. ‘Linger’ by Cranberries",
            "8. ‘What is Love’ by Haddaway",
            "9. ‘Are You Gonna Go My Way’ by Lenny Kravitz",
            "10. ‘That’s the Way Love Goes’ by Janet Jackson"
            // Add other songs for 1993...
        ));

        //1994 song top 10
        songYears.put(1994, Arrays.asList(
            "1. ‘Waterfalls’ by TLC",
            "2. ‘Black Hole Sun’ by Soundgarden",
            "3. ‘Sabotage’ by Beastie Boys",
            "4. ‘Regulate’ by Warren G",
            "5. ‘Zombie’ by The Cranberries",
            "6. ‘Juicy’ by The Notorious B.I.G.",
            "7. ‘Basket Case’ by Green Day",
            "8. ‘Buddy Holly’ by Weezer",
            "9. ‘Hallelujah’ by Jeff Buckley",
            "10. ‘Big Poppa’ by The Notorious B.I.G."
            // Add other songs for 1994...
        ));

        //1995 song top 10
        songYears.put(1995, Arrays.asList(
        "1. ‘Gangsta’s Paradise’ by Coolio",
            "2. ‘Wonderwall’ by Oasis",
            "3. ‘California Love’ by 2Pac (feat. Dr. Dre)",
            "4. ‘You Oughta Know’ by Alanis Morissette",
            "5. ‘1979’ by Smashing Pumpkins",
            "6. ‘Don’t Speak’ by No Doubt",
            "7. ‘Dear Mama’ by 2Pac",
            "8. ‘Ironic’ by Alanis Morissette",
            "9. ‘Bullet With Butterfly Wings’ by Smashing Pumpkins",
            "10. ‘Fantasy’ by Mariah Carey"
            // Add other songs for 1995...
        ));

        //1996 song top 10
        songYears.put(1996, Arrays.asList(
        "1. ‘Killing Me Softly’ by The Fugees",
            "2. ‘No Diggity’ by BLACKstreet",
            "3. ‘Wannabe’ by Spice Girls",
            "4. ‘Lovefool’ by Cardigans",
            "5. ‘Firestarter’ by Prodigy",
            "6. ‘What I Got’ by Sublime",
            "7. ‘Un-Break My Heart’ by Toni Braxton",
            "8. ‘I Believe I Can Fly’ by R. Kelly",
            "9. ‘Ready or Not’ by The Fugees",
            "10. ‘Bulls on Parade’ by Rage Against The Machine"
            // Add other songs for 1996...
        ));

        //1997 song top 10
        songYears.put(1997, Arrays.asList(
        "1. ‘Bitter Sweet Symphony’ by The Verve",
            "2. ‘Song 2’ by Blur",
            "3. ‘Paranoid Android’ by Radiohead",
            "4. ‘Everlong’ by Foo Fighters",
            "5. ‘Hypnotise’ by The Notorious B.I.G.",
            "6. ‘Karma Police’ by Radiohead",
            "7. ‘Good Riddance (Time of Your Life)’ by Green Day",
            "8. ‘Torn’ by Natalie Imbruglia",
            "9. ‘I’ll Be Missing You’ by Puff Daddy",
            "10. ‘Mo Money Mo Problems’ by The Notorious B.I.G."
            // Add other songs for 1997...
        ));

        //1998 song top 10
        songYears.put(1998, Arrays.asList(
        "1. ‘Doo Wop (That Thing)’ by Lauryn Hill",
            "2. ‘Iris’ by Goo Goo Dolls",
            "3. ‘Baby One More Time’ by Britney Spears",
            "4. ‘I Don’t Want to Miss A Thing’ by Aerosmith",
            "5. ‘Believe’ by Cher",
            "6. ‘Hard Knock Life’ by Jay-Z",
            "7. ‘Intergalactic’ by Beastie Boys",
            "8. ‘The Boy is Mine’ by Brandy and Monica",
            "9. ‘Freak on a Leash’ by Korn",
            "10. ‘Changes’ by 2Pac"
            // Add other songs for 1998...
        ));

        //1999 song top 10
        songYears.put(1999, Arrays.asList(
        "1. ‘My Name Is’ by Eminem",
            "2. ‘Smooth’ by Santana and Rob Thomas",
            "3. ‘Say My Name’ by Destiny’s Child",
            "4. ‘No Scrubs’ by TLC",
            "5. ‘Californication’ by Red Hot Chili Peppers",
            "6. ‘I Want It That Way’ by Backstreet Boys",
            "7. ‘Still D.R.E.’ by Dr. Dre",
            "8. ‘All the Small Things’ by Blink 182",
            "9. ‘Scar Tissue’ by Red Hot Chili Peppers",
            "10. ‘All Star’ by Smash Mouth"
            // Add other songs for 1999...
        ));

    }

    private static class ClientHandler extends Thread {
        private Socket c;

        public ClientHandler(Socket socket) {
            this.c = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
                 PrintWriter out = new PrintWriter(c.getOutputStream(), true)) {

                //year requested by client
                int requestedYear = Integer.parseInt(in.readLine());

                if (requestedYear < min || requestedYear > max) {
                    //year out of range - random year within range
                    int randomYear = new Random().nextInt(max - min + 1) + min;
                    out.println("Specified year out of range (" + min + "-" + max + "), using random year instead:");
                    requestedYear = randomYear;
                }

                //list of songs for requested year
                List<String> s = songYears.get(requestedYear);

                if (s != null && !s.isEmpty()) {
                    //random song from the list
                    int randomIndex = new Random().nextInt(s.size());
                    String selectedSong = s.get(randomIndex);
                    //String serverIP = InetAddress.getLocalHost().getHostAddress();

                    //selected song send to client
                    //out.println("In " + requestedYear + ", the number " + selectedSong + " (" + serverIP + ")");
                    out.println("In " + requestedYear + ", the number " + selectedSong);
                }

                c.close(); //close client connection
                System.out.println("Client disconnected: " + c.getInetAddress());
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
