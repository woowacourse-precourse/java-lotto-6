package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseAmountTest {
    @Nested
    class 구입금액_생성시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            int amount = 1000;
            //when
            LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount);
            //then
            assertThat(lottoPurchaseAmount.getValue()).isEqualTo(amount);
        }

        @ValueSource(ints = {999, 100_000_001})
        @ParameterizedTest
        void 구입금액이_1000원이상_1억원이하가_아니라면_예외가_발생한다(int amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getValue());
        }

        @Test
        void 구입금액이_1000원_단위가_아니라면_예외가_발생한다() {
            //given
            int amount = 1200;
            //when then
            Assertions.assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getValue());
        }
    }
}