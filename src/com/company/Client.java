package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static int port = 4004;
    private static BufferedReader writtenByClient;
    private static BufferedReader sentFromServer;
    private static BufferedWriter sendToServer;

    public static void main(String[] args) {
        String messageFromClient;
        String messageFromServer;
        try {
            socket = new Socket("localhost", port);

            writtenByClient = new BufferedReader(new InputStreamReader(System.in));
            sendToServer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                System.out.println("Write message: ");
                messageFromClient = writtenByClient.readLine();
                sendToServer.write(messageFromClient + '\n');
                sendToServer.flush();

                sentFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                messageFromServer = sentFromServer.readLine();
                System.out.println(messageFromServer);
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
}