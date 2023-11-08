package validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.IllegalComponentStateException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest {

    private final ExceptionHandler exceptionHandler;

    public ExceptionHandlerTest() {
        exceptionHandler = new ExceptionHandler();
    }

    @Test
    @DisplayName("구매 가격 입력 시 숫자 이외의 것이 입력되면 예외 발생")
    void validateIfOnlyNumber() {
        String number = "1000?";
        assertThrows(NumberFormatException.class, () -> {
            exceptionHandler.validateIfOnlyNumber(number);
        });
    }

    @Test
    @DisplayName("구매 가격 입력 시 1000의 배수가 아닐 때 예외 발생")
    void validateIfPriceToBuyMultipleOfThousand() {
        int number = 1234;
        assertThrows(IllegalStateException.class, () -> {
            exceptionHandler.validateMultipleOfThousand(number);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 시 숫자가 아닌 것이 입력 될 시 예외 발생")
    void validateBonusNumberIfOnlyNumber() {
        String bonusNumber = "1000?";
        assertThrows(NumberFormatException.class, () -> {
            exceptionHandler.validateIfOnlyNumber(bonusNumber);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 시 1부터 45가 아닌 숫자가 입력될 시 예외 발생")
    void validateBonusNumberIfOneToFourtyFive() {
        int bonusNumber = 47;
        assertThrows(IllegalArgumentException.class, () -> {
            exceptionHandler.validateBonusNumberOneToFourtyFive(bonusNumber);
        });
    }

    @Test
    @DisplayName("보너스 번호 입력 시 당첨 번호에 이미 있는 번호 입력 시 예외 발생")
    void validateBonusNumberIfExistInWinningNumbers() {
        int bonusNumber = 1;
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThrows(IllegalStateException.class, () -> {
            exceptionHandler.validateExistInWinningNumbers(winningNumbers, bonusNumber);
        });

    }

    @Test
    @DisplayName("당첨 번호 입력 시 숫자 혹은 콤마만 입력되지 않으면 예외 발생")
    void validateWinningNumberNumberOrComma() {
        String winningNumber = "1,2,3,?,5,6";
        assertThrows(IllegalArgumentException.class, () -> {
            exceptionHandler.validateWinningNumberNumberOrComma(winningNumber);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 시 숫자가 6개가 아닌 경우 예외 발생")
    void validateWinningNumberOnlySixNumbers() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalStateException.class, () -> {
            exceptionHandler.validateOnlySixNumber(winningNumbers);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 시 중복되는 숫자 입력할 시 예외 발생")
    void validateWinningNumberNoSameNumber() {
        List<Integer> winningNumber = List.of(1, 1, 3, 4, 5, 6);
        assertThrows(IllegalComponentStateException.class, () -> {
            exceptionHandler.validateWinningNumberNoSameNumber(winningNumber);
        });
    }

    @Test
    @DisplayName("당첨 번호 입력 시 1부터 45까지의 숫자가 아닌 숫자가 입력될 시 예외 발생")
    void validateWinningNumberOneToFourtyFive() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 47);
        assertThrows(NumberFormatException.class, () -> {
            exceptionHandler.validateWinningNumberOneToFourtyFive(winningNumber);
        });
    }
}