package lotto.utils;

import static lotto.constants.ErrorMessage.ERROR_BLANK_INPUT;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_CONTAINS_BONUS;
import static lotto.constants.ErrorMessage.ERROR_LOTTO_NUMBER_FORMAT;
import static lotto.constants.ErrorMessage.ERROR_NON_NUMBER_TYPE_INPUT;
import static lotto.constants.ErrorMessage.ERROR_NULL_INPUT;
import static lotto.constants.TestGlobalConstant.ERROR_PREFIX_TEXT;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    private static final String NULL_TEXT = null;
    private static final String WHITE_SPACE_TEXT = " ";
    private static final String BLANK_TEXT = "";
    private static final String NOT_NUMBER_TEXT = "1NO";
    private static final String NUMBER_TEXT = "1000";

    @Test
    @DisplayName("입력값 NULL 예외 발생")
    void nullTest() {
        assertThatThrownBy(() -> InputValidator.nullCheck(NULL_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_NULL_INPUT.getMessage());
    }

    @ParameterizedTest
    @MethodSource("whiteSpaceBlankData")
    @DisplayName("입력값 공백,빈값 예외 발생")
    void whiteSpaceBlankTest(String inputValue, String errorPrefix, String errorMessage) {
        assertThatThrownBy(() -> InputValidator.blankCheck(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorPrefix, errorMessage);
    }

    static Stream<Arguments> whiteSpaceBlankData() {
        return Stream.of(
                Arguments.of(WHITE_SPACE_TEXT, ERROR_PREFIX_TEXT, ERROR_BLANK_INPUT.getMessage()),
                Arguments.of(BLANK_TEXT, ERROR_PREFIX_TEXT, ERROR_BLANK_INPUT.getMessage())
        );
    }

    @Test
    @DisplayName("입력 값 Number type 아닌 경우 예외 발생")
    void nonNumberTypeTest() {
        assertThatThrownBy(() -> InputValidator.numberTypeCheck(NOT_NUMBER_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_NON_NUMBER_TYPE_INPUT.getMessage());
    }

    @Test
    @DisplayName("입력 값 Number type 으로 변환 정상 처리")
    void numberTypeTest() {
        assertThatNoException().isThrownBy(() -> InputValidator.numberTypeCheck(NUMBER_TEXT));
    }

    @ParameterizedTest
    @DisplayName("입력 값 숫자와 , 로 이루 어진 값이 아닌 경우 예외 처리")
    @ValueSource(strings = {"1,23,12,ㅂ", "1.231,23,1", "ㅁㄴ", " ", "", " 12,2,3,5,6,7"})
    void NumberAndCommaExceptionTest(String inputValue) {
        assertThatThrownBy(() -> InputValidator.lottoFormatCheck(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_LOTTO_NUMBER_FORMAT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("입력 값 숫자와 , 로 이루 어진 값의 경우 정상 처리")
    @ValueSource(strings = {"1,2,3,4,5,6", "6,7,8,9,10,11", "12,13,14,15,16,17"})
    void NumberAndCommaTest(String inputValue) {
        assertThatNoException().isThrownBy(() -> InputValidator.lottoFormatCheck(inputValue));
    }

    @ParameterizedTest
    @DisplayName("입력 값 1 ~ 45 범위 값이 아닌 경우 예외 처리")
    @ValueSource(strings = {"46", "0", "100"})
    void numberRangeTest(String inputValue) {
        assertThatThrownBy(() -> InputValidator.lottoNumberRangeCheck(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, ERROR_LOTTO_CONTAINS_BONUS.getMessage());
    }


}