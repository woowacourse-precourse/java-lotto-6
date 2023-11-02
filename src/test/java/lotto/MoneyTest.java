package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("money가 null이나 빈 값이면 예외 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void validateNullOrEmptyTest(String input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 공백이나 빈 값으로는 로또 구매가 불가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money가 숫자가 아닌 값이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"돈", "money", "10p"})
    void validateNanTest(String input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 숫자가 아닌 값은 입력이 불가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money가 1000 미만의 값 이면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-9000"})
    void validateRangeTest(String input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 1000 이상의 숫자만 입력 가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("money가 1000 으로 나누어 떨어지지 않을 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1004", "1400400", "33030"})
    void validateDivideTest(String input) {
        // when, then
        assertThatThrownBy(() -> new Money(input))
                .hasMessage("[ERROR] 1000원 단위로만 구매가 가능합니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
