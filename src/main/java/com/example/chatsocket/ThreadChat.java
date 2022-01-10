package com.example.chatsocket;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ThreadChat extends Thread {
    private int nbrClient ;
    private Socket s ;
    private Map<Integer, Socket> clients ;
    public ThreadChat(int nbrClient, Socket s, Map<Integer, Socket> clients ) {
        this.nbrClient = nbrClient;
        this.s = s;
        this.clients = clients ;
    }

    @Override
    public void run() {
        try{
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream() ;
            BufferedReader br = new BufferedReader(new InputStreamReader(is)) ;
            PrintWriter pr = new PrintWriter(os) ;
            pr.println("Hello " + nbrClient);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}
