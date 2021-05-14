/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necron.util;

import com.necron.controladores.SesionDAO;
import com.necron.to.UsuarioTO;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

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
        this.user = "";
        this.password = "";
        this.puerto = 587;
    }

    public boolean enviarNotificacionReporte(byte[] archivo) {
        SesionDAO controlador = new SesionDAO();
        String detalle = getDetalleReporteSemanal();
        String subject = "Reporte Semanal";
        List<String> emails = controlador.consultarUsuariosNotificaciones();
        if (emails.size() > 0) {
            return sendNotificacion(detalle, subject, emails, archivo);
        }
        return true;
    }

    public boolean enviarNotificacionPlataforma(UsuarioTO u) {
        SesionDAO controlador = new SesionDAO();
        String detalle = getDetallePlataforma(u);
        String subject = "Ingreso a la plataforma: ";
        List<String> emails = controlador.consultarUsuariosNotificaciones();
        if (emails.size() > 0) {
            return sendNotificacion(detalle, subject, emails);
        }
        return true;
    }

    public boolean enviarNotificacionAcceso(UsuarioTO u) {
        String detalle = getDetalleCredenciales(u);
        String subject = "Bienvenido: " + u.getApterno() + " " + u.getAmaterno() + " " + u.getNombre();
        return sendNotificacion(detalle, subject, u.getMail());

    }

    public boolean sendNotificacion(String detalle, String subject, String to) {

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
            message.setRecipients(Message.RecipientType.TO, to);
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

    public boolean sendNotificacion(String detalle, String subject, List<String> emails) {

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
            InternetAddress[] recipientAddress = new InternetAddress[emails.size()];
            int i = 0;
            for (String email : emails) {
                recipientAddress[i] = new InternetAddress(email);
                i++;
            }

            message.setRecipients(Message.RecipientType.TO, recipientAddress);
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
//    

    public boolean sendNotificacion(String detalle, String subject, List<String> emails, byte[] archivo) {

        try {
            Session mailSession = this.getSession();
            Transport transport = mailSession.getTransport("smtp");
            transport.connect(this.smtp, this.user, password);
//            
            MimeMessage message = new MimeMessage(mailSession);
            ByteArrayDataSource datacsv = new ByteArrayDataSource(archivo, "application/csv");
            MimeBodyPart partcsv = new MimeBodyPart();
            partcsv.setDataHandler(new DataHandler(datacsv));
            partcsv.setFileName("reportesemanal.csv");
//            
            message.setSentDate(new java.util.Date());
            message.setSubject(subject);
            message.setFrom(new InternetAddress(this.user));

//            
            InternetAddress[] recipientAddress = new InternetAddress[emails.size()];
            int i = 0;
            for (String email : emails) {
                recipientAddress[i] = new InternetAddress(email);
                i++;
            }

            message.setRecipients(Message.RecipientType.TO, recipientAddress);
            MimeMultipart multipart = new MimeMultipart("related");
//            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(detalle, "text/html");
//            
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(partcsv);
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
                .append("<p>Password: ").append(u.getPassword()).append("</p>")
                .append("<p>Perfil: ").append(u.getPerfil().getNombre()).append("</p>")
                .append("<p>Admin. Usuarios: ").append(u.getPerfil().isCatalogousuarios() ? "Si" : "No").append("</p>")
                .append("<p>Admin. Perfiles: ").append(u.getPerfil().isCatalogoperfiles() ? "Si" : "No").append("</p>")
                .append("<p>Admin. Llantas: ").append(u.getPerfil().isCatalogollantas() ? "Si" : "No").append("</p>");
        return stb.append("</html></body>").toString();

    }

    private String getDetallePlataforma(UsuarioTO u) {
        StringBuilder stb = new StringBuilder();
        stb.append("<html><body><p>Ingreso a la plataforma:</p>")
                .append("<p>Usuario: ").append(u.getApterno()).append(" ").append(u.getAmaterno()).append(" ").append(u.getNombre()).append("</p>");
        return stb.append("</html></body>").toString();

    }

    private String getDetalleReporteSemanal() {
        StringBuilder stb = new StringBuilder();
        stb.append("<html><body><p>Adjunto Reporte Semanal</p>");
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
