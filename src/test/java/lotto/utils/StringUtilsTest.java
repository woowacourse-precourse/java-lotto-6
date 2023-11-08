package lotto.utils;

import static lotto.constant.ErrorMessage.INPUT_CONTAINS_WHITE_SPACE;
import static lotto.constant.ErrorMessage.INPUT_EMPTY;
import static lotto.constant.ErrorMessage.INPUT_IS_NOT_INTEGER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    @Test
    @DisplayName("빈 문자열인 경우 예외가 발생한다.")
    void validEmptyString() {
        // given
        String empty = "";

        // when & then
        assertThatThrownBy(() -> StringUtils.validEmptyString(empty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_EMPTY);
    }

    @Test
    @DisplayName("문자열에 공백이 포함된 경우 예외가 발생한다.")
    void validContainsWhiteSpace() {
        // given
        String inputWithWhiteSpace = "1,2, 3";

        // when & then
        assertThatThrownBy(() -> StringUtils.validContainsWhiteSpace(inputWithWhiteSpace))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_CONTAINS_WHITE_SPACE);
    }

    @Test
    @DisplayName("문자열로부터 정수를 추출한다.")
    void getIntegerValue_정수_추출() {
        // given
        String input = "3";

        // when
        Integer result = StringUtils.getIntegerValue(input);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열을 정수로 변환하지 못하는 경우 예외가 발생한다.")
    void getIntegerValue_예외() {
        // given
        String input = "3.3";

        // when & then
        assertThatThrownBy(() -> StringUtils.getIntegerValue(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_NOT_INTEGER);
    }
}
