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

public class CardNumberCheckByCard {
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
    public void checkByCardNumberUnknown() {
        val cardInfo = getCardNumberUnknown();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitError();
    }

    @Test
    public void checkByCardNumberEmptyField() {
        val cardInfo = getCardNumberEmptyField();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardNumber15Numerals() {
        val cardInfo = getCardNumber15Numerals();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardNumberZeros() {
        val cardInfo = getCardNumberZeros();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardNumberText() {
        val cardInfo = getCardNumberText();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardNumberSymbols() {
        val cardInfo = getCardNumberSymbols();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }
}
