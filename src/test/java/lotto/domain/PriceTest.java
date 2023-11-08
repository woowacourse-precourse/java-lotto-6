package lotto.domain;

import static lotto.constant.GameNumber.MAX_LOTTO_AMOUNT;
import static lotto.constant.GameNumber.MIN_LOTTO_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    @DisplayName("가격이 1000 단위로 입력되지 않은 경우 예외 발생")
    void validateRemainder() {
        assertThatThrownBy(() -> new Price(1001L))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최솟값보다 적게 구매하는 경우 예외 발생")
    void validateMinimum() {
        long price = MIN_LOTTO_AMOUNT.getNumber() - 1;

        assertThatThrownBy(() -> new Price(price))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최댓값보다 많게 구매하는 경우 예외 발생")
    void validateMaximum() {
        long price = MAX_LOTTO_AMOUNT.getNumber() + 1;

        assertThatThrownBy(() -> new Price(price))
            .isInstanceOf(IllegalArgumentException.class);
    }
}