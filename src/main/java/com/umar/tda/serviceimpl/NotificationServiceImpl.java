/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umar.tda.serviceimpl;

import com.umar.tda.entity.User;
import com.umar.tda.exception.ExceptionEmailFailToSend;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author UMAR
 */
@Service
public class NotificationServiceImpl {

    private JavaMailSender mailSender;

    public NotificationServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    
    public void VerificationNotification(User user, String frontURL) {

        try {
            
            String toAddress = user.getEmail();
            String fromAddress = "ibnusuhaimientertainment@gmail.com";
            String senderName = "ibnusuhaimientertainment";
            String subject = "Please verify your registration";
            String content = "Dear [[name]],<br>" + "Please click the link below to verify your registration:<br>" + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "ibnusuhaimientertainment.";

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(fromAddress, senderName);
            helper.setTo(toAddress);
            helper.setSubject(subject);

            content = content.replace("[[name]]", user.getName());

            String verifyURL = frontURL + "/verify?code=" + user.getVerificationCode();

            content = content.replace("[[URL]]", verifyURL);

            helper.setText(content, true);

            mailSender.send(message);
            
        } catch (MessagingException | UnsupportedEncodingException e) {

            throw new ExceptionEmailFailToSend("Failed to send verifcation email to " + user.getEmail(), e);

        }

    }

}
