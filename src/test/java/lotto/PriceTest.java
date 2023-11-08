package lotto;

import static lotto.constant.GameNumber.MAX_LOTTO_AMOUNT;
import static lotto.constant.GameNumber.MIN_LOTTO_AMOUNT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    @DisplayName("가격 입력에 문자 포함 시 예외 발생")
    void validateNumeric() {
        assertThatThrownBy(() -> new Price("1000a"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가격이 1000 단위로 입력되지 않은 경우 예외 발생")
    void validateRemainder() {
        assertThatThrownBy(() -> new Price("1001"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최솟값보다 적게 구매하는 경우 예외 발생")
    void validateMinimum() {
        long buyAmount = MIN_LOTTO_AMOUNT.getNumber() - 1;
        String buyInput = String.valueOf(buyAmount * 1000);

        assertThatThrownBy(() -> new Price(buyInput))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최댓값보다 많게 구매하는 경우 예외 발생")
    void validateMaximum() {
        long buyAmount = MAX_LOTTO_AMOUNT.getNumber() + 1;
        String buyInput = String.valueOf(buyAmount * 1000);

        assertThatThrownBy(() -> new Price(buyInput))
            .isInstanceOf(IllegalArgumentException.class);
    }
}