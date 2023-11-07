package lotto.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class IntegerInputTest {
    @DisplayName("숫자 문자를 입력하면 숫자로 파싱되어 저장된다")
    @ParameterizedTest
    @CsvSource({"-1,-1", "0,0", "1,1", "+1,1"})
    void createByInteger(String input, int expected) {
        IntegerInput integerInput = new IntegerInput(input);

        assertThat(integerInput.value()).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "a", "숫자", "-+1"})
    void createByNonInteger(String input) {
        assertThatThrownBy(() -> new IntegerInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
