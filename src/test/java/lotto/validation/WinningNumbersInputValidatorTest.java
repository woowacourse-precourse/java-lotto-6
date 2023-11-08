package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersInputValidatorTest {
    @DisplayName("당첨번호 입력값이 빈 문자열인 경우 예외 발생")
    @Test
    void validate_NotEmpty_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 쉼표가 포함되지 않은 경우 예외 발생")
    @Test
    void validate_ContainsComma_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate("1 2 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값의 숫자 개수가 6개가 아닌 경우 예외 발생")
    @Test
    void validate_NumberCount_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 문자가 포함된 경우 예외 발생")
    @Test
    void validate_CorrectNumbers_InvalidNumber_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate("1,2,3,4,a,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 1~45 범위 아닐 시 예외 발생")
    @Test
    void validate_CorrectNumbers_InvalidRange_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate("1,2,3,4,50,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 자연수가 아닌 숫자가 포함된 경우 예외 발생")
    @Test
    void validate_CorrectNumbers_NotNaturalNumber_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate("1,2,3,4,-5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호 입력값에 중복된 숫자가 포함된 경우 예외 발생")
    @Test
    void validate_NoDuplicate_ExceptionThrown() {
        assertThatThrownBy(() -> WinningNumbersInputValidator.validate("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}