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

public class YearCheckOnCredit {
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
    public void checkOnCreditCardYearEmptyField() {
        val cardInfo = getCardYearEmptyField();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardYearOneNumeral() {
        val cardInfo = getCardYearOneNumeral();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardYearZeros() {
        val cardInfo = getCardYearZeros();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitCardExpired();
    }

    @Test
    public void checkOnCreditCardYearOver27() {
        val cardInfo = getCardYearOver27();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void checkOnCreditCardYearLess22() {
        val cardInfo = getCardYearLess22();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitCardExpired();
    }

    @Test
    public void checkOnCreditCardYearText() {
        val cardInfo = getCardYearText();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardYearSymbols() {
        val cardInfo = getCardYearSymbols();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }
}
