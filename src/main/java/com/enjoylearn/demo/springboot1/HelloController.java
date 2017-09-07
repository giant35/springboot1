/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enjoylearn.demo.springboot1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sihai
 */
@RestController
public class HelloController {

    @Value("${hello.name}")
    String name;

    final static String MSG = "Hello tom";

    @RequestMapping("/hello")
    public String sayHello() {
        return MSG;
    }

    @RequestMapping("/name")
    public String queryName() {
        return name;
    }
}
