package lotto.view;

import static org.assertj.core.api.Assertions.assertThatCode;

import lotto.validator.InputValidator;
import lotto.validator.NumberInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberInputTest {

    @Test
    @DisplayName("보너스 번호에 유효한 입력을 하면 예외가 발생하지 않아야 함")
    void validateWithValidInput() {
        BonusNumberInput input = new BonusNumberInput();
        String validInput = "7";
        assertThatCode(() -> input.validate(validInput)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("보너스 번호에 유효하지 않은 입력을 하면 예외가 발생해야 함")
    void validateWithInvalidInput() {
        InputValidator inputValidator = new NumberInputValidator();
        BonusNumberInput input = new BonusNumberInput();
        String invalidInput = "abc";
        assertThatCode(() -> input.validate(invalidInput)).hasMessageContaining("유효한 숫자로 입력하시길 바랍니다.");
    }

}
