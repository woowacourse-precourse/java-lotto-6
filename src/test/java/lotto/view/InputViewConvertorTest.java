package lotto.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputViewConvertorTest {

    @DisplayName("문자열을 숫자로 변환 시,")
    @Nested
    class ParseInt {

        @DisplayName("숫자의 경우 예외가 발생하지 않는다.")
        @Test
        void parseIntFromNumber() {
            // given
            String value = "123";

            // when & then
            Assertions.assertThatCode(() -> InputViewConvertor.parseInt(value))
                    .doesNotThrowAnyException();
        }

        @DisplayName("숫자가 아닌 경우 예외가 발생하지 않는다.")
        @Test
        void parseIntFromNotANumber() {
            // given
            String value = "abc";

            // when & then
            Assertions.assertThatThrownBy(() -> InputViewConvertor.parseInt(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(InputExceptionMessages.NOT_A_NUMBER.getMessage());
        }

    }

}
