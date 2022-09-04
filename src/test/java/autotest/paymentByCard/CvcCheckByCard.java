package autotest.paymentByCard;

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

public class CvcCheckByCard {
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
        mainPage.clickBuy();
    }

    @Test
    public void checkByCardCvcEmptyField() {
        val cardInfo = getCardCvcEmptyField();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardCvcZeros() {
        val cardInfo = getCardCvcZeros();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkByCardCvcOneDigit() {
        val cardInfo = getCardCvcOneDigit();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkByCardCvcTwoDigit() {
        val cardInfo = getCardCvcTwoDigit();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkByCardCvcLetters() {
        val cardInfo = getCardCvcLetters();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardCvcSymbols() {
        val cardInfo = getCardCvcSymbols();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }
}
