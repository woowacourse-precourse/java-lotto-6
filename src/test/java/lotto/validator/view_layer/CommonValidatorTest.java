package lotto.validator.view_layer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.constant.ErrorMessage.ENTER_PROPER_INTEGER;
import static lotto.constant.ErrorMessage.ENTER_PROPER_NATURAL_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommonValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "string", (long)Integer.MAX_VALUE + 1 +"", (long)Integer.MIN_VALUE - 1 + ""})
    @DisplayName("입력된 값이 int 범위의 숫자인지 검증한다.")
    void validateIsInteger(String input) {
        assertThatThrownBy(() -> CommonValidator.validateIsInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ENTER_PROPER_INTEGER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", (long)Integer.MAX_VALUE + 1 +"", (long)Integer.MIN_VALUE - 1 + ""})
    @DisplayName("입력된 값이 1부터 int형 최대값 사이여야한다.")
    void validateIsNaturalNumber(String input) {
        assertThatThrownBy(() -> CommonValidator.validateIsNaturalNumber(input))
                .isInstanceOf(IllegalArgumentException.class);

        CommonValidator.validateIsNaturalNumber(Integer.MAX_VALUE + "");
    }


}