package lotto.utils;

import static lotto.constant.ErrorMessage.INPUT_EMPTY;
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
}
