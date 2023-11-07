package lotto.util.validator;

import lotto.constant.ErrorMessage;
import lotto.vo.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusNumberValidatorTest {

    static Stream<Arguments> validBonusNumberProvider() {
        return Stream.of(
                Arguments.of(1, List.of(2, 3, 4, 5, 6, 7)),
                Arguments.of(45, List.of(8, 9, 10, 11, 12, 13))
        );
    }

    @ParameterizedTest
    @MethodSource("validBonusNumberProvider")
    @DisplayName("보너스 숫자가 유효 범위 내이고 당첨 번호와 겹치지 않을 경우 예외가 발생하지 않아야 한다.")
    void testValidBonusNumber(int bonusNumber, List<Integer> winningNumbersList) {
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumbersList);
        BonusNumberValidator validator = new BonusNumberValidator(winningNumbers);
        assertDoesNotThrow(() -> validator.validate(bonusNumber));
    }

    static Stream<Arguments> bonusNumberDuplicatedWithWinningNumbersProvider() {
        return Stream.of(
                Arguments.of(2, List.of(2, 3, 4, 5, 6, 7)),
                Arguments.of(6, List.of(1, 3, 4, 5, 6, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("bonusNumberDuplicatedWithWinningNumbersProvider")
    @DisplayName("보너스 숫자가 당첨 번호와 겹칠 경우 IllegalArgumentException을 던져야 한다.")
    void testBonusNumberDuplicatedWithWinningNumbers(int bonusNumber, List<Integer> winningNumbersList) {
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumbersList);
        BonusNumberValidator validator = new BonusNumberValidator(winningNumbers);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(bonusNumber));
        Assertions.assertEquals(ErrorMessage.BONUS_IS_DUPLICATED, exception.getMessage());
    }

    static Stream<Arguments> bonusNumberOutOfRangeProvider() {
        return Stream.of(
                Arguments.of(0, List.of(2, 3, 4, 5, 6, 7)),
                Arguments.of(46, List.of(1, 3, 4, 5, 6, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("bonusNumberOutOfRangeProvider")
    @DisplayName("보너스 숫자가 유효 범위 밖일 경우 IllegalArgumentException을 던져야 한다.")
    void testBonusNumberOutOfRange(int bonusNumber, List<Integer> winningNumbersList) {
        WinningNumbers winningNumbers = WinningNumbers.from(winningNumbersList);
        BonusNumberValidator validator = new BonusNumberValidator(winningNumbers);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> validator.validate(bonusNumber));
        Assertions.assertEquals(ErrorMessage.WINNING_NUMBERS_IS_NOT_VALID_RANGE, exception.getMessage());
    }
}
