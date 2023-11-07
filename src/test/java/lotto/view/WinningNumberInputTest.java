package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.validator.InputValidator;
import lotto.validator.NumberInputValidator;
import lotto.validator.WinningNumberInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberInputTest {

    private final InputValidator numberInputValidator = new NumberInputValidator();

    @Test
    @DisplayName("당첨 번호 입력이 유효한 경우 예외가 발생하지 않아야 함")
    void validateWithValidInput() {
        InputValidator inputValidator = new WinningNumberInputValidator(numberInputValidator);
        WinningNumberInput input = new WinningNumberInput(inputValidator);
        String validInput = "1,2,3,4,5,6";
        assertThatCode(() -> input.validate(validInput)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호 입력이 유효하지 않은 경우 예외가 발생해야 함")
    void validateWithInvalidInput() {
        InputValidator inputValidator = new WinningNumberInputValidator(numberInputValidator);
        WinningNumberInput input = new WinningNumberInput(inputValidator);
        String invalidInput = "1,2,3,3,4,5";
        assertThatCode(() -> input.validate(invalidInput)).hasMessageContaining("로또 번호는 서로다른 6자리로 입력해주세요.");
    }

}
