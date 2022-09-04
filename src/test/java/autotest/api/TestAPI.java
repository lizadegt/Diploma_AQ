package autotest.api;

import lombok.val;
import org.junit.jupiter.api.Test;

import static data.API.*;
import static data.DataHelper.getCardStatusApproved;
import static data.DataHelper.getCardStatusDeclined;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAPI {


    @Test
    void approvedCardBuyForm() {
        val validApprovedCard = getCardStatusApproved();
        val status = PaymentPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void declinedCardBuyForm() {
        val validDeclinedCard = getCardStatusDeclined();
        val status = PaymentPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }

    @Test
    void approvedCardCreditForm() {
        val validApprovedCard = getCardStatusApproved ();
        val status = CreditRequestPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void declinedCardCreditForm() {
        val validDeclinedCard = getCardStatusDeclined();
        val status = CreditRequestPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }
}
