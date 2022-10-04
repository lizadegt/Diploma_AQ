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
        val status = paymentPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void declinedCardBuyForm() {
        val validDeclinedCard = getCardStatusDeclined();
        val status = paymentPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }

    @Test
    void approvedCardCreditForm() {
        val validApprovedCard = getCardStatusApproved ();
        val status = creditRequestPageForm(validApprovedCard);
        assertTrue(status.contains("APPROVED"));
    }

    @Test
    void declinedCardCreditForm() {
        val validDeclinedCard = getCardStatusDeclined();
        val status = creditRequestPageForm(validDeclinedCard);
        assertTrue(status.contains("DECLINED"));
    }
}
