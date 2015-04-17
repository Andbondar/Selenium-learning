package HomeWork03;

import MailRu.StartPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bondar on 4/17/2015.
 */
public class MailRuTests extends MailRu.PageInstance{
    @Before
    public void setUp(){
        setBrowser("FF");
        startPage = new StartPage(driver);
    }

    @Test
    public void sendReceiveEmail(){
        startPage.open();
        emailPage = startPage.loginToMail("seleniumlearning", "SeleniumLearning!23");
        int initialMailCount = emailPage.getCurrentUnreadCount();
        writeLetter = emailPage.writeLetter();

        writeLetter.addReceiver("seleniumlearning@mail.ru");
        writeLetter.addSubject("New test letter");
        writeLetter.addText("Sample text");
        emailPage = writeLetter.sendLetter();

        int updatedMailCount = emailPage.getCurrentUnreadCount();
        Assert.assertTrue("Mail count was not changed. New letter was not received.", updatedMailCount > initialMailCount);
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
