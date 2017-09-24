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
			String host = "smtp.126.com";//要跟自己的邮箱匹配，比如QQ邮箱smtp.qq.com;126邮箱smtp.126.com;
			String user="********";//发送邮件的邮箱名
			String password="*******";//密码
			String from = "*******";//发送邮件的邮箱名
			String to = "*******";//接收邮件的邮箱名
			String fileAttachment = "***********";//附件地址

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
			message.setSubject("紧急通知");//此处设置邮件标题

			// create the message part 
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			
			//显示附件图片到正文
			messageBodyPart.setDataHandler(new DataHandler(new FileDataSource(fileAttachment)));
			// 为这个图片设置一个id，在正文中可以通过cid:xxx来访问
			messageBodyPart.setContentID("mypicture");
			MimeBodyPart htmlBody = new MimeBodyPart();
            htmlBody.setContent("<h1>测试一下</h1><img src='cid:mypicture'/>", "text/html;charset=utf-8");

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
