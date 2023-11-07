package lotto.validationTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {

    private final InputValidation inputValidation = new InputValidation();

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우")
    public void isNameTest() {
        assertThatThrownBy(() -> {
            inputValidation.isNumber("8000원");
        })
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값이 숫자가 아닙니다.");
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아닌 경우")
    public void isThousandMultipleTest() {
        assertThatThrownBy(() -> {
            inputValidation.isThousandMultiple("5500");
        })
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3.4,5,6", "입력값들..", "1,2,3,3,4,5", "1,2,3,4,5"})
    @DisplayName("당첨 번호 검증 테스트")
    public void validateWinningNumbers(String input) {
        assertThatThrownBy(() -> {
            inputValidation.validateWinningNumbers(input);
        })
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(findEachExceptionMessage(input));
    }

    private String findEachExceptionMessage(String input) {
        if (input.equals("1,2,3.4,5,6")) {
            return "[ERROR] 입력값이 숫자가 아닙니다.";
        }
        if (input.equals("입력값들..")) {
            return "[ERROR] 입력값이 숫자가 아닙니다.";
        }
        if (input.equals("1,2,3,3,4,5")) {
            return "[ERROR] 당첨 번호가 6가지가 아닙니다.";
        }
        if (input.equals("1,2,3,4,5")) {
            return "[ERROR] 당첨 번호가 6가지가 아닙니다.";
        }
        return "알 수 없는 에러 발생";
    }
}
