package lotto.domain;

import static common.enumtype.ErrorCode.AMOUNT_INVALID_UNIT;
import static common.enumtype.ErrorCode.AMOUNT_LESS_THAN_MINIMUM;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 구입 금액 검증")
class LottoPurchaseAmountTest {

    @Test
    void 로또_구입_금액_1000원_미만_예외() {
        // given
        int amount = 999;

        // when
        // then
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_LESS_THAN_MINIMUM.getMessage());
    }

    @Test
    void 로또_구입_금액_1000원_나누어_떨어지지_않는_예외() {
        // given
        int amount = 1001;

        // when
        // then
        assertThatThrownBy(() -> new LottoPurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(AMOUNT_INVALID_UNIT.getMessage());
    }

    @Test
    void 로또_구입_금액_생성() {
        // given
        int amount = 1000;

        // when
        LottoPurchaseAmount result = new LottoPurchaseAmount(amount);

        // then
        assertThat(result).isNotNull();
    }
}
