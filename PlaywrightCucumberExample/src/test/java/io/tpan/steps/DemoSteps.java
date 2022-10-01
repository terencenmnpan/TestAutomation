package io.tpan.steps;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.tpan.pages.DemoPage;
import org.junit.jupiter.api.Assertions;

public class DemoSteps {
    private final TestContext testContext;
    private final Browser browser;

    private BrowserContext browserContext;

    private Page page;

    public DemoSteps(TestContext testContext) {
        this.testContext = testContext;
        this.browser = testContext.getBrowser();
    }

    @Before
    public void createContextAndPage(){
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @After
    public void closeContext(){
        browserContext.close();
    }

    @Given("User navigates to PHPTRAVELS Demo Page")
    public void userNavigatesToPHPTRAVELSDemoPage() {
        DemoPage demoPage = new DemoPage(page);
        demoPage.navigate();
    }

    @When("User fills in Demo Request Form {string}, {string}, {string}, {string}")
    public void userFillsInDemoRequestForm(String firstName, String lastName, String businessName, String email) {
        DemoPage demoPage = new DemoPage(page);
        demoPage.fillRegistrationInfo(firstName, lastName, businessName, email);
    }

    @Then("Verify thank you text")
    public void verifyThis() {
        Locator thankYouText = page.locator("text=' Thank you!'");
        thankYouText.waitFor();
        Locator completionText = page.locator("text='We have sent your demo credentials to your email please check your email to test demo website. if message not found inbox please check spam folder'");
        Assertions.assertTrue(completionText.isVisible());
    }

    @When("User calculates and fills result")
    public void userCalculatesAndFillsResult() {
        DemoPage demoPage = new DemoPage(page);
        demoPage.fillResult();
    }

    @When("User calculates and fills wrong result")
    public void userCalculatesAndFillsWrongResult() {
        DemoPage demoPage = new DemoPage(page);
        demoPage.fillWrongResult();
    }

    @When("User clicks submit")
    public void userClicksSubmit() {
        DemoPage demoPage = new DemoPage(page);
        String alertText = demoPage.clickSubmit();
        testContext.setAlertText(alertText);
    }

    @Then("Verify alert {string}")
    public void verifyAlertToFillInResultIsShown(String alertText) {
        Assertions.assertEquals(alertText, testContext.getAlertText());
    }
}
