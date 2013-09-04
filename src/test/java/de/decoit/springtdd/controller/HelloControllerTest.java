package de.decoit.springtdd.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:test-servlet.xml"} )
public class HelloControllerTest {
    
    @Autowired
    private WebApplicationContext wac;    
    
    private MockMvc mockMvc;    
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }    
    
    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(get("/index.html"))
                                   .andExpect(view().name("index"))
                .andExpect(model().attribute("wetter", "sonnig"))
                .andExpect(model().attribute("farbe", "grün"));
    }
    
    @Test
    public void testHelloSayer() throws Exception {
        this.mockMvc.perform(get("/sayhello/alberteinstein"))
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "alberteinstein"));
    }
    
//    @Test
//    public void testHelloForm() throws Exception {
//        this.mockMvc.perform(get("/helloform.html"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("helloform"));
//
//        this.mockMvc.perform(post("/helloform.html")
//                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
//                .content("name=rudiratlos")                
//                )
//                .andExpect(status().isOk())
//                .andExpect(view().name("hello"))
//                .andExpect(model().attribute("name", "rudiratlos"));
//    }
    
}
