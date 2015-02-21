/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.javaOOPProject.server.registeredClients.RegisteredClients;
import com.javaOOPProject.server.registeredClients.RegisteredClients.Client;
import com.thoughtworks.xstream.XStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author fgg12
 */
public class XMLManager {

    private static RegisteredClients rc;

    public static RegisteredClients loadData(String path) throws IOException {
        XStream xstream = new XStream();
        xstream.alias("registeredClients", RegisteredClients.class);
        xstream.omitField(RegisteredClients.class, "currentUserShown");
        xstream.alias("client", RegisteredClients.Client.class);
        RegisteredClients reg = (RegisteredClients) xstream.fromXML(readFile(path));
        XMLManager.rc = new RegisteredClients(reg);
        return reg;
    }

    private static String readFile(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }
        return stringBuilder.toString();
    }

    public static void parceToXMLString(RegisteredClients reg, String path) throws FileNotFoundException, IOException {
        XMLManager.rc = reg;
        OutputStream os = new FileOutputStream(path);
        XStream xstream = new XStream();
        xstream.alias("registeredClients", RegisteredClients.class);
        xstream.omitField(RegisteredClients.class, "currentUserShown");
        xstream.alias("client", RegisteredClients.Client.class);
        os.write(xstream.toXML(rc).getBytes());
        os.flush();
        os.close();
    }

    public static String isRegistered(String request) {
        String temp = request;
        Pattern pattern = Pattern.compile("<username>(.+?)</username>");
        Matcher matcher = pattern.matcher(temp);
        matcher.find();
        String username = matcher.group(1);

        pattern = Pattern.compile("<password>(.+?)</password>");
        matcher = pattern.matcher(temp);
        matcher.find();
        String password = matcher.group(1);
        
        pattern = Pattern.compile("<string>(.+?)</string>");
        matcher = pattern.matcher(temp);
        
        ArrayList<String> arr = new ArrayList<>();
        while (matcher.find()) {
            arr.add(matcher.group(1));
        }

        for (int i = 0; i < rc.getArraySize(); i++) {

            if (rc.getClientByIndex(i).getUsername().equals(username) && rc.getClientByIndex(i).getPassword().equals(password)) {
                return XMLManager.createResponse(rc.getClientByIndex(i), true, arr);
            }
        }
        return null;
    }

    public static String createResponse(Client client, boolean isLogged, ArrayList<String> arr) {
        if (!arr.isEmpty()) {
            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < client.getCardNumbers().size(); j++) {
                    if (arr.get(i).equals(client.getCardNumbers().get(j))) {
                        arr.remove(i);
                    }
                }
            }
           
            client.getCardNumbers().addAll(arr);
        }
        XStream xstream = new XStream();
        xstream.alias("client", RegisteredClients.Client.class);
        return xstream.toXML(client);

    }
}
