import java.io.*;
import java.net.*;
import java.util.Random;

public class MusicGuruClient {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please use: java MusicGuruClient <serverIP> <port> <year>");
            return;
        }

        String serverIP = args[0];
        int port = Integer.parseInt(args[1]);
        int rYear = Integer.parseInt(args[2]);

        try (Socket s = new Socket(serverIP, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

            if (rYear < 1990 || rYear > 1999) {
                System.out.println("Specified year out of range (1990-1999), using a random year instead:");
                rYear = getRandomYear();
            }

            out.println(rYear); // Send the requested year to the server

            String r = in.readLine(); // Receive/print the response from the server
            System.out.println(r);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getRandomYear() {
        return new Random().nextInt(10) + 1990;
    }
}
