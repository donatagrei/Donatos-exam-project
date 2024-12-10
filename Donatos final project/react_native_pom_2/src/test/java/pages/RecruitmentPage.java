package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class RecruitmentPage extends BasePage{

    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()=\" Add \"]")
    private WebElement addButton;

    @FindBy(xpath = "//button[text()=\" Save \"]")
    private WebElement saveButton;

    @FindBy(css = ".oxd-input-field-error-message")
    private List<WebElement> errorMessageList;

    @FindBy(xpath = "//button[text()=\" Cancel \"]")
    private WebElement cancelButton;

    @FindBy(xpath = "//*[text()=\"Expected format: admin@example.com\"]")
    private WebElement wrongEmailFormatErrorMessage;

    @FindBy(css = "[name=\"firstName\"]")
    private WebElement firstNameInput;

    @FindBy(css = "[name=\"lastName\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//*[contains(@placeholder,\"Enter comma seperated words...\")]")
    private WebElement keywordsInput;

    @FindBy(css = "input.oxd-input")
    private WebElement dateSelectionInput;

    @FindBy(xpath = "//textarea[contains(@placeholder,\"Type here\")]")
    private  WebElement notesField;

    public void clickAddButton() {
        addButton.click();
    }

    public boolean isCurrentURLContains(String partOfURL) {
        String currentURL = driver.getCurrentUrl();
        return currentURL.contains(partOfURL);
    }

    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public List<String> getErrorMessagesList() {
        return errorMessageList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void typeEmail(String email){
        driver.findElements(By.xpath("//input[contains(@placeholder,\"Type here\")]")).get(0).sendKeys(email);
    }

    public String getEmailErrorMessageText() {
        return wrongEmailFormatErrorMessage.getText();
    }

    public void typeFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void typeLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void typePhoneNumber(String phoneNo){
        driver.findElements(By.xpath("//input[contains(@placeholder,\"Type here\")]")).get(1).sendKeys(phoneNo);
    }

    public void typeKeywords(String keywords){
        keywordsInput.sendKeys(keywords);
    }

    public void typeDateOfToday(String date){
        dateSelectionInput.clear();
        dateSelectionInput.sendKeys(date);
    }

    public void typeNotes(String note){
        notesField.sendKeys(note);
    }




}
