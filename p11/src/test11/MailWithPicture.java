package test11;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailWithPicture {
	public static void main (String args[]) 
			throws Exception {
			String host = "smtp.126.com";//Ҫ���Լ�������ƥ�䣬����QQ����smtp.qq.com;126����smtp.126.com;
			String user="********";//�����ʼ���������
			String password="*******";//����
			String from = "*******";//�����ʼ���������
			String to = "*******";//�����ʼ���������
			String fileAttachment = "***********";//������ַ

			// Get system properties
			Properties props = System.getProperties();

			// Setup mail server
			props.put("mail.smtp.host", host);

			// Get session
			Session session = 
			Session.getInstance(props, null);

			// Define message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from)); 


			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("����֪ͨ");//�˴������ʼ�����

			// create the message part 
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			//��ʾ����ͼƬ������
			messageBodyPart.setDataHandler(new DataHandler(new FileDataSource(fileAttachment)));
			// Ϊ���ͼƬ����һ��id���������п���ͨ��cid:xxx������
			messageBodyPart.setContentID("mypicture");
			MimeBodyPart htmlBody = new MimeBodyPart();
            htmlBody.setContent("<h1>����һ��</h1><img src='cid:mypicture'/>", "text/html;charset=utf-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(htmlBody);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(fileAttachment);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("mypicture.jpg");
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);

			// Send the message
			Transport transport = session.getTransport("smtp");
            transport.connect(host, user, password);
            transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            //transport.send(message);
            transport.close();
	}

}
