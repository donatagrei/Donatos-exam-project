package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[placeholder=\"Username\"]")
    private WebElement usernameInput;

    @FindBy (css = "[placeholder=\"Password\"]")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[text()=' Login ']")
    private WebElement loginButton;


    public void login(){
        usernameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");
        loginButton.click();
    }

    // ar teisinga ir logiska butu sia funkcija deti i basePage, kad ji butu pasiekiama is bet kurio page'o?
    public void clickSidePanel(String buttonText){
        driver.findElement(By.xpath("//span[text()=\"" + buttonText + "\"]")).click();
    }



}


