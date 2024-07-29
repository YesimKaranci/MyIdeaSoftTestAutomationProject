package com.ideasoft.page;

import com.ideasoft.contracts.IAddProduct;
import com.ideasoft.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AddProductsPage extends BasePageUtil implements IAddProduct {

    public By userMenu = By.className("user-menu");
    public By favourite = By.className("header-favourite");
    public By cartMenu = By.className("cart-menu");
    public By search = By.className("auto-complete");
    public By searchButton = By.xpath("//*[@class='search']//button");
    public By detailSearch = By.className("contentbox-header");
    public By productDetailTitle = By.className("showcase-title");
    public By productImage = By.xpath("//*[@class='showcase-image showcase-image-vertical']//a");
    public By productQuantity = By.id("qty-input");
    public By getProductQuantityList = By.xpath("//select[@id='qty-input']//option");
    public By addCartButton = By.className("add-to-cart-button");
    public By successMessage = By.className("shopping-information-cart-inside");
    public By cartDetail = By.xpath("//h4[(text()='SEPET DETAYI')]");
    public By cartDetailQuantity = By.xpath("//*[@class='cart-item-quantity']//input[@class='form-control']");

    @Override
    public void checkHomePage() {
        Assert.assertTrue("Profil menüsü görütülenmedi!!!",isElementDisplayed(userMenu));
        Assert.assertTrue("Favorilerim görüntülenmedi!!",isElementDisplayed(favourite));
        Assert.assertTrue("Sepet görüntülenmedi!!",isElementDisplayed(cartMenu));
        Assert.assertTrue("Arama alanı görüntülenmedi!!",isElementDisplayed(search));
    }

    @Override
    public void setProductName(String productName) {
        sendKeys(search,productName);

    }

    @Override
    public void clickSearchButton() {
        clickElement(searchButton);
    }

    @Override
    public void checkProductList(String productName) {
        String productDetailText = getText(productDetailTitle);
        Assert.assertTrue("Detaylı arama metni görüntülenmedi!!!",isElementDisplayed(detailSearch));
        Assert.assertEquals("Aranılan ürün listelenmemiştir!!!",productDetailText,productName);
    }

    @Override
    public void addProductToCart(String quantity) {
        PageScrolldown();
        Assert.assertTrue("ürüne gidilemedi!",isEnabled(productImage));
        clickElement(productImage);
        clickElement(productQuantity);
        clickElementOnList(getProductQuantityList,Integer.parseInt(quantity)-1);
        clickElement(addCartButton);
    }

    @Override
    public void checkSuccessMessage(String message) {
        Assert.assertEquals("Sepete başarılı ürün eklenmiştir mesajı görüntülenmedi!!!",message,getText(successMessage));
    }

    @Override
    public void checkExpectedQuantity(String expectedQuantity) {
        Assert.assertTrue("Sepet detayı görüntülenmemiştir!!!",isElementDisplayed(cartDetail));
        Assert.assertEquals("Sepet içeriği uyuşmamaktadır!!!",expectedQuantity,getAttribute(cartDetailQuantity,"value"));
    }

    @Override
    public void clickCartMenu() {
        thread(3000);
        clickElement(cartMenu);
    }
}
