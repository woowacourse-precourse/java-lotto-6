package lotto.util;

import static lotto.enums.Delimiter.COMMA;
import static lotto.enums.ErrorMassage.INVALID_NUMBER;
import static lotto.enums.ErrorMassage.NOT_SEPARATE_BY_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

    @Test
    void 문자열을_숫자로_변환한다() {
        // given
        String input = "1";

        // when
        int result = StringUtil.convertToInt(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 구분자로_문자열을_숫자_리스트로_변환한다() {
        // given
        String input = "1" + COMMA.getValue() + "2" + COMMA.getValue() + "3"
                + COMMA.getValue() + "4" + COMMA.getValue() + "5" + COMMA.getValue() + "6";

        // when
        List<Integer> result = StringUtil.convertToIntListByDelimiter(input);

        // then
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(result).hasSize(6);
    }

    @Test
    void 구분자로_문자열을_숫자_리스트로_변환할_수_없을_경우_예외가_발생한다() {
        // given
        String delimiter = ".";
        String input = "1" + delimiter + "2" + delimiter + "3" + delimiter + "4" + delimiter + "5" + delimiter + "6";

        // when & then
        assertThatThrownBy(() -> StringUtil.convertToIntListByDelimiter(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SEPARATE_BY_DELIMITER.getMassage());
    }
}
