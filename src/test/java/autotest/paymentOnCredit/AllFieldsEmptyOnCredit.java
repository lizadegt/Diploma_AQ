package autotest.paymentOnCredit;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.CreditPage;
import page.MainPage;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.getCardAllFieldsEmpty;

public class AllFieldsEmptyOnCredit {
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
    public void checkOnCreditCardAllFieldsEmpty() {
        val cardInfo = getCardAllFieldsEmpty();
        creditPage.completedPaymentForm(cardInfo);
        creditPage.waitThisFieldIsRequired();
        final ElementsCollection emptyField = $$(".input__sub");
        final SelenideElement cardNumberField = emptyField.get(1);
        final SelenideElement monthField = emptyField.get(2);
        final SelenideElement yearField = emptyField.get(3);
        final SelenideElement holderField = emptyField.get(4);
        final SelenideElement cvcField = emptyField.get(5);
        cardNumberField.shouldHave(Condition.text("Поле обязательно для заполнения"));
        monthField.shouldHave(Condition.text("Поле обязательно для заполнения"));
        yearField.shouldBe(Condition.text("Поле обязательно для заполнения"));
        holderField.shouldBe(Condition.text("Поле обязательно для заполнения"));
        cvcField.shouldBe(Condition.visible.text("Поле обязательно для заполнения"));
    }

}
