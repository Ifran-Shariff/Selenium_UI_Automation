package StepDefinitions;

import java.io.File;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class BulkEmailSender {

    public static void main(String[] args) {
        final String senderEmail = "ifranshariff1998@gmail.com";
        final String senderPassword = "rdnc qxpx wulz gpox"; // Use App Password if 2FA is enabled
        final String resumePath = "C:/Ifran/Resume/IfranShariff_Resume.pdf"; // Update with your actual resume path
        File file = new File("C:/Ifran/Resume/IfranShariff_Resume.pdf");
        System.out.println("Exists: " + file.exists());
        List<String> recipients = Arrays.asList(
                "ifranshariff1998@gmail.com",
                "swtestingstudio@gmail.com","pratima@truenorthinfotek.com","sudhanshu.mishra@truelancer.com","neha@kernernorland.com","shobha@ambiencehr.com","gokulkesavan@virtusa.com","r.a.shivakumar@capgemini.com","khushboo@aliqan.com","purva@hrc-globalservices.com","mpreethika@teksystems.com"
        );

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        for (String recipient : recipients) {
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(senderEmail));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                message.setSubject("QA Engineer – Ifran Shariff – Bangalore – 6 Years – Serving Notice Period\n");

                // Text body part
                MimeBodyPart textPart = new MimeBodyPart();
                textPart.setText("Hi,\n" +"\n"+ "Got to know that you are hiring. I am looking for an Automation Tester or any Software QA related positions.\n" +
                                "\n" +
                                "Below are my details,\n" +
                                "• Current Role: Quality Engineering Analyst\n" +
                                "• Current Location: Bangalore\n" +
                                "• Experience: 6 Yrs\n" +
                                "• Skills: UI Automation, API Automation, Mobile application testing, Database testing, System Integration Testing, Regression Testing, Functional Testing, CI/CD, STLC, SDLC, testing methodologies, Verbal and Written communication\n" +
                                "• Tools: Selenium, cucumber, Testng, Karate, Rest Assured, Perfecto, Appium, Android Studio, MySQL, Jenkins, GIT, Postman, JIRA, Rally, confluence, Qtest\n" +
                                "• Certifications: SDET fullstack\n" +
                                "• Current CTC:  6.5 LPA INR\n" +
                                "\n" +
                                "Attached is my resume for reference. \n" +
                                "\n" +
                                "Please let me know if there is any job opportunity available and please feel free to share my profile with your colleagues. Do let me know in case you need any further information.\n"+"\n"+"Thanks & regards,\n"+"Ifran Shariff\n"+"Contact No -   919035452055\n"
                );

                        // Attachment body part
                MimeBodyPart attachmentPart = new MimeBodyPart();
                DataSource source = new FileDataSource(resumePath);
                attachmentPart.setDataHandler(new DataHandler(source));
                attachmentPart.setFileName("IfranResume.pdf");

                // Combine parts
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

                message.setContent(multipart);

                Transport.send(message);
                System.out.println("Email with resume sent to: " + recipient);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}