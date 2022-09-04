package autotest.paymentOnCredit;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PurchaseForm;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;
import static data.DataHelper.getCardCvcSymbols;

public class CvcCheckOnCredit {
    private PurchaseForm purchaseForm = new PurchaseForm();
    private MainPage mainPage = new MainPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void shouldOpen() {
        String sutUrl = System.getProperty("sut.url");
        open(sutUrl);
    }

    @BeforeEach
    public void clickBuy() {
        mainPage.clickBuyOnCredit();
    }

    @Test
    public void checkOnCreditCardCvcEmptyField() {
        val cardInfo = getCardCvcEmptyField();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardCvcZeros() {
        val cardInfo = getCardCvcZeros();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardCvcOneDigit() {
        val cardInfo = getCardCvcOneDigit();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardCvcTwoDigit() {
        val cardInfo = getCardCvcTwoDigit();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardCvcLetters() {
        val cardInfo = getCardCvcLetters();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardCvcSymbols() {
        val cardInfo = getCardCvcSymbols();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }
}
