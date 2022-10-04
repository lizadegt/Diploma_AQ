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

public class CvcCheckOnCredit {
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
    public void checkOnCreditCardCvcEmptyField() {
        val cardInfo = getCardCvcEmptyField();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardCvcZeros() {
        val cardInfo = getCardCvcZeros();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardCvcOneDigit() {
        val cardInfo = getCardCvcOneDigit();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardCvcTwoDigit() {
        val cardInfo = getCardCvcTwoDigit();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardCvcLetters() {
        val cardInfo = getCardCvcLetters();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardCvcSymbols() {
        val cardInfo = getCardCvcSymbols();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }
}
