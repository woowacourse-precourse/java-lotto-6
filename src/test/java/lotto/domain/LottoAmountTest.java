package lotto.domain;

import static lotto.enums.ErrorMassage.NOT_ENOUGH_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoAmountTest {
    @Test
    void 구매_금액이_1000원_미만일_경우_예외가_발생한다() {
        // given
        final int amount = 999;

        // when & then
        assertThatThrownBy(() -> new LottoAmount(amount))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_AMOUNT.getMassage());
    }
}