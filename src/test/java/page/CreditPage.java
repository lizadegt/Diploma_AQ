package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private final SelenideElement numberCardField = $("input[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("input[placeholder='08']");
    private final SelenideElement yearField = $("input[placeholder='22']");
    private final ElementsCollection fieldSet = $$(".input__control");
    private final SelenideElement holderField = fieldSet.get(3);
    private final SelenideElement cvcField = $("input[placeholder='999']");

    private final SelenideElement successResult = $(withText("Операция одобрена Банком."));
    private final SelenideElement invalidCardExpirationDate = $(withText("Неверно указан срок действия карты"));
    private final SelenideElement incorrectFormat = $(withText("Неверный формат"));
    private final SelenideElement error = $(withText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement cardExpired = $(withText("Истёк срок действия карты"));
    private final SelenideElement thisFieldIsRequired = $(withText("Поле обязательно для заполнения"));
    private final SelenideElement continueField = $(withText("Продолжить"));

    public void completedPaymentForm(DataHelper.CardInfo cardInfo) {
        numberCardField.setValue(cardInfo.getNumber());
        monthField.setValue(cardInfo.getMonth());
        yearField.setValue(cardInfo.getYear());
        holderField.setValue(cardInfo.getHolder());
        cvcField.setValue(cardInfo.getCvc());
        continueField.click();
    }


    public void waitInvalidCardExpirationDate() {
        invalidCardExpirationDate.shouldBe(visible);
    }

    public void waitIncorrectFormat() {
        incorrectFormat.shouldBe(visible);
    }

    public void waitError() {
        error.shouldBe(visible, Duration.ofSeconds(10));
    }

    public void waitCardExpired() {
        cardExpired.shouldBe(visible);
    }

    public void waitThisFieldIsRequired() {
        thisFieldIsRequired.shouldBe(visible);
    }

    public void waitSuccessResult() {
        successResult.shouldBe(visible, Duration.ofSeconds(10));
    }
}
