package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final String NULL_TEXT = null;
    private final String WHITE_SPACE_TEXT = " ";
    private final String BLANK_TEXT = "";
    private final String NOT_NUMBER_TEXT = "1NO";
    private final String NUMBER_TEXT = "1000";

    @Test
    @DisplayName("입력값 null 예외 발생")
    void nullTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> InputValidator.nullCheck(NULL_TEXT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값 공백,빈값 예외 발생")
    void whiteSpaceBlankTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> InputValidator.blankCheck(WHITE_SPACE_TEXT))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.blankCheck(BLANK_TEXT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 Number type 아닌 경우 예외 발생")
    void NonNumberTypeTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> InputValidator.numberTypeCheck(NOT_NUMBER_TEXT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 Number type 으로 변환 정상 처리")
    void numberTypeTest() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        int number = InputValidator.numberTypeCheck(NUMBER_TEXT);
        assertThat(number).isEqualTo(1000);
    }


}