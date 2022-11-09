package planit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import planit.pages.ShopPage;

import java.util.List;
import java.util.Map;

public class ShopSteps {

    private ShopPage shopPage = new ShopPage();


    @And("I buy the following toys")
    public void buyToys(DataTable dataTable) {
        List<Map<String, String>> toysMap = dataTable.asMaps(String.class, String.class);
        shopPage.buyToys(toysMap.get(0));
    }


}
