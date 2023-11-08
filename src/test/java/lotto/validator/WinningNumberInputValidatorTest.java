package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumberInputValidatorTest {

    private InputValidator numberInputValidator;
    private WinningNumberInputValidator winningNumberInputValidator;

    @BeforeEach
    void setUp() {
        numberInputValidator = mock(InputValidator.class);
        winningNumberInputValidator = new WinningNumberInputValidator(numberInputValidator);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateWithValidInput() {
        String input = "1,2,3,4,5,6";
        winningNumberInputValidator.validate(input);
        for (String number : input.split(",")) {
            verify(numberInputValidator).validate(number);
        }
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateWithInvalidInput_DuplicateNumbers() {
        String input = "1,2,3,3,4,5";
        assertThatThrownBy(() -> winningNumberInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 서로다른 6자리로 입력해주세요.");
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateWithInvalidInput_WrongNumberOfNumbers() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> winningNumberInputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 서로다른 6자리로 입력해주세요.");
    }
    
}
