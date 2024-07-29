package com.ideasoft.contracts;

public interface ILogin {
    void clickUserMenu();

    void checkSignUpMessage();

    void clickSignUpButton();

    void checkNewMemberMessage();

    void setMembershipInformation(String firstname, String surname, String email, String pass, String phone);

    void clickAgreement();

    void clickSaveButton();

    void checkSigninTitle();

    void setEmailPassword(String mail, String password);

    void clickLoginButton();

    void checkSuccessLogin();
}
