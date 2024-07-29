package com.ideasoft.page;

import com.ideasoft.contracts.ILogin;
import com.ideasoft.util.BasePageUtil;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePageUtil implements ILogin {

    public By userMenu = By.className("user-menu");
    public By sigupMessage = By.xpath("//*[@class='user-login-page-title user-login-page-sub-title']");
    public By signupButton = By.xpath("//*[@class='btn btn-secondary btn-block']");
    public By firstname = By.id("firstname");
    public By surname = By.id("surname");
    public By email = By.id("email");
    public By pass = By.id("s_pass");
    public By gender = By.xpath("//input[@id='gender-unspecified']/following-sibling::label");
    public By phone = By.id("cell");
    public By signupAgreement = By.xpath("(//*[@class='checkbox-custom'])[2]");
    public By signupPersonalDataAgreement = By.cssSelector(".form-group.row.signup-personal-data-agreement");
    public By recaptcha = By.id("recaptcha-anchor");
    public By saveButton = By.xpath("//button[(text()='Kaydet')]");
    public By newMemberTitle = By.xpath("//h4[(text()='Yeni Üyelik')]");
    public By signinTitle = By.xpath("//*[@class='user-login-page-title']//span[text()='Giriş Yap']");
    public By closeButton = By.className("fancybox-close-small");
    public By loginEmail = By.id("user-login-email");
    public By loginPass = By.id("user-login-pass");
    public By submitButton = By.xpath("//button[text()='Giriş Yap']");
    public By accountMenu = By.xpath("//*[@class='user-menu']//span[text()='Hesabım']");

    @Override
    public void clickUserMenu() {
        clickElement(userMenu);
    }

    @Override
    public void checkSignUpMessage() {
        thread(2000);
        Assert.assertTrue("Henüz üye değil misiniz metni görüntülenmemiştir!",isElementDisplayed(sigupMessage));
    }

    @Override
    public void clickSignUpButton() {
        clickElement(signupButton);
    }

    @Override
    public void checkNewMemberMessage() {
        Assert.assertTrue("Yeni üyelik metni görüntülenmemiştir!",isElementDisplayed(newMemberTitle));
    }

    @Override
    public void setMembershipInformation(String fname, String sname, String mail, String password, String cell) {
        sendKeys(firstname,fname);
        sendKeys(surname,sname);
        sendKeys(email,mail);
        sendKeys(pass,password);
        sendKeys(phone,cell);
        clickElement(gender);
    }

    @Override
    public void clickAgreement() {
        clickElement(signupAgreement);
        PageScrolldown();
        clickElement(signupPersonalDataAgreement);
        clickElement(closeButton);
        clickElement(recaptcha);
    }

    @Override
    public void clickSaveButton() {
        clickElement(saveButton);
    }

    @Override
    public void checkSigninTitle() {
        Assert.assertTrue("Giriş yap metni görüntülenmedi!",isElementDisplayed(signinTitle));
    }

    @Override
    public void setEmailPassword(String mail, String password) {
        sendKeys(loginEmail,mail);
        sendKeys(loginPass,password);
    }

    @Override
    public void clickLoginButton() {
        clickElement(submitButton);
    }

    @Override
    public void checkSuccessLogin() {
        Assert.assertTrue("Başarılı üye girişi yapılamamıştır!!!",isElementDisplayed(accountMenu));
    }
}
