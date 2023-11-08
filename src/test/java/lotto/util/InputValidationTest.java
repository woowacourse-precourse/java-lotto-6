package lotto.util;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidationTest {
    @Test
    @DisplayName("빈 문자열 입력 시 예외 발생")
    void testEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateEmptyInput(""));
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateEmptyInput(null));
    }

    @Test
    @DisplayName("정수 입력이 아닌 경우 예외 발생")
    void testStringInput() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validationStringInput("abc"));
    }

    @Test
    @DisplayName("1,000원 단위가 아닌 경우 예외 발생")
    void testMoneyInput() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateMoneyInput(1500));
    }

    @Test
    @DisplayName("입력값에 숫자와 쉼표(,) 이외의 문자가 있을 경우 예외 발생")
    void testCommaSeparatedInput() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateCommaSeparatedInput("1,2,3,4,5,a"));
    }

    @Test
    @DisplayName("입력된 번호가 6개가 아닌 경우 예외 발생")
    void testInputSize() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputSize("1,2,3,4,5"));
    }

    @Test
    @DisplayName("입력된 번호가 1부터 45 사이의 숫자가 아닌 경우 예외 발생")
    void testInputRange() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateInputRange("1,2,46,7,8,9"));
    }

    @Test
    @DisplayName("중복된 번호가 있는 경우 예외 발생")
    void testDuplicateValues() {
        assertThrows(IllegalArgumentException.class, () -> InputValidation.validateDuplicateValues("1,2,3,4,5,5"));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외 발생")
    void testDuplicateBonusNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValidation.validateDuplicateBonusNumber("1,2,3,4,5,6", "6"));
    }
}
