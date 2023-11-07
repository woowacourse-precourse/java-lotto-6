package lotto.view;

import lotto.util.Validation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "z00"})
    @DisplayName("구매 금액 입력 값이 숫자가 아닐 때 예외 발생")
    void testValidateIsNotNumber(String invalidInput) {
        Assertions.assertThatThrownBy(() -> Validation.validateIsNotNumber(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자가 아닌 다른 값이 입력되었습니다.");
    }
}