package lotto.utils;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final String NULL_TEXT = null;
    private final String WHITE_SPACE_TEXT = " ";
    private final String BLANK_TEXT = "";
    private final String NOT_NUMBER_TEXT = "1NO";
    private final String NUMBER_TEXT = "1000";
    private final String ERROR_PREFIX_TEXT = "[ERROR]";

    @Test
    @DisplayName("입력값 NULL 예외 발생")
    void nullTest() {
        assertThatThrownBy(() -> InputValidator.nullCheck(NULL_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, "NULL 값이 입력 되었습니다.");
    }

    @Test
    @DisplayName("입력값 공백,빈값 예외 발생")
    void whiteSpaceBlankTest() {
        assertThatThrownBy(() -> InputValidator.blankCheck(WHITE_SPACE_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, "공백,빈 값이 입력 되었습니다.");
        assertThatThrownBy(() -> InputValidator.blankCheck(BLANK_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, "공백,빈 값이 입력 되었습니다.");
    }

    @Test
    @DisplayName("입력 값 Number type 아닌 경우 예외 발생")
    void NonNumberTypeTest() {
        assertThatThrownBy(() -> InputValidator.numberTypeCheck(NOT_NUMBER_TEXT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_PREFIX_TEXT, "숫자 타입의 값이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("입력 값 Number type 으로 변환 정상 처리")
    void numberTypeTest() {
        assertThatNoException().isThrownBy(() -> InputValidator.numberTypeCheck(NUMBER_TEXT));
    }


}