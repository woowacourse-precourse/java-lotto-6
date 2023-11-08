package lotto.util;

import static lotto.enums.Delimiter.COMMA;
import static lotto.enums.ErrorMessage.INVALID_NUMBER;
import static lotto.enums.ErrorMessage.NOT_SEPARATE_BY_DELIMITER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConverterTest {
    @Test
    void 문자열을_숫자로_변환할_수_없을_경우_예외가_발생한다() {
        // given
        String input = "1a";

        // when & then
        assertThatThrownBy(() -> Converter.convertToInt(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER.getMassage());
    }

    @Test
    void 문자열을_숫자로_변환한다() {
        // given
        String input = "1";

        // when
        int result = Converter.convertToInt(input);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 구분자로_문자열을_숫자_리스트로_변환한다() {
        // given
        String input = "1" + COMMA.getValue() + "2" + COMMA.getValue() + "3"
                + COMMA.getValue() + "4" + COMMA.getValue() + "5" + COMMA.getValue() + "6";

        // when
        List<Integer> result = Converter.convertToIntListByDelimiter(input);

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
        assertThatThrownBy(() -> Converter.convertToIntListByDelimiter(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SEPARATE_BY_DELIMITER.getMassage());
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1,000", "10000:10,000", "100000:100,000", "1000000:1,000,000"}, delimiter = ':')
    void 숫자를_천_단위마다_콤마로_구분한_문자열로_변환한다(int number, String expected) {
        // when
        String result = Converter.convertNumberWithComma(number);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1.25,1.3", "64.38,64.4", "0.01,0.0", "0.05,0.1"})
    void 소수점_둘째_자리에서_반올림한_실수를_문자열로_변환한다(double value, String expected) {
        // when
        String result = Converter.convertToStringWithRound(value);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
