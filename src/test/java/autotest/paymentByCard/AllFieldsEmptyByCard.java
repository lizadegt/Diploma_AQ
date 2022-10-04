package autotest.paymentByCard;

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
import page.MainPage;
import page.PaymentPage;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.getCardAllFieldsEmpty;

public class AllFieldsEmptyByCard {
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
    public void checkByCardAllFieldsEmpty() {
        val cardInfo = getCardAllFieldsEmpty();
        paymentPage.completedPaymentForm(cardInfo);
        paymentPage.waitThisFieldIsRequired();
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
