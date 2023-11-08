package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.controller.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("당첨 번호 입력 길이가 잘못되었을 때 예외를 발생시킨다")
    @Test
    void validateUserInputWinningNumbers_IncorrectLength() {
        String rawWinningNumbers = "1, 2, 3, 4, 5";

        assertThatThrownBy(() -> InputValidator.validateUserInputWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 중복된 숫자가 있을 때 예외를 발생시킨다")
    @Test
    void validateUserInputWinningNumbers_ContainsDuplicates() {
        String rawWinningNumbers = "1, 2, 3, 4, 5, 5";

        assertThatThrownBy(() -> InputValidator.validateUserInputWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호 입력에 유효 범위를 벗어난 숫자가 있을 때 예외를 발생시킨다")
    @Test
    void validateUserInputWinningNumbers_OutOfRange() {
        String rawWinningNumbers = "0, 2, 3, 4, 5, 6";

        assertThatThrownBy(() -> InputValidator.validateUserInputWinningNumbers(rawWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격 입력이 숫자가 아닐 때 예외를 발생시킨다")
    @Test
    void validateUserInputPrice_NonNumeric() {
        String rawPrice = "abc";

        assertThatThrownBy(() -> InputValidator.validateUserInputPrice(rawPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격 입력이 로또 티켓 가격 미만일 때 예외를 발생시킨다")
    @Test
    void validateUserInputPrice_LessThanTicketPrice() {
        String rawPrice = "500";

        assertThatThrownBy(() -> InputValidator.validateUserInputPrice(rawPrice))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 숫자가 아닐 때 예외를 발생시킨다")
    @Test
    void validateUserInputBonusNumber_NonNumeric() {
        String rawBonusNumber = "bonus";

        assertThatThrownBy(() -> InputValidator.validateUserInputBonusNumber(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력이 유효 범위를 벗어났을 때 예외를 발생시킨다")
    @Test
    void validateUserInputBonusNumber_OutOfRange() {
        String rawBonusNumber = "50";

        assertThatThrownBy(() -> InputValidator.validateUserInputBonusNumber(rawBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}