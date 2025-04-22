package Persistencia;


import io.github.cdimascio.dotenv.Dotenv;
import org.example.Notificacion;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class Mail implements Notificacion {
    private String from;

    public Mail(String from) {
        this.from = from;
    }


    @Override
    public void enviarNotificacion(String destiantario, String asunto, String mensaje) {

        Email email = EmailBuilder.startingBlank()
                .from("Remitente Prueba", from)
                .to("Destinatario Prueba", destinatario)
                .withSubject(asunto)
                .withPlainText(mensaje)
                .buildEmail();

        Dotenv dotenv = Dotenv.load();
        String username = dotenv.get("MAILTRAP_USER");
        String password = dotenv.get("MAILTRAP_PASSWORD");

        // Create the mailer object with SMTP server settings
        Mailer mailer = MailerBuilder
                .withSMTPServer("sandbox.smtp.mailtrap.io", 587, username, password)
                .withTransportStrategy(TransportStrategy.SMTP)
                .buildMailer();

        // Send the email
        mailer.sendMail(email);

    }
}
