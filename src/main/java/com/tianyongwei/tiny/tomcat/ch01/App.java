package com.tianyongwei.tiny.tomcat.ch01;

import java.io.*;
import java.net.Socket;

public class App {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.124.5", 8080);
            OutputStream os = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // send http request
            writer.println("GET /index.jsp HTTP/1.1");
            writer.println("HOST: 192.168.124.5:8080");
            writer.println("Connection: Close");
            writer.println();
            writer.println("hello world!");
            // read the request
            boolean loop = true;
            StringBuffer sb = new StringBuffer(8096);
            while (loop) {
                System.out.println("loop");
                if(reader.ready()) {
                    int i = 0;
                    while (i != -1) {
                        i = reader.read();
                        sb.append((char)i);
                    }
                    loop = false;
                }
                Thread.currentThread().sleep(50);
            }
            System.out.println(sb.toString());
            socket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
