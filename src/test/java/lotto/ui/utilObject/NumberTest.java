package lotto.ui.utilObject;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("공백을 입력한 경우, 예외를 발생시킨다.")
    void validateEmpty(String inputValue) {
        // then
        assertThatThrownBy(() -> new Number(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining( "[ERROR] 공백을 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,", "가나다", "-123"})
    @DisplayName("입력 값이 숫자가 아닌 경우, 예외를 발생시킨다.")
    void validateDigit(String inputValue) {
        // then
        assertThatThrownBy(() -> new Number(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567890", "123456789456123"})
    @DisplayName("입력한 값이 9자리를 넘는 경우, 예외를 발생시킨다.")
    void validate_nonThousandUnit(String inputValue) {
        // then
        assertThatThrownBy(() -> new Number(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 9자리 숫자까지 입력 가능합니다.");
    }
}