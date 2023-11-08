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

    @DisplayName("쉼표로 구분된 값 사이에 다른 문자가 포함된 경우 예외가 발생한다.")
    @Test
    void parseIntegerNotPossibleForEachCommaSeperatedValue() {
        assertThatThrownBy(() -> StringParser.toIntegers("1,2,3 ,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
