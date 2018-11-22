package webpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //URL
    private static String PAGE_URL = "https://www.wrike.com/";

    //Locators

    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div[2]/div/div/div[2]/div/form/button")
    private WebElement btnFreeTrial;
    @FindBy(xpath = "/html/body/div[4]/div/form/label[2]/button")
    private WebElement btnCreateAcc;
    @FindBy(xpath = "/html/body/div[4]/div/form/label[1]/input")
    private WebElement email;

    //Constuctor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver,this);
    }

    public void clickTrialBtn(){
        this.btnFreeTrial.click();
    }

    public void enterEmail(String email){
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void clickCreatebtn(){
        this.btnCreateAcc.click();
    }

}
