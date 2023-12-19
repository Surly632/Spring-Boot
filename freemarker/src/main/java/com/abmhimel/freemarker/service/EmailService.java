package com.abmhimel.freemarker.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.abmhimel.freemarker.dto.MailRequest;
import com.abmhimel.freemarker.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private Configuration config;

    public MailResponse sendOfferLetterMail(MailRequest req, Map<String,Object> model) {
        MailResponse res = new MailResponse();
        try {
            MimeMessage message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED,StandardCharsets.UTF_8.name());

            helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
            
            Template template = config.getTemplate("email.ftlh");
            String htmString = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

            helper.setTo(req.getTo());
            helper.setText(htmString,true);
            helper.setSubject(req.getSubject());
            
            sender.send(message);
            res.setMessage("Mail Sent to: "+req.getTo());
            res.setStatus(Boolean.TRUE);
            return res;
        } catch (MessagingException | IOException | TemplateException e) {
            res.setMessage("Message sending Failed to: "+ req.getTo());
            res.setStatus(Boolean.FALSE);
            System.err.println(e.getMessage());
            return res;
        }
    }
}
