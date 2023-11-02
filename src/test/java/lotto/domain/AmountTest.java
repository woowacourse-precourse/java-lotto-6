package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @DisplayName("Amount의 생성자는 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ValueSource(ints = {1001, 1002, 1003})
    void Amount_Constructor_When_Not_Divisible_By_1000(int price) {
        assertThatThrownBy(() -> new Amount(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
