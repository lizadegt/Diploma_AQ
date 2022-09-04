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

public class CardNumberCheckByCard {
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
    public void checkByCardNumberUnknown() {
        val cardInfo = getCardNumberUnknown();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitError();
    }

    @Test
    public void checkByCardNumberEmptyField() {
        val cardInfo = getCardNumberEmptyField();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardNumber15Numerals() {
        val cardInfo = getCardNumber15Numerals();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkByCardNumberZeros() {
        val cardInfo = getCardNumberZeros();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkByCardNumberText() {
        val cardInfo = getCardNumberText();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardNumberSymbols() {
        val cardInfo = getCardNumberSymbols();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }
}
