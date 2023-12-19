package com.abmhimel.freemarker.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.el.stream.Stream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abmhimel.freemarker.model.Menu;

@Controller
@RequestMapping("")
public class AppController {
    @GetMapping
    public ResponseEntity<Void> homePage() {
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.LOCATION, "/index.html");
        return ResponseEntity
        .status(HttpStatus.FOUND)
        .headers(header) 
        .body(null);
        
    }
    @GetMapping("/welcome/{name}")
    public String welcomeString(@PathVariable String name, Model model) {
        List<Menu> menus = Arrays.asList(
                new Menu("Fried Rice", 9.99),
                new Menu("Paasta", 10.59),
                new Menu("Burger", 12.99),
                new Menu("Salad", 8.49),
                new Menu("Pizza", 15.99),
                new Menu("Steak", 20.99)
        );
        model.addAttribute("user",name);
       model.addAttribute("menus", menus);
       
        return "welcome";
    }
}
