package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SplitGeneratorTest {
    @DisplayName("당첨 번호 입력 시 쉼표로 구분하지 않을 경우 예외가 발생한다.")
    @Test
    void inputWinNumbersIsNonContainsComma() {
        String winNumbers = "1.2.3.4.5.6.7";

        assertThatThrownBy(() -> new SplitGenerator(winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호를 입력하지 않으면 예외가 발생한다.")
    @Test
    void inputWinNumberIsNull() {
        assertThatThrownBy(() -> new SplitGenerator(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void inputIsNumeric() {
        String winNumbers = "1,2,3,4,5,seven";

        assertThatThrownBy(() -> new SplitGenerator(winNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
