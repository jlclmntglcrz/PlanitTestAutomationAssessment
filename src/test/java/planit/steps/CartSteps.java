package planit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import planit.pages.CartPage;

import java.util.List;
import java.util.Map;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("I verify the subtotal for each product")
    public void verifyProductSubtotal(DataTable dataTable) {
        List<Map<String, String>> productMap = dataTable.asMaps(String.class, String.class);
        cartPage.verifyProductSubtotal(productMap.get(0));
    }

    @Then("I verify the price for each product")
    public void verifyProductPrice(DataTable dataTable) {
        List<Map<String, String>> productMap = dataTable.asMaps(String.class, String.class);
        cartPage.verifyProductPrice(productMap.get(0));
    }

    @Then("I verify that total = {string}")
    public void verifyTotalPrice(String expectedTotal) {
        cartPage.verifyTotal(expectedTotal);
    }
}
