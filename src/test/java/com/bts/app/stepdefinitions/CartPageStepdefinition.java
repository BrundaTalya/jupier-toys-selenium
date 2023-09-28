package com.bts.app.stepdefinitions;

import com.bts.app.helper.DriverHelper;
import com.bts.app.pages.CartPage;
import com.bts.app.pages.HomePage;
import com.bts.app.pages.ShopPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CartPageStepdefinition {

    private HomePage homePage = new HomePage(DriverHelper.getDriver());
    private ShopPage shopPage;
    private CartPage cartPage;

    Map<String, Object> productInfo;

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        homePage.navigateToHomePage();
    }

    @Then("navigate to shop page")
    public void navigate_to_shop_page(){
        shopPage = homePage.clickOnShopPage();
    }

    @When("user adds the following products to the cart")
    public void user_adds_the_following_products_to_the_cart(DataTable dataTable){
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);

        for(Map<String, String> product : products){
            String productName = product.get("Product");
            int quantity = Integer.parseInt(product.get("Quantity"));
            productInfo = shopPage.addToCart(productName, quantity);
        }
    }

    @Then("navigate to cart page")
    public void navigate_to_cart_page() {
        cartPage = shopPage.clickOnCartPage();
    }

    @Then("subtotals for all the products added should be calculated correctly")
    public void subtotals_for_all_the_products_added_should_be_calculated_correctly(){
        cartPage.calculateSubtotalForEachProduct();
    }

    @And("total should be equal to the sum of subtotals")
    public void total_should_be_equal_to_the_sum_of_subtotals(){
        cartPage.calculateTotalAndSubtotalAmount();
    }




}
