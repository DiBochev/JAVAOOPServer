/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server.registeredClients;

import java.util.ArrayList;

/**
 *
 * @author fgg12
 */
public class RegisteredClients {
    
    private int currentUserShown = 0;
    private ArrayList<Client> clients;

    private RegisteredClients() {
        this.clients = new ArrayList<RegisteredClients.Client>();
    }

    public RegisteredClients(RegisteredClients reg) {
        for (int i = 0; i < reg.getArraySize(); i++) {
            this.clients = (ArrayList<Client>) reg.getArray().clone();
        }
    }

    private ArrayList<Client> getArray() {
        return this.clients;
    }

    private void addClient(Client c) {
        clients.add(c);
    }

    public int getArraySize() {
        return clients.size() - 1;
    }

    public Client getFirstClient() {
        currentUserShown++;
        return clients.get(0);
    }

    public Client getClientByIndex(int i) {
        return clients.get(i);
    }

    public Client getNextClient() {
        currentUserShown++;
        if (currentUserShown > (clients.size() - 1)) {
            currentUserShown = 0;
        }
        return clients.get(currentUserShown);
    }

    public Client getPreviousClient() {
        currentUserShown--;
        if (currentUserShown < 0) {
            currentUserShown = clients.size() - 1;
        }
        return clients.get(currentUserShown);
    }

    public Client getCurrentClient() {
        return clients.get(currentUserShown);
    }

    public void addClient(String username, String password, boolean permissionForCrypt) {
        clients.add(new Client(username, password, permissionForCrypt));
    }

	//client starts
    
    public static class Client {

        private String username;
        private String password;
        private boolean permissionForCrypt;
        private ArrayList<String> cards;

        private Client() {
            this.cards = new ArrayList<>();
        }

        public Client(String username, String password, boolean permissionForCrypt) {
            this.username = username;
            this.password = password;
            this.permissionForCrypt = permissionForCrypt;
        }

        public String getUsername() {
            return username;
        }

        public ArrayList<String> getCardNumbers() {
            return this.cards;
        }

        public String getPassword() {
            return password;
        }

        public boolean isPermissionForCrypt() {
            return permissionForCrypt;
        }

        public void setPermissionForCrypt(boolean permissionForCrypt) {
            this.permissionForCrypt = permissionForCrypt;
        }
    }
}
