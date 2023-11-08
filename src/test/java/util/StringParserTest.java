package util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringParserTest {
    @DisplayName("정수형 파싱이 불가능한 경우 예외가 발생한다.")
    @Test
    void parseIntegerNotPossible() {
        assertThatThrownBy(() -> StringParser.toInteger("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
