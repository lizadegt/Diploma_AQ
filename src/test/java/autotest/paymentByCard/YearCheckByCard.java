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

public class YearCheckByCard {
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
    public void checkByCardYearEmptyField() {
        val cardInfo = getCardYearEmptyField();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardYearOneNumeral() {
        val cardInfo = getCardYearOneNumeral();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitIncorrectFormat();
    }

    @Test
    public void checkByCardYearZeros() {
        val cardInfo = getCardYearZeros();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitCardExpired();
    }

    @Test
    public void checkByCardYearOver27() {
        val cardInfo = getCardYearOver27();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitInvalidCardExpirationDate();
    }

    @Test
    public void checkByCardYearLess22() {
        val cardInfo = getCardYearLess22();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitCardExpired();
    }

    @Test
    public void checkByCardYearText() {
        val cardInfo = getCardYearText();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardYearSymbols() {
        val cardInfo = getCardYearSymbols();
        purchaseForm.completedPaymentForm(cardInfo);
        purchaseForm.waitThisFieldIsRequired();
    }
}
