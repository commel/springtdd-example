/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.decoit.springtdd.service;

import de.decoit.springtdd.model.Benutzer;

/**
 *
 * @author britter
 */
public interface LoginService {
    
    Benutzer authenticate(String username, String password);
    
}
