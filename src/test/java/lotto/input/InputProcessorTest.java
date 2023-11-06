package lotto.input;

import static lotto.error.message.InvalidInputErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBER;
import static lotto.error.message.InvalidInputErrorMessage.NOT_A_NUMBER;
import static lotto.error.message.InvalidInputErrorMessage.OUT_OF_RANGE;
import static lotto.error.message.InvalidInputErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND;
import static lotto.error.message.InvalidInputErrorMessage.PURCHASE_AMOUNT_UNDER_THOUSAND;
import static lotto.error.message.InvalidInputErrorMessage.WINNING_NUMBERS_DUPLICATE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputProcessorTest {
    private final InputProcessor inputProcessor = new InputProcessor();

    @DisplayName("구입금액이 숫자가 아니다.")
    @Test
    void processPurchaseAmountNotInteger() {
        String input = "숫자가 아닙니다.";
        assertThatThrownBy(() -> inputProcessor.processPurchaseAmount(input))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(NOT_A_NUMBER.getMessage());
    }

    @DisplayName("구입금액이 1000원 미만이다.")
    @Test
    void processPurchaseAmountUnderThousand() {
        String input = "500";
        assertThatThrownBy(() -> inputProcessor.processPurchaseAmount(input))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(PURCHASE_AMOUNT_UNDER_THOUSAND.getMessage());
    }

    @DisplayName("구입금액이 1000의 배수가 아니다.")
    @Test
    void processPurchaseAmountNotMultipleOfThousand() {
        String input = "3333";
        assertThatThrownBy(() -> inputProcessor.processPurchaseAmount(input))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND.getMessage());
    }

    @DisplayName("숫자가 아닌 당첨번호가 존재한다.")
    @Test
    void processWinningNumberNotInteger() {
        String input = "1,2,문자,4,5,6";
        assertThatThrownBy(() -> inputProcessor.processWinningNumbers(input))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(NOT_A_NUMBER.getMessage());
    }

    @DisplayName("범위에서 벗어난 당첨번호가 존재한다.")
    @Test
    void processWinningNumberOutOfRange() {
        String input = "1,2,46,4,5,6";
        assertThatThrownBy(() -> inputProcessor.processWinningNumbers(input))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(OUT_OF_RANGE.getMessage());
    }

    @DisplayName("입력한 당첨번호에 중복이 존재한다.")
    @Test
    void processWinningNumbersDuplicate() {
        String input = "1,2,3,4,5,5";
        assertThatThrownBy(() -> inputProcessor.processWinningNumbers(input))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(WINNING_NUMBERS_DUPLICATE.getMessage());
    }

    @DisplayName("보너스번호가 숫자가 아니다.")
    @Test
    void processBonusNumberNotInteger() {
        String input = "숫자가 아닙니다.";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputProcessor.processBonusNumber(input, winningNumbers))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(NOT_A_NUMBER.getMessage());
    }

    @DisplayName("보너스번호가 범위를 벗어난다.")
    @Test
    void processBonusNumberOutOfRange() {
        String input = "0";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputProcessor.processBonusNumber(input, winningNumbers))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(OUT_OF_RANGE.getMessage());
    }

    @DisplayName("보너스번호가 당첨번호와 중복된다.")
    @Test
    void processBonusNumberInWinningNumbers() {
        String input = "3";
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> inputProcessor.processBonusNumber(input, winningNumbers))
                .isInstanceOf(InvalidInputException.class)
                .extracting("message")
                .isEqualTo(BONUS_NUMBER_IN_WINNING_NUMBER.getMessage());
    }
}