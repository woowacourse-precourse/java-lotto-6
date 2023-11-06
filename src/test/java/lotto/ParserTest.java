package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.util.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    @DisplayName("문자열에서 정수로 변환하는 과정에서 입력값이 숫자가 아닌 경우 예외를 던진다.")
    void parsingStringToIntWithInvalidInput() {
        // given
        String invalidInput = "abc";

        // when & then
        assertThatThrownBy(() -> Parser.stringToInt(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
