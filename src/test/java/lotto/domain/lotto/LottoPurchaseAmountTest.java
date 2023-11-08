package lotto.domain.lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 구입 금액 도메인")
public class LottoPurchaseAmountTest {
    @DisplayName("로또 구입 금액은 음수가 될 수 없다.")
    @Test
    void should_IllegalArgumentExceptionThrown_When_amount_is_negative() {
        //given
        final long negativePurchasingAmount = -1;

        //when, then
        assertThatThrownBy(() -> new LottoPurchaseAmount(negativePurchasingAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_PRICE_NEGATIVE.getMessage());
    }

    @DisplayName("로또 구입 금액은 기준 금액으로 나누어 떨어져야 한다. (최소 1장 이상 구매 가능 보장)")
    @Test
    void should_IllegalArgumentExceptionThrown_When_amount_is_not_dividable_by_criteria() {
        //given
        final long amountNotDividable = LottoPrice.ONE.getPrice() + 1;

        //when, then
        assertThatThrownBy(() -> new LottoPurchaseAmount(amountNotDividable))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_PURCHASING_AMOUNT_NOT_DIVIDED.getMessage());
    }
}
