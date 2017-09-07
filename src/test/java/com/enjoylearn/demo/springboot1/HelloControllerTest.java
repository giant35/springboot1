/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enjoylearn.demo.springboot1;

import java.util.Objects;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author sihai
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Springboot1Application.class)
@WebAppConfiguration
public class HelloControllerTest {

    MockMvc mvc;

    public HelloControllerTest() {
    }

    @Before
    public void setup() {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void testSayHelloWeb() throws Exception {
        ResultActions r = mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON));
        Object ret = r.andExpect(result->Objects.equals(HelloController.MSG, result));
        System.out.println(ret);
    }
    
    @Test
    public void testSayHello(){
        HelloController c = new HelloController();
        Object ret = c.sayHello();
        assertTrue(HelloController.MSG.equals(ret));        
    }

}
