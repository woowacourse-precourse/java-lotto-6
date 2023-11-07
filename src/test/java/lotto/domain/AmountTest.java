package lotto.domain;

import lotto.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AmountTest {

    @Test
    void 음수가_주어진_경우_예외를_발생한다() {
        // Given
        int amount = -1000;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_POSITIVE.message());
    }

    @Test
    void 숫자0이_주어진_경우_예외를_발생한다() {
        // Given
        int amount = 0;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_POSITIVE.message());
    }

    @Test
    void 숫자1000_으로_나누어_떨어지지_않는_경우_예외를_발생한다() {
        // Given
        int amount = 1200;

        // When
        // Then
        Assertions.assertThatThrownBy(() -> new Amount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.AMOUNT_IS_NOT_DIVIDED_LOTTO_PRICE.message());
    }
}