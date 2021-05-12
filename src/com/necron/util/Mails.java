/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.util;

import com.necron.to.UsuarioTO;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author freet
 */
public class Mails {

    private final String smtp;
    private final String user;
    private final String password;
    private final int puerto;

    public Mails() {
        this.smtp = "smtp.gmail.com";
        this.user = "asistente@necron.digital";
        this.password = "asistentenecron2020";
        this.puerto = 587;
    }

    public boolean enviarNotificacionAcceso(UsuarioTO u) {
        String detalle = getDetalleCredenciales(u);
        String subject = "Bienvenido: " + u.getApterno() + " " + u.getAmaterno() + " " + u.getNombre();
        return sendNotificacion(detalle, subject);

    }

    public boolean sendNotificacion(String detalle, String subject) {

        try {
            Session mailSession = this.getSession();
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(this.smtp, this.user, password);
//            
            MimeMessage message = new MimeMessage(mailSession);
//            
            message.setSentDate(new java.util.Date());
            message.setSubject(subject);
            message.setFrom(new InternetAddress(this.user));

//            
            message.setRecipients(Message.RecipientType.TO, "isc.antonioduran@gmail.com");
            MimeMultipart multipart = new MimeMultipart("related");
//            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(detalle, "text/html");
//            
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
//            
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            transport.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getDetalleCredenciales(UsuarioTO u) {
//        
        StringBuilder stb = new StringBuilder();
//        
        stb.append("<html><body><p>Credenciales para la Plataforma:</p>")
                .append("<p>User: ").append(u.getUser()).append("</p>")
                .append("<p>Password: ").append(u.getPassword()).append("</p>");
//        
        return stb.append("</html></body>").toString();

    }

    private Session getSession() {
        Properties props = System.getProperties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", this.smtp);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", this.puerto);
        props.put("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.user", this.user);
        props.setProperty("mail.password", this.password);

//
        Session mailSession = Session.getDefaultInstance(props, null);
        mailSession.setDebug(false);
//                
        return mailSession;

    }

}
