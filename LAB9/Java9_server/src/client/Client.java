package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.io.*;

//client
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        BufferedReader br = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 8085);
            br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            Random rand = new Random();
            while (true) {
                System.out.println(br.readLine());
                Thread.sleep((rand.nextInt()%1000)+5000);
            }
        } catch (Exception ex) {
            System.out.println();
        }
    }
}
