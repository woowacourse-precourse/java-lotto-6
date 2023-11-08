package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AmountTest {

    @ParameterizedTest
    @DisplayName("구입금액은 1000으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @ValueSource(ints = {1001, 1002, 1003})
    void Amount_Constructor_When_Not_Divisible_By_1000(int price) {
        assertThatThrownBy(() -> new Amount(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입금액은 1000미만의 숫자가 입력되면 예외가 발생한다.")
    @ValueSource(ints = {999, 998, 997})
    void Amount_Constructor_When_Less_Than_1000(int price) {
        assertThatThrownBy(() -> new Amount(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("getLottoCount 메서드는 구입금액에 맞는 로또 발행 개수를 리턴한다.")
    @ValueSource(ints = {1000, 2000, 3000})
    void getLottoCount_Method_Return_Lotto_Count(int price) {
        Amount amount = new Amount(price);

        assertEquals(amount.getLottoCount(), price / 1000);
    }
}
