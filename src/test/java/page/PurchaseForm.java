package page;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PurchaseForm {
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
        invalidCardExpirationDate.shouldBe(Condition.visible);
    }

    public void waitIncorrectFormat() {
        incorrectFormat.shouldBe(Condition.visible);
    }

    public void waitError() {
        error.shouldBe(Condition.visible);
    }

    public void waitCardExpired() {
        cardExpired.shouldBe(Condition.visible);
    }

    public void waitThisFieldIsRequired() {
        thisFieldIsRequired.shouldBe(Condition.visible);
    }

    public void waitSuccessResult() {
        successResult.shouldBe(Condition.visible);
    }

}