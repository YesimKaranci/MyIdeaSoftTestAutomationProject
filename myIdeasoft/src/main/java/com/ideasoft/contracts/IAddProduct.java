package com.ideasoft.contracts;

public interface IAddProduct {

    void checkHomePage();

    void setProductName(String productName);

    void clickSearchButton();

    void checkProductList(String productName);

    void addProductToCart(String quantity);

    void checkSuccessMessage(String message);

    void checkExpectedQuantity(String expectedQuantity);

    void clickCartMenu();
}
