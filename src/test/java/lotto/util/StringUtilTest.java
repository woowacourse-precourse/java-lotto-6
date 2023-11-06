package lotto.util;

import static lotto.enums.ErrorMassage.INVALID_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class StringUtilTest {
    @Test
    void 문자열을_숫자로_변환할_수_없을_경우_예외가_발생한다() {
        // given
        String input = "1a";

        // when & then
        assertThatThrownBy(() -> StringUtil.convertToInt(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER.getMassage());
    }
}
