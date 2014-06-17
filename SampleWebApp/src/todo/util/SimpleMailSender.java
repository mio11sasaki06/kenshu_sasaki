package todo.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.Store;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;



public class SimpleMailSender {
	
	private static Logger log = Logger.getLogger(SimpleMailSender.class.getName());
	private final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private final String SMTP_PORT = "465";

	private final String AUTH_USER_NAME = "mio.s.yfm@gmail.com";
	private final String AUTH_PASSWORD = "yfm_manabu11";

	private static final String SMTP_HOST = "smtp.gmail.com";

	public static void main(String argv[]) throws Exception{
		SimpleMailSender mail = new SimpleMailSender();

		mail.sendMessage("ToAddress@gmail.com", "FromAddress@example.com", "Name", "件名", "メッセージ本文です");
	}
	public void sendMessage(String toAddr, String fromAddr, String personName, String subject, String message) throws Exception {
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST);
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.host", SMTP_HOST);
		props.put("mail.from", fromAddr);

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);

		props.put("mail.smtp.socketFactory.fallback", String.valueOf( false ));

        Session session = Session.getDefaultInstance(props,new Authenticator() {
        	protected PasswordAuthentication getPasswordAuthentication(){
        		return ( new PasswordAuthentication ( AUTH_USER_NAME, AUTH_PASSWORD));
        	}
        });
        session.setDebug(true);
        MimeMessage mimeMsg = new MimeMessage(session);
        mimeMsg.setRecipients(Message.RecipientType.TO, toAddr);
        InternetAddress fromHeader = new InternetAddress(fromAddr, personName);
        mimeMsg.setFrom(fromHeader);
        mimeMsg.setSubject(subject, "ISO-2022-JP");
        mimeMsg.setSentDate(new Date());
        mimeMsg.setText(message, "ISO-2022-JP");
        Transport.send(mimeMsg);
        	}

        }

