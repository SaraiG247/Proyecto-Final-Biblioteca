/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;

/**
 *
 * @author Sarai
 */
public class EnviarCorreo {

    private static final String SMTP_SERVER = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String EMAIL_REMITENTE = "gmzlpzsara77@gmail.com";
    private static final String PASSWORD_REMITENTE = "nkuc tvzz wgdq icrn";

    public static void enviarConAdjunto(String destino, String asunto,
            String mensajeTexto, File archivo) throws Exception {
        // Configurar propiedades del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_SERVER);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Crear sesión con autenticación
        Session sesion = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_REMITENTE, PASSWORD_REMITENTE);
            }
        });

        // Crear mensaje
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(EMAIL_REMITENTE, "Sistema Raíces y Letra"));
        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destino));
        mensaje.setSubject(asunto);

        // Parte del texto
        MimeBodyPart cuerpo = new MimeBodyPart();
        cuerpo.setText(mensajeTexto);

        // Parte del adjunto
        MimeBodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(new DataHandler(new FileDataSource(archivo)));
        adjunto.setFileName(archivo.getName());

        // Combinar partes
        Multipart multiParte = new MimeMultipart();
        multiParte.addBodyPart(cuerpo);
        multiParte.addBodyPart(adjunto);

        mensaje.setContent(multiParte);
        Transport.send(mensaje); // Enviar
    }

    // Validación simple de email
    public static boolean validarEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
}
