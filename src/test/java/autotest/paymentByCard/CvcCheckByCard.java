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

public class CvcCheckByCard {
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
    public void checkByCardCvcEmptyField() {
        val cardInfo = getCardCvcEmptyField();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardCvcZeros() {
        val cardInfo = getCardCvcZeros();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardCvcOneDigit() {
        val cardInfo = getCardCvcOneDigit();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardCvcTwoDigit() {
        val cardInfo = getCardCvcTwoDigit();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardCvcLetters() {
        val cardInfo = getCardCvcLetters();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardCvcSymbols() {
        val cardInfo = getCardCvcSymbols();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }
}
