/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fgg12
 */
public class RequestHandler implements Runnable {

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            sendClientMassage(processRequest(recieveMassage()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String recieveMassage() throws IOException {
        ois = new ObjectInputStream(socket.getInputStream());
        String message = null;
        try {
            message = (String) ois.readObject();
            System.out.println("recieved" + message);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return message;
    }

    public String processRequest(String request) {
            return XMLManager.isRegistered(request);
    }

    public void sendClientMassage(String massage) throws IOException {
        oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(massage);
        oos.close();
        socket.close();
    }
}
