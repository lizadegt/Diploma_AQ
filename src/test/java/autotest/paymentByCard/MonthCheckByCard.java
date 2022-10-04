package autotest.paymentByCard;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;

public class MonthCheckByCard {
    MainPage mainPage;
    PaymentPage paymentPage;

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
        mainPage = open(sutUrl, MainPage.class);
        paymentPage = mainPage.buyCard();
    }

    @Test
    public void CardMonthEmptyField() {
        val cardInfo = getCardMonthEmptyField();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void CardMonthOneNumeral() {
        val cardInfo = getCardMonthOneNumeral();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void CardMonthZeros() {
        val cardInfo = getCardMonthZeros();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void CardMonthLetters() {
        val cardInfo = getCardMonthLetters();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void CardMonthSymbols() {
        val cardInfo = getCardMonthSymbols();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void CardMonthOver12() {
        val cardInfo = getCardMonthOver12();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitInvalidCardExpirationDate();
    }
}
