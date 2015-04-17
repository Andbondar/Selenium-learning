package HomeWork03;

import MailRu.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static InputProcessing.TextParser.getTextFromTXTFile;
import static InputProcessing.XMLParser.getInfoByTag;

/**
 * Created by bondar on 4/17/2015.
 */
public class MailRuTests extends MailRu.PageInstance{
    String login, password, textMessage;

    @Before
    public void setUp(){
        setBrowser("FF");
        startPage = new StartPage(driver);
        login = String.valueOf(getInfoByTag("D:\\config_mailru.xml", "login").get(0));
        password = String.valueOf(getInfoByTag("D:\\config_mailru.xml", "pass").get(0));

        try{
            textMessage = getTextFromTXTFile("D:\\read.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
        //combine all the text into solid string
        textMessage = textMessage.replace("\n", "<br>").replace("\r", "<br>").replace("<br><br>", "<br>");
    }

    @Test
    public void sendReceiveEmail(){
        startPage.open();
        emailPage = startPage.loginToMail(login, password);
        int initialMailCount = emailPage.getCurrentUnreadCount();
        writeLetter = emailPage.writeLetter();

        writeLetter.addReceiver(login + "@mail.ru");
        writeLetter.addSubject("New test letter");
        writeLetter.addText(textMessage);
        emailPage = writeLetter.sendLetter();

        int updatedMailCount = emailPage.getCurrentUnreadCount();
        Assert.assertTrue("Mail count was not changed. New letter was not received.", updatedMailCount > initialMailCount);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
