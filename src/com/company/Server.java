package com.company;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static int port = 4004;
    private static BufferedReader in;
    private static BufferedWriter out;
    public static void main(String[] args) {
        String messageFromClient;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server activated");
            socket = serverSocket.accept();
            System.out.println("Connection successes");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true){
                messageFromClient = in.readLine();
            out.write("Message obtained: " + messageFromClient + '\n');
            out.flush();
        }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}