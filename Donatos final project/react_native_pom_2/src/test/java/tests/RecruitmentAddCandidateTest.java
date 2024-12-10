package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.RecruitmentPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecruitmentAddCandidateTest extends BaseTest {

    @Test
    public void addButtonTest() {
        BasePage basePage = new BasePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        basePage.login();
        basePage.clickSidePanel("Recruitment");
        recruitmentPage.clickAddButton();
        Assertions.assertTrue(recruitmentPage.isCurrentURLContains("recruitment/addCandidate"));
    }


    @Test
    public void emptyFieldsTest() {
        BasePage basePage = new BasePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        basePage.login();
        basePage.clickSidePanel("Recruitment");
        recruitmentPage.clickAddButton();
        recruitmentPage.scrollTo(driver.findElement(By.xpath("//button[text()=\" Save \"]")));
        recruitmentPage.clickSaveButton();

        List<String> actualErrorMessages = recruitmentPage.getErrorMessagesList();
        assertThat(actualErrorMessages).allSatisfy(item -> assertThat(item).contains("Required"));
    }

    @Test
    public void cancelButtonTest() {
        BasePage basePage = new BasePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        basePage.login();
        basePage.clickSidePanel("Recruitment");
        recruitmentPage.clickAddButton();
        recruitmentPage.scrollTo(driver.findElement(By.xpath("//button[text()=\" Cancel \"]")));
        recruitmentPage.clickCancelButton();
        Assertions.assertTrue(recruitmentPage.isCurrentURLContains("/web/index.php/recruitment/viewCandidates"));
    }

    @Test
    public void emailFormatValidationTest() {
        BasePage basePage = new BasePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        basePage.login();
        basePage.clickSidePanel("Recruitment");
        recruitmentPage.clickAddButton();
        recruitmentPage.typeEmail("donataemail.lt");
        recruitmentPage.clickSaveButton();
        Assertions.assertEquals("Expected format: admin@example.com", recruitmentPage.getEmailErrorMessageText());
    }

    // 5-as acceptance criteria, testas nebaigtas
    @Test
    public void savingCandidateInformationTest() {
        BasePage basePage = new BasePage(driver);
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        basePage.login();
        basePage.clickSidePanel("Recruitment");
        recruitmentPage.clickAddButton();
        recruitmentPage.typeFirstName("Donata");
        recruitmentPage.typeLastName("Grei");
        recruitmentPage.typeEmail("donaciuke@gmail.com");
        recruitmentPage.typePhoneNumber("+37067261105");
        recruitmentPage.scrollTo(driver.findElement(By.xpath("//button[text()=\" Cancel \"]")));
        recruitmentPage.typeKeywords("QA engineering");
        recruitmentPage.typeDateOfToday("2024-01-12");
        recruitmentPage.typeNotes("A really good QA engineer");
        recruitmentPage.clickSaveButton();

    }


}
