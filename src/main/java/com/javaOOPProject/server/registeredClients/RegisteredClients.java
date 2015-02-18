/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server.registeredClients;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fgg12
 */
@XmlRootElement(name = "clients")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegisteredClients {

    @XmlTransient
    private int currentUserShown = 0;
    
	@XmlElement(name = "client")
	private ArrayList<Client> array;
	
	private RegisteredClients(){
	}
        
        public RegisteredClients(RegisteredClients reg){
            for (int i = 0; i < reg.getArraySize(); i++) {
                this.array = (ArrayList<Client>) reg.getArray().clone();
            }
        }
        private ArrayList<Client> getArray(){
            return this.array;
        }
        
        private void addClient(Client c){
            array.add(c);
        }
        
        public int getArraySize(){
            return array.size() - 1;
        }
        
        public Client getFirstClient(){
            currentUserShown++;
            return array.get(0);
        }
        
        public Client getClientByIndex (int i){
            return array.get(i);
        }
        
        public Client getNextClient(){
            currentUserShown++;
            if (currentUserShown > (array.size() - 1)) {
                currentUserShown = 0;
            }
            return array.get(currentUserShown);
        }
        
        public Client getPreviousClient(){
            currentUserShown--;
            if (currentUserShown < 0) {
                currentUserShown = array.size() - 1;
            }
            return array.get(currentUserShown);
        }
        
        public Client getCurrentClient(){
            return array.get(currentUserShown);
        }
	
        public void addClient(String username, String password, boolean permissionForCrypt){
            array.add(new Client(username, password, permissionForCrypt));
            
        }

	
	
	//client starts

	@XmlRootElement(name = "client")
	@XmlAccessorType(XmlAccessType.FIELD)
	public static class Client{
		
		@XmlElement(name = "username")
		private String username;
		@XmlElement(name = "password")
		private String password;
		@XmlElement(name = "permissionForCrypt")
		private boolean permissionForCrypt;
		@XmlElement(name = "cryptedCard")
		private ArrayList<String> cards;
		
		private Client(){
		}
                
                private Client(String username, String password, boolean permissionForCrypt){
                    this.username = username;
                    this.password = password;
                    this.permissionForCrypt = permissionForCrypt;
                }
		public String getUsername() {
			return username;
		}
                
                public ArrayList<String> getCardNumbers(){
                    return this.cards;
                }
                
//		public void setUsername(String username) {
//			this.username = username;
//		}
		public String getPassword() {
			return password;
		}
//		public void setPassword(String password) {
//			this.password = password;
//		}
		public boolean isPermissionForCrypt() {
			return permissionForCrypt;
		}
		public void setPermissionForCrypt(boolean permissionForCrypt) {
			this.permissionForCrypt = permissionForCrypt;
		}
	}
}


