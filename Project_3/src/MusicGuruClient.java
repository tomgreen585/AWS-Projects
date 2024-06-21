import java.io.*;
import java.net.*;
import java.util.Random;

public class MusicGuruClient{
    public static void main(String[] args){
        
        if (args.length != 3){ //if server not setup correctly display error message
            System.out.println("Please establish client correctly: java MusicGuruClient serverIP (e.g. 0.0.0.0) portNum(e.g. 5000) year");
            return;
        }

        String serverIP = args[0]; //gain server ip from client setup
        int serverPort = Integer.parseInt(args[1]); //gain port from client setup
        int reqYear = Integer.parseInt(args[2]); //gain requested year from client setup

        try(
            Socket s = new Socket(serverIP, serverPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true)
            ){
   
            int minYear = Integer.parseInt(in.readLine()); //receive min year from server
            int maxYear = Integer.parseInt(in.readLine()); //receive max year from server

            int randomYear = new Random().nextInt(10) + minYear; //generate random year between min and max year

            //if requested year is out of bounds of 1990-1999
            if (reqYear < minYear || reqYear > maxYear){
                reqYear = randomYear; //get random year to display
                System.out.println("Specified year out of range ("+minYear+ " - " +maxYear+"), using a random year instead: " + reqYear); //print random year to client
            }

            out.println(reqYear); //send the requested year to the server 

            String serverResponse = in.readLine(); //receive response from server
            System.out.println("In " +reqYear+ " " + serverResponse); //print response

        } 
        
        catch (IOException e) {e.printStackTrace();}
    }
}
