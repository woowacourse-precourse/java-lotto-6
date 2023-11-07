package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputControllerTest {
    @DisplayName("숫자 입력 시 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void stringValueToIntegerValue() {
        String input = "abcde";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class);
    }
}