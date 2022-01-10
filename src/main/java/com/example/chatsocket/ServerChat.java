package com.example.chatsocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerChat {
    public static void main(String[] args) {
        int nbrClient = 0 ;
        Map<Integer, Socket> clients = new HashMap<>();
        try {
            ServerSocket ss = new ServerSocket(80) ;
            while (true){
                nbrClient++ ;
                Socket s = ss.accept() ;
                clients.put(nbrClient,s) ;
                ThreadChat tc = new ThreadChat(nbrClient,s,clients) ;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
