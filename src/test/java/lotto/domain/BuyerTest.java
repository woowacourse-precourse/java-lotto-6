package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BuyerTest {
    @DisplayName("구입 금액 null 또는 공백 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"", "\n"})
    void createAmountByBlank(String amount) {
        assertThatThrownBy(() -> new Buyer(Utils.stringToInt(amount))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자가 아닌 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"123e", "123!"})
    void createAmountByNonNumber(String amount) {
        assertThatThrownBy(() -> new Buyer(Utils.stringToInt(amount))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 1,000원 단위 아닌 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(ints = {1234, 12001})
    void createAmountByInvalidCipher(int amount) {
        assertThatThrownBy(() -> new Buyer(amount)).isInstanceOf(IllegalArgumentException.class);
    }
}
