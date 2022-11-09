package planit.steps;

import io.cucumber.java.en.Then;
import planit.pages.ContactPage;

public class ContactSteps {

    private ContactPage contactPage = new ContactPage();


    @Then("validate successful submission message")
    public void validateSuccessfulSubmissionMessage() {
        contactPage.validateSuccessfulSubmission();
    }
}
