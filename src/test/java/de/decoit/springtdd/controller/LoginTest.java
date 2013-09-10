/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.decoit.springtdd.controller;
import de.decoit.springtdd.controller.form.Login;
import de.decoit.springtdd.model.Benutzer;
import de.decoit.springtdd.service.LoginService;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
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
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/onlineshop-servlet.xml", "file:src/main/webapp/WEB-INF/tiles.xml"} )
public class LoginTest {
    
    @Autowired
    private WebApplicationContext wac;    
    
    private MockMvc mockMvc;    
    
    @InjectMocks
    private LoginController loginController;
    
    @Mock
    private LoginService mockLoginService;
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        MockitoAnnotations.initMocks(this);
    }       
    
  @Test
    public void testLogin() throws Exception {
        this.mockMvc.perform(get("/login.html"))
                .andExpect(status().isOk())
                .andExpect(view().name("login/form"))
                .andExpect(model().attribute("login", any(Login.class)));
    }

    @Test
    public void testPerformLoginWrongCreds() throws Exception {
        String username = "rudi";
        String password = "falsch";
        
        Mockito.when(mockLoginService.authenticate(username, password)).thenReturn(null);
        
        this.mockMvc.perform(post("/login.html").param("username", username).param("password", password))
                .andExpect(status().isOk())
                .andExpect(view().name("login/failed"));
    }
    
//    @Test
//    public void testPerformLogin() throws Exception {
//        final Benutzer mockUser = Mockito.mock(Benutzer.class);
//        Mockito.when(mockUser.getUsername()).thenReturn("rudi");
//        Mockito.when(mockUser.getPassword()).thenReturn("ratlos");
//        Mockito.when(mockUser.getId()).thenReturn(1l);
//        
//        Mockito.when(mockLoginService.authenticate(mockUser.getUsername(), mockUser.getPassword())).thenReturn(mockUser);
//        
//        this.mockMvc.perform(post("/login.html").param("username", mockUser.getUsername()).param("password", mockUser.getPassword()))
//                .andExpect(status().isOk())
//                .andExpect(view().name("login/welcome"))
//                .andExpect(model().attribute("currentuser", mockUser))
//                .andExpect(request().sessionAttribute("currentuser", mockUser));        
//    }    
    
}
