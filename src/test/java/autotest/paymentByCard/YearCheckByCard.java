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

public class YearCheckByCard {
    MainPage mainPage;
    PaymentPage paymentPage;

    @BeforeEach
    void shouldOpen() {
        String sutUrl = System.getProperty("sut.url");
        mainPage = open(sutUrl, MainPage.class);
        paymentPage = mainPage.buyCard();
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }



    @Test
    public void checkByCardYearEmptyField() {
        val cardInfo = getCardYearEmptyField();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardYearOneNumeral() {
        val cardInfo = getCardYearOneNumeral();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardYearZeros() {
        val cardInfo = getCardYearZeros();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitCardExpired();
    }

    @Test
    public void checkByCardYearOver27() {
        val cardInfo = getCardYearOver27();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitInvalidCardExpirationDate();
    }

    @Test
    public void checkByCardYearLess22() {
        val cardInfo = getCardYearLess22();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitCardExpired();
    }

    @Test
    public void checkByCardYearText() {
        val cardInfo = getCardYearText();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardYearSymbols() {
        val cardInfo = getCardYearSymbols();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }
}
