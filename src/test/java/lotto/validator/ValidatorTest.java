package lotto.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @DisplayName("입력값에 숫자가 아닌 잘못된 타입이 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "2000s", "안녕3000"})
    void checkWrongNumberType(String input) {
        assertThatThrownBy(() -> Validator.checkNumberType(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값 리스트에 숫자가 아닌 잘못된 타입이 있으면 예외가 발생한다.")
    @Test
    void checkAllNumbersWrongType() {
        String[] inputs = {"1", "2", "3", "4", "no"};
        assertThatThrownBy(() -> Validator.checkAllNumberType(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
