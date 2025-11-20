package StepDefinitions;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
public class  EmailAutomation {

    public static void main(String[] args) {
        final String senderEmail = "ifranshariff1998@gmail.com";
        final String senderPassword = "rdnc qxpx wulz gpox"; // Use App Password if 2FA is enabled

        List<String> recipients = Arrays.asList(
                "ifranshariff1998@gmail.com"
        );

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

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
                message.setSubject("Personalized Bulk Email");
                message.setText("Hi,\n" +"\n"+ "Got to know that you are hiring. I am looking for an Automation Tester or any Software QA related positions.\n" +
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

                Transport.send(message);
                System.out.println("Email sent to: " + recipient);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}