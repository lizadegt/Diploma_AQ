package page;

import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Value;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

@Value
@AllArgsConstructor
public class MainPage {
    private final SelenideElement buyField = $(withText("Купить"));
    private final SelenideElement buyOnCreditField = $(withText("Купить в кредит"));
    private final SelenideElement byCardText = $(byText("Оплата по карте"));
    private final SelenideElement byCreditText = $(byText("Кредит по данным карты"));


    public PaymentPage buyCard() {
        buyField.click();
        byCardText.shouldBe(visible);
        return new PaymentPage();
    }

    public CreditPage buyCredit() {
        buyOnCreditField.click();
        byCreditText.shouldBe(visible);
        return new CreditPage();
    }
}