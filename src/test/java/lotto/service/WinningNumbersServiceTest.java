package lotto.service;

import lotto.constants.AppConstants;
import lotto.constants.ErrorConstants;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class WinningNumbersServiceTest {
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("당첨번호의 갯수가 6개가 아닌경우 에러 발생")
    void validateArrayLengthError(String purchaseAmount) {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        String[] arr = purchaseAmount.split(AppConstants.INPUT_DELIMITER);

        Assertions.assertThatThrownBy(
                        () -> winningNumbersService.checkArrayLength(arr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_LENGTH.getData());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    @DisplayName("당첨번호의 갯수가 6개인 경우 정상")
    void validateArrayLengthNormal(String purchaseAmount) {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        String[] arr = purchaseAmount.split(AppConstants.INPUT_DELIMITER);

        assertThatCode(() -> winningNumbersService.checkArrayLength(arr))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6a", "1에,2,3,4,5,6,7"})
    @DisplayName("당첨번호에 숫자가 아닌 값이 포할된 경우 에러 발생")
    void validateArrayNumericError(String purchaseAmount) {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        String[] arr = purchaseAmount.split(AppConstants.INPUT_DELIMITER);

        Assertions.assertThatThrownBy(
                        () -> winningNumbersService.checkNumeric(arr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_NUMERIC.getData());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    @DisplayName("당첨번호에 숫자만 있을 경우 정상")
    void validateArrayNumericNormal(String purchaseAmount) {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        String[] arr = purchaseAmount.split(AppConstants.INPUT_DELIMITER);

        assertThatCode(() -> winningNumbersService.checkNumeric(arr))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("0 이하의 로또 번호가 존재할 경우 에러 발생")
    void validateArrayRangeErrorLessZero() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        List<Integer> list = List.of(1,0,3,4,5,6);

        Assertions.assertThatThrownBy(
                        () -> winningNumbersService.checkWinningNumRange(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_RANGE.getData());
    }
    @Test
    @DisplayName("46 이상의 로또 번호가 존재할 경우 에러 발생")
    void validateArrayRangeErrorBigger() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        List<Integer> list = List.of(46,1,3,4,5,6);

        Assertions.assertThatThrownBy(
                        () -> winningNumbersService.checkWinningNumRange(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_RANGE.getData());
    }

    @Test
    @DisplayName("1~45사이의 로또 번호만 존재할 경우 정상")
    void validateArrayRangeNormal() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        List<Integer> list = List.of(45,1,3,4,5,6);

        assertThatCode(() -> winningNumbersService.checkWinningNumRange(list))
                .doesNotThrowAnyException();
    }
    @Test
    @DisplayName("중복된 로또 번호가 존재할 경우 에러 발생")
    void validateArrayDuplicateError() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        List<Integer> list = List.of(45,45,1,1,5,6);

        Assertions.assertThatThrownBy(
                        () -> winningNumbersService.checkWinningNumDuplicate(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_WINNING_DUPLICATE.getData());
    }

    @Test
    @DisplayName("중복된 로또 번호가 존재하지 않을 경우 정상")
    void validateArrayDuplicateNormal() {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        List<Integer> list = List.of(45,1,3,4,5,6);

        assertThatCode(() -> winningNumbersService.checkWinningNumDuplicate(list))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45, 4, 9})
    @DisplayName("구매 금액이 숫자인 경우 정상")
    void validateBonusNumberRangeNormal(int bonusNum) {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        assertThatCode(() -> winningNumbersService.checkRange(bonusNum))
                .doesNotThrowAnyException();
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1, 999})
    @DisplayName("보너스 번호가 1~45 이외의 값일 경우 에러 발생")
    void validateBonusNumberRangeError(int bonusNum) {
        WinningNumbersService winningNumbersService = new WinningNumbersService();
        Assertions.assertThatThrownBy(
                        () -> winningNumbersService.checkRange(bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConstants.INVALID_BONUS_NUMBER_RANGE.getData());
    }
}
