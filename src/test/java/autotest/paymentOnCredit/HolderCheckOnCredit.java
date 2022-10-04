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

public class HolderCheckOnCredit {
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
    public void checkOnCreditCardHolderEmptyField() {
        val cardInfo = getCardHolderEmptyField();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
    }

    @Test
    public void checkOnCreditCardHolderNoName() {
        val cardInfo = getCardHolderNoName();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardHolderThreeNames() {
        val cardInfo = getCardHolderThreeNames();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardHolderCyrillic() {
        val cardInfo = getCardHolderCyrillic();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardHolderNumeral() {
        val cardInfo = getCardHolderNumeral();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardHolderLettersAndNumbers() {
        val cardInfo = getCardHolderLettersAndNumbers();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }

    @Test
    public void checkOnCreditCardHolderLettersAndSymbols() {
        val cardInfo = getCardHolderLettersAndSymbols();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitIncorrectFormat();
    }
}
