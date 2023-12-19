package com.abmhimel.freemarker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abmhimel.freemarker.dto.MailRequest;
import com.abmhimel.freemarker.dto.MailResponse;
import com.abmhimel.freemarker.service.EmailService;

@RestController
public class MailController {
    @Autowired
    EmailService service;

    @PostMapping("/sendmail")
    public MailResponse sendMail(@RequestBody MailRequest request) {
        Map<String,Object> model = new HashMap<String,Object>();
        model.put("name", request.getName());
        return service.sendOfferLetterMail(request, model);
    }
    

}
