/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.decoit.springtdd.service;

import de.decoit.springtdd.model.Benutzer;
import org.springframework.stereotype.Service;

/**
 *
 * @author britter
 */
@Service
public class PlainLoginService implements LoginService {

    @Override
    public Benutzer authenticate(final String username, final String password) {
        if (username.equals("rudi") && password.equals("ratlos")) {
            final Benutzer b = new Benutzer();
            b.setUsername(username);
            b.setPassword(password);
            return b;
        } else {
            return null;
        }
    }
    
}
