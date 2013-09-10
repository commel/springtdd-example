/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.decoit.springtdd.controller;

import de.decoit.springtdd.controller.form.Hello;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Value("${farbe}") private String farbe;
    @Value("${wetter}") private String wetter;
    
    @RequestMapping("/index.html")
    public String printHello(final ModelMap map) {
        map.put("farbe", farbe);
        map.put("wetter", wetter);
        return "index";
    }
    
    @RequestMapping("/sayhello/{name}")
    public String sayhello(final ModelMap map, @PathVariable("name") final String name) {
        map.put("name", name);
        map.put("title", "aus dem controller");
        return "sayhello/hello";
    }
    
    @RequestMapping("/helloform.html")
    public ModelAndView helloForm() {
        return new ModelAndView("helloform", "hello", new Hello());
    }
    
    @RequestMapping(value="helloform.html", method = RequestMethod.POST)
    public ModelAndView helloFormSubmit(@Valid @ModelAttribute("hello") Hello helloCmd, final BindingResult result, final ModelMap map) {
        if (result.hasErrors()) {
            return new ModelAndView("helloform");
        }

        map.put("name", helloCmd.getName());        
        
        return new ModelAndView("sayhello/hello", map);
    }    
}