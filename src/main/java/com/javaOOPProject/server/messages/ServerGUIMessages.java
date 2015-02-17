/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server.messages;

/**
 *
 * @author fgg12
 */
public enum ServerGUIMessages {
    
    ERROR_STARTING_SERVER("There is an error starting server."),
    SERVER_IS_STARTED("Server is started."),
    SERVER_IS_STOPPED("Server is stopped"),
    CANNOT_LOAD_FILE_WITH_USERS("Cannot find or load file with users!"),
    WRONG_FORMAT_USERNAME("The username has forbidden symbols"),
    WRONG_FORMAT_PASSWORD("The password has forbidden symbols"),
    ERROR_SAVING_CHANGES("There is an error and changes are not saved!"),
    CANNOT_FIND_FILE_TO_SAVE("Cannot find file with data"),
    PASSWORDS_NOT_MATCH("The two fields of passwords are different!");
    
    
    
    private final String message;
    
    private ServerGUIMessages(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
}
