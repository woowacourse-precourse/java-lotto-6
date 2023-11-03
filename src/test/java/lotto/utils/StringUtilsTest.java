package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @DisplayName("당첨 번호를 입력받을 때 숫자가 아니면 예외가 발생한다.")
    @Test
    void stringToNumbers() {
        String input = "1,2,3,4,5,d";
        assertThatThrownBy(() -> StringUtils.stringToNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액을 입력받을 때 숫자가 아니면 예외가 발생한다.")
    @Test
    void stringToNumber() {
        String input = "d";
        assertThatThrownBy(() -> StringUtils.stringToNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
