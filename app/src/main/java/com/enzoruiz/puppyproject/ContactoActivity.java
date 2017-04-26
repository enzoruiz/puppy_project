package com.enzoruiz.puppyproject;

import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText tietNombre, tietEmail, tietMensaje;
    Button bEnviarComentario;
    private String correo, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        correo = "mi_correo@gmail.com";
        contraseña = "la_contraseña";

        tietNombre  = (TextInputEditText) findViewById(R.id.tietNombre);
        tietEmail   = (TextInputEditText) findViewById(R.id.tietEmail);
        tietMensaje = (TextInputEditText) findViewById(R.id.tietMensaje);

        bEnviarComentario = (Button) findViewById(R.id.bEnviarComentario);

        bEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.googlemail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");


                try {
                    Session session = Session.getDefaultInstance(props, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }
                    });

                    if(session != null){
                        Message mensaje = new MimeMessage(session);
                        mensaje.setFrom(new InternetAddress(correo));
                        mensaje.setSubject("Gracias por el comentario " + tietNombre.getText().toString() + "!");
                        mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tietEmail.getText().toString()));
                        mensaje.setContent(tietMensaje.getText().toString(), "text/html; charset=utf-8");
                        Transport.send(mensaje);
                    }


                } catch (MessagingException mex) {
                    System.out.println("send failed, exception: " + mex);
                }

                tietNombre.setText("");
                tietEmail.setText("");
                tietMensaje.setText("");
            }
        });

    }
}
