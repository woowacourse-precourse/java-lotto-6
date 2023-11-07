package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.BlankException;
import lotto.exception.amount.IllegalCipherException;
import lotto.exception.amount.NumberFormatException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AmountTest {
    @DisplayName("구입 금액 null 또는 공백 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"", "\n"})
    void createAmountByBlank(String amount) {
        assertThatThrownBy(() -> new Amount(amount)).isInstanceOf(BlankException.class);
    }

    @DisplayName("구입 금액에 숫자가 아닌 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"123e", "123!"})
    void createAmountByNonNumber(String amount) {
        assertThatThrownBy(() -> new Amount(amount)).isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구입 금액에 1,000원 단위 아닌 값 입력시 예외 발생")
    @ParameterizedTest()
    @ValueSource(strings = {"1234", "12001"})
    void createAmountByInvalidCipher(String amount) {
        assertThatThrownBy(() -> new Amount(amount)).isInstanceOf(IllegalCipherException.class);
    }
}
