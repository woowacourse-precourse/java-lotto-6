package lotto.validationTest;

import lotto.validation.WinningNumbersInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningNumbersInputValidatorTest {

    @DisplayName("당첨 번호 정상 입력 테스트")
    @Test
    public void testValidWinningNumbers() {
        String validNumbers = "1,2,3,4,5,6";

        assertThatCode(() -> WinningNumbersInputValidator.validate(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호를 6개 입력하지 않았을 때 예외 처리")
    @Test
    public void testNotSixDigitNumbers() {
        String invalidNumbers = "1,2,3,4,5";

        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbersInputValidator.validate(invalidNumbers))
                .withMessage("로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있을 때 예외 처리")
    @Test
    public void testDuplicateNumbers() {
        String invalidNumbers = "1,2,3,4,5,5";

        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbersInputValidator.validate(invalidNumbers))
                .withMessage("로또 번호에 중복된 숫자가 있습니다.");
    }

    @DisplayName("당첨 번호들이 1~45 사이의 숫자가 아닐 때 예외처리")
    @Test
    public void testOutOfRangeNumbers() {
        String invalidNumbers = "0,2,3,46,5,6";

        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbersInputValidator.validate(invalidNumbers))
                .withMessage("로또 번호는 1~45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호 입력시 구분자가 , 인지 테스트")
    @Test
    public void testInvalidSeparator() {
        String invalidNumbers = "1;2;3;4;5;6";

        assertThatIllegalArgumentException().isThrownBy(() -> WinningNumbersInputValidator.validate(invalidNumbers))
                .withMessage("로또 번호는 쉼표(,)로 구분되어야 합니다.");
    }
}