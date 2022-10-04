package autotest.paymentOnCredit;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CreditPage;
import page.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.*;

public class CardNumberCheckOnCredit {
    MainPage mainPage;
    CreditPage creditPage;

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
        creditPage = mainPage.buyCredit();
    }


    @Test
    public void checkOnCreditCardNumberUnknown() {
        val cardInfo = getCardNumberUnknown();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitError();
    }

    @Test
    public void checkOnCreditCardNumberEmptyField() {
        val cardInfo = getCardNumberEmptyField();
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardNumber15Numerals() {
        val cardInfo = getCardNumber15Numerals();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardNumberZeros() {
        val cardInfo = getCardNumberZeros();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardNumberText() {
        val cardInfo = getCardNumberText();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardNumberSymbols() {
        val cardInfo = getCardNumberSymbols();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }
}
