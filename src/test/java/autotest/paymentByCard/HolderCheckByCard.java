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

public class HolderCheckByCard {
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
    public void checkByCardHolderEmptyField() {
        val cardInfo = getCardHolderEmptyField();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkByCardHolderNoName() {
        val cardInfo = getCardHolderNoName();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardHolderThreeNames() {
        val cardInfo = getCardHolderThreeNames();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardHolderCyrillic() {
        val cardInfo = getCardHolderCyrillic();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardHolderNumeral() {
        val cardInfo = getCardHolderNumeral();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardHolderLettersAndNumbers() {
        val cardInfo = getCardHolderLettersAndNumbers();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }

    @Test
    public void checkByCardHolderLettersAndSymbols() {
        val cardInfo = getCardHolderLettersAndSymbols();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitIncorrectFormat();
    }
}
