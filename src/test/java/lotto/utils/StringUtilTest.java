package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilTest {
    @DisplayName("문자열에 `,`가 포함되어 있는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"14000:FALSE", "14,000:TRUE"}, delimiter = ':')
    void containsTest(String input, boolean expected) {
        // given

        // when
        boolean result = StringUtil.containsThousandSeparator(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("문자열에 `,`가 올바르지 않은 위치에 있으면 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",1000", "10,00", "100,0", "1000,", "10,000000", "1000,000", "10,,000"})
    void validateCommaAtPositionTest(String input) {
        assertThatThrownBy(() -> StringUtil.validateCommaAtPosition(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열에 포함된 모든 `,`를 제거하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10,000,000:10000000", "14,000:14000"}, delimiter = ':')
    void replaceTest(String input, String expected) {
        // given

        // when
        String result = StringUtil.removeComma(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("숫자가 아닌 문자열이 들어오면 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "abcde", "123abc456"})
    void convertNotAStringTest(String input) {
        assertThatThrownBy(() -> StringUtil.stringToCapital(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정수형 범위를 넘어가면 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4294967296", "4,294,967,296"})
    void convertOverInteger(String input) {
        assertThatThrownBy(() -> StringUtil.stringToCapital(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("`,`를 구분자로 split 했을 때 요소들 중 하나라도 숫자가 아닌 경우 예외 발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,a", "1,2,3,a,4", "1, 2,, 4, 5", "1, 2, , 4, 5"})
    void splitContainsNotNumber(String input) {
        assertThatThrownBy(() -> StringUtil.stringToLottery(input));
    }
}