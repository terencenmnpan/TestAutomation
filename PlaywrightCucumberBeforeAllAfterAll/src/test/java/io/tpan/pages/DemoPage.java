package io.tpan.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class DemoPage {

    private final Page page;

    private final Locator firstName;

    private final Locator lastName;

    private final Locator businessName;

    private final Locator email;

    private final Locator submit;

    private final Locator result;

    private final Locator numberOne;

    private final Locator numberTwo;

    public DemoPage(Page page) {
        this.page = page;
        this.firstName = page.locator("[name='first_name']");
        this.lastName = page.locator("[name='last_name']");
        this.businessName = page.locator("[name='business_name']");
        this.email = page.locator("[name='email']");
        this.submit = page.locator("id=demo");
        this.result = page.locator("id=number");
        this.numberOne = page.locator("id=numb1");
        this.numberTwo = page.locator("id=numb2");
    }

    public void navigate(){
        page.navigate("https://phptravels.com/demo");
    }

    public void fillRegistrationInfo(String firstName, String lastName, String businessName, String email){
        int num1 = Integer.parseInt(numberOne.textContent());
        int num2 = Integer.parseInt(numberTwo.textContent());
        this.firstName.fill(firstName);
        this.lastName.fill(lastName);
        this.businessName.fill(businessName);
        this.email.fill(email);
        result.fill(String.valueOf(num1 + num2));
        submit.click();
    }

    public void waitForRequestDone(){
        System.out.println(1);
        //Locator page.locator().waitFor();
    }
}
