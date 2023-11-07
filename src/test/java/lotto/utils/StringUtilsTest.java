package lotto.utils;

import static lotto.view.ErrorMessage.NOT_A_NUMBER;
import static lotto.utils.StringUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @DisplayName("기능29 테스트 : countOccurrences 메서드가 문자열에서 특정 문자열(1글자)이 몇 번 등장하는지 정확하게 반환한다.")
    void countOccurrencesCountTargetStringWhenTargetStringLengthIsOne() {
        String testString = "AABABC";

        String targetSTring = "A";

        int result = countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("기능29 테스트 : countOccurrences 메서드가 문자열에서 특정 문자열(2글자)이 몇 번 등장하는지 정확하게 반환한다.")
    void countOccurrencesCountTargetStringWhenTargetStringLengthIsTwo() {
        String testString = "AABABC";

        String targetSTring = "AB";

        int result = countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("기능29 테스트 : countOccurrences 메서드가 문자열에서 특정 문자열(3글자)이 몇 번 등장하는지 정확하게 반환한다.")
    void countOccurrencesCountTargetStringWhenTargetStringLengthIsThree() {
        String testString = "AABABC";

        String targetSTring = "ABC";

        int result = countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("기능29 테스트 : countOccurrences 메서드로 대상 문자열에 존재하지 않은 문자열 검색 시 0을 반환한다.")
    void countOccurrencesReturnZeroWhenTargetStringDoNotExistInTestString() {
        String testString = "AABABC";

        String targetSTring = "D";

        int result = countOccurrences(testString, targetSTring);

        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("기능37 테스트 : parseInt 메서드에 정수 형태의 문자열을 입력한 경우 int로 변환한다.")
    void parseIntShouldTransformIntStringToInt() {
        // given
        String target = "1";

        // when
        int result = parseInt(target);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("기능37 테스트 : parseInt 메서드에 소수 형태의 문자열을 입력한 경우 예외가 발생한다.")
    void parseIntShouldThrowExceptionWhenReceiveDoubleString() {
        // given
        String target = "1.1";

        // when, then
        assertThatThrownBy(() -> parseInt(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_A_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("기능37 테스트 : parseInt 메서드에 정수형태가 아닌 문자열을 입력한 경우 예외가 발생한다.")
    void parseIntShouldThrowExceptionWhenReceiveNotNumberString() {
        // given
        String target = "A";

        // when, then
        assertThatThrownBy(() -> parseInt(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_A_NUMBER.getErrorMessage());
    }
}