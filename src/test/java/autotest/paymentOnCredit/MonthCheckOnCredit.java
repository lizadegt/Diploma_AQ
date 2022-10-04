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

public class MonthCheckOnCredit {
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
    public void checkOnCreditCardMonthEmptyField() {
        val cardInfo = getCardMonthEmptyField();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardMonthOneNumeral() {
        val cardInfo = getCardMonthOneNumeral();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardMonthZeros() {
        val cardInfo = getCardMonthZeros();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardMonthLetters() {
        val cardInfo = getCardMonthLetters();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardMonthSymbols() {
        val cardInfo = getCardMonthSymbols();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardMonthOver12() {
        val cardInfo = getCardMonthOver12();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitInvalidCardExpirationDate();
    }
}
