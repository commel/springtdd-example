/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.decoit.springtdd.controller;

import de.decoit.springtdd.controller.form.Login;
import de.decoit.springtdd.model.Benutzer;
import de.decoit.springtdd.service.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author britter
 */
@Controller
public class LoginController {
    
    @Autowired private LoginService loginService;
    
    @RequestMapping("/login.html")
    public ModelAndView loginForm() {
        return new ModelAndView("login/form", "login", new Login());
    }
    
    @RequestMapping(value="/login.html", method = RequestMethod.POST)
    public String doLogin(final ModelMap map, @ModelAttribute Login login, final HttpSession session) {
        final Benutzer b = loginService.authenticate(login.getUsername(), login.getPassword());
        if (b != null) {
            map.put("currentuser", b);
            session.setAttribute("currentuser", b);
            return "login/welcome";
        } else {
            return "login/failed";
        }
    }
    
}
