package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PriceValidatorTest {
    private static final String MIN_PRICE_1000_MESSAGE = "금액은 1000원 이상이어야 합니다";
    private static final String UNIT_OF_1000_REQUIRED_MESSAGE = "금액은 1000원 단위로 입력되어야 합니다";

    @ParameterizedTest
    @CsvSource(value = {"1000", "2000", "5000", "100000", "1000000"})
    @DisplayName("정상동작")
    void goodCase(int input) {
        assertDoesNotThrow(() -> PriceValidator.validatePrice(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "10", "100", "999"})
    @DisplayName("1000원 미만 예외")
    void 금액_1000원_미만_예외(int input) {
        assertThatThrownBy(() -> PriceValidator.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MIN_PRICE_1000_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1001", "10001", "50500", "222222", "9999999"})
    @DisplayName("1000원 단위가 아니면 예외")
    void 금액_1000원_단위가_아니면_예외(int input) {
        assertThatThrownBy(() -> PriceValidator.validatePrice(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(UNIT_OF_1000_REQUIRED_MESSAGE);
    }
}