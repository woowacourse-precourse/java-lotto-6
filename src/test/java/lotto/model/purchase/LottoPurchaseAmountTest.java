package lotto.model.purchase;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseAmountTest {
    @CsvSource({
            "1000, 1",
            "100_000_000, 100_000",
            "123_000, 123"
    })
    @ParameterizedTest
    void 구입금액을_기반으로_구매한로또개수를_계산한다(int amount, int expected) {
        //given
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(amount);
        //when
        int totalLottos = lottoPurchaseAmount.calculatePurchaseLottoCount();

        //then
        assertThat(totalLottos).isEqualTo(expected);
    }

    @Nested
    class 구입금액_생성시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            int amount = 1000;
            //when
            LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(amount);
            //then
            assertThat(lottoPurchaseAmount.getValue()).isEqualTo(amount);
        }

        @ValueSource(ints = {999, 100_000_001})
        @ParameterizedTest
        void 구입금액이_1000원이상_1억원이하가_아니라면_예외가_발생한다(int amount) {
            //given
            //when then
            Assertions.assertThatThrownBy(() -> LottoPurchaseAmount.from(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getValue());
        }

        @Test
        void 구입금액이_1000원_단위가_아니라면_예외가_발생한다() {
            //given
            int amount = 1200;
            //when then
            Assertions.assertThatThrownBy(() -> LottoPurchaseAmount.from(amount))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT.getValue());
        }
    }
}