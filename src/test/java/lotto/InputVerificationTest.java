package lotto;

import lotto.verification.InputVerification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputVerificationTest {
    private static InputVerification inputVerification = new InputVerification();

    @Test
    @DisplayName("당첨번호의 입력 개수가 옳지 않은 경우 false 반환")
    public void winningNumbersInvalidInputSizeTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        boolean isValid = inputVerification.verifyWinningNumbers(numbers);

        assertFalse(isValid);
    }

    @Test
    @DisplayName("당첨번호의 숫자 범위가 옳지 않은 경우 false 반환")
    public void winningNumbersInvalidRangeTest() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 46, 47);

        boolean isValid = inputVerification.verifyWinningNumbers(numbers);

        assertFalse(isValid);
    }

    @Test
    @DisplayName("당첨번호가 중복된 경우")
    public void winningNumbersDuplicateNumbersTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5);

        boolean isValid = inputVerification.verifyWinningNumbers(numbers);

        assertFalse(isValid);
    }

    @Test
    @DisplayName("당첨번호가 유효한 경우 true")
    public void testBonusNumberValidInput() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        boolean isValid = inputVerification.verifyWinningNumbers(numbers);

        assertTrue(isValid);
    }

    @DisplayName("보너스번호의 숫자번위가 옳지 않은 경우")
    @Test
    void bonusNumberInvalidInputRangeTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean isValid = inputVerification.verifyBonusNumber(winningNumbers, 46);

        assertFalse(isValid);
    }

    @DisplayName("보너스 번호 중복")
    @Test
    void bonusNumberDuplicateTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean isValid = inputVerification.verifyBonusNumber(winningNumbers, 3);

        assertFalse(isValid);
    }

    @DisplayName("보너스 번호 유효입력")
    @Test
    void bonusNumberValidTest() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        boolean isValid = inputVerification.verifyBonusNumber(winningNumbers, 7);

        assertTrue(isValid);
    }
}
