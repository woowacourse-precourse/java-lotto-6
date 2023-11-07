package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseAmountTest {
    @DisplayName("금액을 입력하면 몇 장의 로또를 구매할지 반환한다.")
    @ParameterizedTest
    @CsvSource({"1_000,1", "2_000,2", "10_000,10"})
    void createByValidPrice(int price, int expectedAmount) {
        LottoPurchaseAmount lottoPurchaseAmount = LottoPurchaseAmount.from(price);

        assertThat(lottoPurchaseAmount.value()).isEqualTo(expectedAmount);
    }

    @DisplayName("1,000으로 나누어 떨어지지 않는 금액을 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 500, 999, 1_001, 1_500})
    void createByNonDivisiblePrice(int price) {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0원을 입력하면 예외가 발생한다")
    @Test
    void createByZeroPrice() {
        assertThatThrownBy(() -> LottoPurchaseAmount.from(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
