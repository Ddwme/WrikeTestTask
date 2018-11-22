package tests;

import net.bytebuddy.utility.RandomString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import webpages.HomePage;
import webpages.QuestionPage;

import java.util.concurrent.TimeUnit;

public class WrikeTest {
    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver","D:\\Programs\\geckodriver-v0.23.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void writeTest(){
        try {
             HomePage home = new HomePage(driver);
            home.clickTrialBtn();
            String random = Res.RandomString.generate(5);
            home.enterEmail(random+"+wpt@wriketask.qaa");
            home.clickCreatebtn();
            QuestionPage questionPage = new QuestionPage(driver);
            Thread.sleep(5000);
            Assert.assertTrue(questionPage.isPageOpened());
            //Switch to pupup window to close it
            driver.switchTo().frame(1);
            WebElement closeBtn = driver.findElement(By.xpath("/html/body/c-wiz/div/div/div[2]/div[4]/span[2]/div/content/span"));
            closeBtn.click();
            driver.switchTo().parentFrame();
            Thread.sleep(5000);
            questionPage.chooseItem();
            Thread.sleep(5000);
            Assert.assertTrue(questionPage.isAnswersSubmitted());
            questionPage.clickResend();
            Thread.sleep(5000);
            Assert.assertTrue(questionPage.isMailResend());
            Thread.sleep(5000);
            Assert.assertTrue(questionPage.isRightLink());
         } catch (Exception ex) {
                ex.printStackTrace();
        }
    }

}
