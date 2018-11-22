package webpages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class QuestionPage {
    private WebDriver driver;

    //Locators

    @FindBy(tagName = "h3")
    private WebElement header;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/div/h3")
    private WebElement header2;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[1]/span")
    private WebElement word;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[1]/button")
    private WebElement btnInterest1;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[1]/label[2]/button")
    private WebElement btnInterest2;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[1]/button")
    private WebElement btnMemberOpt1;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[2]/button")
    private WebElement btnMemberOpt2;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[3]/button")
    private WebElement btnMemberOpt3;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[4]/button")
    private WebElement btnMemberOpt4;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[2]/label[5]/button")
    private WebElement btnMemberOpt5;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[1]/button")
    private WebElement btnYes;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/div[3]/label[2]/button")
    private WebElement btnNo;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[2]/div/form/button")
    private WebElement btnSubmit;
    @FindBy(xpath = "/html/body/div[1]/main/div/div/div[2]/div/div[1]/p[3]/button")
    private WebElement btnResend;
    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div[1]/div/ul/li[1]/a")
    private WebElement twitterLink;

    //Constructor
    public QuestionPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean isPageOpened(){
        return header.getText().contains("Help us provide you the best possible experience:");
    }

    public boolean isAnswersSubmitted(){
        return header2.getText().contains("Thanks for helping us out!");
    }

    public void chooseItem(){
        WebElement[] array = new WebElement[] {btnInterest1, btnInterest2};
        WebElement[] array2 = new WebElement[] {btnMemberOpt1, btnMemberOpt2,btnMemberOpt3,btnMemberOpt4,btnMemberOpt5};
        WebElement[] array3 = new WebElement[] {btnYes, btnNo};
        int rdn = (int) (Math.random());
        int rdn2 = (int) (Math.random()*5);
        array[rdn].click();
        array2[rdn2].click();
        array3[rdn].click();
        btnSubmit.click();
    }

    public void clickResend(){
        btnResend.click();
    }

    public boolean isMailResend(){
        return word.getText().contains("again");
    }

    public  boolean isRightLink(){
        return twitterLink.getAttribute("href").contains("https://twitter.com/wrike");
    }


}
