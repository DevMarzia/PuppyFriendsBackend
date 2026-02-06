package com.devmarzia.PuppyFriendBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendWelcomeEmail(String toEmail, String firstName) {
        SimpleMailMessage message = new SimpleMailMessage();

        // Imposto il mittente (può essere un indirizzo fittizio per Mailtrap)
        message.setFrom("noreply@petadoption.com");
        message.setTo(toEmail);
        message.setSubject("Benvenuto su Pet Adoption!");
        message.setText("Ciao " + firstName + ",\n\n" +
                "Benvenuto in PuppyFriends!\n"+
                "Il tuo account è stato creato con successo!\n\n" +
                "A presto,\n"+"Il team di PuppyFriends");

        javaMailSender.send(message);
        System.out.println("Email inviata con successo a: " + toEmail);
    }
}