package lotto.domain;

import static lotto.constants.ErrorMessage.INVALID_PURCHASE_AMOUNT;
import static lotto.constants.ErrorMessage.NEGATIVE_INTEGER;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PurchaseNumberTest {
    @Test
    void 구입금액이_1000원_단위가_아니면_예외가_발생한다() {
        // given
        Integer 구입금액 = 2500;

        // when & then
        assertThatThrownBy(() -> {
            new PurchaseNumber(구입금액);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(INVALID_PURCHASE_AMOUNT);
    }

    @Test
    void 구입금액이_음수면_예외가_발생한다() {
        // given
        Integer 구입금액 = -1000;

        // when & then
        assertThatThrownBy(() -> {
            new PurchaseNumber(구입금액);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NEGATIVE_INTEGER);
    }
}