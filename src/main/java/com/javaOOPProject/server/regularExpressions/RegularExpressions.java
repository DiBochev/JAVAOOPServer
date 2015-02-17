/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javaOOPProject.server.regularExpressions;

/**
 *
 * @author fgg12
 */
public enum RegularExpressions {
    VALIDATE_USERNAME("^[a-z0-9_-]{3,15}$"),
    VALIDATE_PASSWORD("^[a-zA-Z0-9]{3,15}$");
    
    private final String regex;

    private RegularExpressions(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
