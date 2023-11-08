package lotto.validationTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.validation.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {

    private final InputValidation inputValidation = new InputValidation();

    @ParameterizedTest
    @ValueSource(strings = {"8000원", "5500"})
    @DisplayName("구입 금액 검증 테스트")
    public void validatePaymentTest(String input) {
        assertThatThrownBy(() -> inputValidation.validatePayment(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(findEachExceptionMessage(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3.4,5,6", "입력값들..", "1,2,3,3,4,5", "1,2,3,4,5"})
    @DisplayName("당첨 번호 검증 테스트")
    public void validateWinningNumbersTest(String input) {
        assertThatThrownBy(() -> {
            inputValidation.validateWinningNumbers(input);
        })
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(findEachExceptionMessage(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"팔십", "80"})
    @DisplayName("보너스 번호 검증 테스트")
    public void validateBonusNumberTest(String input) {
        assertThatThrownBy(() -> inputValidation.validateBonusNumber(input))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(findEachExceptionMessage(input));
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
        if (input.equals("8000원")) {
            return "[ERROR] 입력값이 숫자가 아닙니다.";
        }
        if (input.equals("5500")) {
            return "[ERROR] 구입 금액이 1000원 단위가 아닙니다.";
        }
        if (input.equals("팔십")) {
            return "[ERROR] 입력값이 숫자가 아닙니다.";
        }
        if (input.equals("80")) {
            return "[ERROR] 로또 번호의 범위는 1~45 입니다.";
        }
        return "알 수 없는 에러 발생";
    }
}
