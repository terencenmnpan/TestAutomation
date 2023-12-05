package io.tpan.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.tpan.steps.TestContext;

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
        this.email = page.locator("[name='email'][placeholder='Email']");
        this.submit = page.locator("id=demo");
        this.result = page.locator("id=number");
        this.numberOne = page.locator("id=numb1");
        this.numberTwo = page.locator("id=numb2");
    }

    public void navigate(){
        page.navigate("https://phptravels.com/demo");
    }

    public void fillRegistrationInfo(String firstName, String lastName, String businessName, String email){
        this.firstName.fill(firstName);
        this.lastName.fill(lastName);
        this.businessName.fill(businessName);
        this.email.fill(email);
    }

    public void fillResult(){
        int num1 = Integer.parseInt(numberOne.textContent());
        int num2 = Integer.parseInt(numberTwo.textContent());
        result.fill(String.valueOf(num1 + num2));
    }

    public void fillWrongResult(){
        int num1 = Integer.parseInt(numberOne.textContent());
        int num2 = Integer.parseInt(numberTwo.textContent());
        result.fill(String.valueOf(num1 + num2 + 1));
    }


    public String clickSubmit(){
        final String[] message = new String[1];
        page.onDialog(dialog -> {
            message[0] = dialog.message();
            dialog.accept();
        });
        submit.click();
        return message[0];
    }
}
