package com.ideasoft.tests;

import com.ideasoft.contracts.IAddProduct;
import com.ideasoft.page.AddProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProdutsTest {

    public IAddProduct addProduct = new AddProductsPage();

    @Given("Ideasoft web sitesine gidilir")
    public void ıdeasoftWebSitesineGidilir() {
        addProduct.checkHomePage();
    }

    @When("Arama alanına {string} yazılır")
    public void aramaAlanınaYazılır(String productName) {
        addProduct.setProductName(productName);
    }

    @And("Arama butonuna tıklanır")
    public void aramaButonunaTıklanır() {
        addProduct.clickSearchButton();
    }

    @Then("{string} ürününün listelendiği kontrol edilir")
    public void ürünününListelendiğiKontrolEdilir(String productName) {
        addProduct.checkProductList(productName);
    }

    @And("{string} yazısının görünmesi kontrol edilir")
    public void yazısınınGörünmesiKontrolEdilir(String message) {
        addProduct.checkSuccessMessage(message);
    }

    @And("Listelenen üründen {string} adet sepete eklenir")
    public void listelenenÜründenQuantityAdetSepeteEklenir(String quantity) {
        addProduct.addProductToCart(quantity);
    }

    @Then("Sepet içeriğinde ilgili üründen {string} olduğu kontrol edilir")
    public void sepetIçeriğindeIlgiliÜründenQuantityOlduğuKontrolEdilir(String expectedQuantity) {
        addProduct.checkExpectedQuantity(expectedQuantity);
    }

    @And("Sepet menüsüne tıklanır")
    public void sepetMenüsüneTıklanır() {
        addProduct.clickCartMenu();
    }
}
