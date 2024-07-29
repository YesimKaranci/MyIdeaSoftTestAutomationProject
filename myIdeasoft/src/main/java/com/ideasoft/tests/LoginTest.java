package com.ideasoft.tests;

import com.ideasoft.contracts.ILogin;
import com.ideasoft.page.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

    public ILogin login = new LoginPage();

    @When("Giriş Yap menüsüne tıklanır")
    public void girişYapMenüsüneTıklanır() {
        login.clickUserMenu();
    }

    @Then("Henüz üye değil misiniz metni kontrol edilir")
    public void henüzÜyeDeğilMisinizMetniKontrolEdilir() {
        login.checkSignUpMessage();
    }

    @And("Hemen Üye Ol butonuna tıklanır")
    public void hemenÜyeOlButonunaTıklanır() {
        login.clickSignUpButton();
    }

    @Then("Yeni üyelik sayfasına gidildiği kontrol edilir")
    public void yeniÜyelikSayfasınaGidildiğiKontrolEdilir() {
        login.checkNewMemberMessage();
    }

    @When("İlgili alanlara {string} {string} {string} {string} {string} üyelik bilgileri girilir")
    public void üyelikBilgileriGirilir(String firstname, String surname, String email, String pass, String phone) {
        login.setMembershipInformation(firstname,surname,email,pass,phone);
    }

    @And("Sözleşmeler ve captcha onaylanır")
    public void sözleşmelerVeCaptchaOnaylanır() {
        login.clickAgreement();
    }

    @And("Kaydet butonuna tıklanır")
    public void kaydetButonunaTıklanır() {
        login.clickSaveButton();
    }

    @Then("Giriş yap metni kontrol edilir")
    public void girişYapMetniKontrolEdilir() {
        login.checkSigninTitle();
    }

    @When("İlgili alanlara {string} {string} üyelik bilgileri girilir")
    public void ilgiliAlanlaraÜyelikBilgileriGirilir(String mail, String password) {
        login.setEmailPassword(mail,password);
    }

    @And("Giriş yap butonuna tıklanır")
    public void girişYapButonunaTıklanır() {
        login.clickLoginButton();
    }

    @Then("Başarılı üye girişi yapıldığı kontrol edilir")
    public void başarılıÜyeGirişiYapıldığıKontrolEdilir() {
        login.checkSuccessLogin();
    }
}
