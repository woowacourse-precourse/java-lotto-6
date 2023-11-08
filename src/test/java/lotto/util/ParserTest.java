package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @DisplayName("숫자로 잘 변환 되는지 확인한다.")
    @Test
    void parseNumber() {
        assertThat(Parser.parseSingleNumber("12"))
                .isEqualTo(12);
    }

    @DisplayName("숫자가 아닌 문자를 입력하면 예외가 발생한다.")
    @Test
    void parseByNotNumber() {
        assertThatThrownBy(() -> Parser.parseSingleNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("여러개 입력시 숫자가 아닌 문자가 있으면 입력 예외가 발생한다.")
    @Test
    void parseByNotNumbers() {
        assertThatThrownBy(() -> Parser.parseNumbers("1,2,3,a,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 없는 경우 예외가 발생한다.")
    @Test
    void parseByEmpty() {
        assertThatThrownBy(() -> Parser.parseNumbers("1,2,3,,4"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
