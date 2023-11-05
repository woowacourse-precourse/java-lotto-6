package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputTest {
    @DisplayName("숫자 입력 시 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void stringValueToIntegerValue() {
        String input = "abcde";
        assertThatThrownBy(() -> Integer.parseInt(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("구매 금액 입력 시 1000 단위로 나누어 떨어지는지 검사한다.")
    @Test
    void input() {
        String input = "99999";
        int rest = Integer.parseInt(input) % 1000;
        assertThat(rest).isNotEqualTo(0);
    }

}