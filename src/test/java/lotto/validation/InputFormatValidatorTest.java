package lotto.validation;

import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static lotto.message.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;


class InputFormatValidatorTest {
    private static final String duplidateWinningNumberInput1 = "1,2,3,4,5,1";
    private static final String duplidateWinningNumberInput2 = "41,42,43,44,45,43";
    private static final String duplidateWinningNumberInput3 = "2,5,13,27,13,39";

    private static final String outOfRangeWinningNumberInput1 = "1,2,3,4,5,46";
    private static final String outOfRangeWinningNumberInput2 = "1,32,44,47,51,300";

    private static final String notAscendingWinningNumberInput1 = "1,2,3,4,6,5";
    private static final String notAscendingWinningNumberInput2 = "2,5,13,39,28,45";
    private static final String notAscendingWinningNumberInput3 = "4,3,2,1,5,6";

    private static final String duplidateBonusNumberInput1 = "1";
    private static final String duplidateBonusNumberInput2 = "30";
    private static final String duplidateBonusNumberInput3 = "45";

    @DisplayName("1,000원 단위의 양의 정수 값을 입력하면 IllegalArgumentException이 발생하지 않는다.")
    @ParameterizedTest
    @CsvSource({"1000", "3000", "10000", "600000", "7000000"})
    void validateMoneyFormatFromMultipleOfLottoPricePositiveInteger(String purchaseAmountInput) {
        // given, when, then
        InputFormatValidator.validateMoneyFormat(purchaseAmountInput);
    }

    @DisplayName("양의 정수가 아닌 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "-1", "가나다라마바사", "abcdef", "12ab가나", "ab12가나"})
    void validateMoneyFormatFromNotPositiveInteger(String purchaseAmountInput) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateMoneyFormat(purchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }

    @DisplayName("1,000원 단위가 아닌 양의 정수 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"0", "가나다라마바사", "abcdef", "12ab가나", "ab12가나", "-1"})
    void validateMoneyFormatFromNotMultipleOfLottoPricePositiveInteger(String purchaseAmountInput) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateMoneyFormat(purchaseAmountInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_MONEY_INPUT_EXCEPTION);
    }

    @DisplayName("유효한 값을 입력하면 IllegalArgumentException이 발생하지 앟는다.")
    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5,6'", "'40,41,42,43,44,45'", "'1,3,16,28,37,45'", "'2,8,10,15,22,36'"})
    void validateWinningNumbersWithValidValue(String winningNumbersInput) {
        // given, when, then
        InputFormatValidator.validateWinningNumbers(winningNumbersInput);

    }

    @DisplayName("입력한 값이 설정한 개수가 아니거나, 유효하지 않은 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"'0,1,2,3,4,5'", "'-1,41,42,43,44,45'", "'1, 2, 3, 4, 5, 6'",
            "'1,2,3,4,5'", "'가,나,다,라,마,바'", "'a,1,b,2,c,3'"})
    void validateWinningNumbersWithInvalidValue(String winningNumbersInput) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateWinningNumbers(winningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_WINNING_NUMBER_INPUT_EXCEPTION);

    }

    @DisplayName("입력한 값에 중복된 숫자가 있으면 IllegalArgumentException이 발생한다.")
    @Test
    void validateWinningNumbersWithDuplicateNumber() {
        // given, when, then
        throwDuplicateExceptionForInput(duplidateWinningNumberInput1, 1, 6, 1);
        throwDuplicateExceptionForInput(duplidateWinningNumberInput2, 3, 6, 43);
        throwDuplicateExceptionForInput(duplidateWinningNumberInput3, 3, 5, 13);
    }

    @DisplayName("입력한 모든 숫자가 설정된 로또 번호의 최댓값보다 크면 IllegalArgumentException이 발생한다.")
    @Test
    void validateWinningNumbersWithOutOfRange() {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator.validateWinningNumbers(outOfRangeWinningNumberInput1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + NUMBER_OUT_OF_RANGE_EXCEPTION + 46);

        assertThatThrownBy(() -> InputFormatValidator.validateWinningNumbers(outOfRangeWinningNumberInput2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + NUMBER_OUT_OF_RANGE_EXCEPTION + 47);
    }

    @DisplayName("입력한 값에 중복된 숫자가 있으면 IllegalArgumentException이 발생한다.")
    @Test
    void validateWinningNumbersWithNotAscendingOrder() {
        // given, when, then
        throwNotAscendingExceptionForInput(notAscendingWinningNumberInput1, 5, 6, 6, 5);
        throwNotAscendingExceptionForInput(notAscendingWinningNumberInput2, 4, 5, 39, 28);
        throwNotAscendingExceptionForInput(notAscendingWinningNumberInput3, 1, 2, 4, 3);
    }

    @DisplayName("유효한 값을 입력하면 IllegalArgumentException이 발생하지 앟는다.")
    @ParameterizedTest
    @CsvSource({"1", "45", "23"})
    void validateBonusNumberWithValidValue(String bonusNumberInput) {
        // given, when, then
        InputFormatValidator.validateBonusNumber(bonusNumberInput, mock(WinningNumbers.class));
    }

    @DisplayName("유효하지 않은 값을 입력하면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"-1", "0", "abc", "12ab", "ab12", "가나다"})
    void validateBonusNumberWithInvalidValue(String bonusNumberInput) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator
                .validateBonusNumber(bonusNumberInput, mock(WinningNumbers.class)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + INVALID_BONUS_NUMBER_INPUT_EXCEPTION);
    }

    @DisplayName("입력한 숫자가 설정된 로또 번호의 최댓값보다 크면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"1", "45", "30"})
    void validateBonusNumberWithDuplicateNumber(String bonusNumberInput) {
        // given
        WinningNumbers winningNumbers = WinningNumbers.of(List.of(1, 2, 23, 30, 38, 45));

        // when, then
        throwDuplicateExceptionForInput(duplidateBonusNumberInput1, winningNumbers, 1);
        throwDuplicateExceptionForInput(duplidateBonusNumberInput2, winningNumbers, 4);
        throwDuplicateExceptionForInput(duplidateBonusNumberInput3, winningNumbers, 6);
    }

    @DisplayName("입력한 숫자가 설정된 로또 번호의 최댓값보다 크면 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @CsvSource({"46", "50", "301"})
    void validateBonusNumberWithOutOfRange(String bonusNumberInput) {
        // given, when, then
        assertThatThrownBy(() -> InputFormatValidator
                .validateBonusNumber(bonusNumberInput, mock(WinningNumbers.class)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + NUMBER_OUT_OF_RANGE_EXCEPTION + bonusNumberInput);
    }

    private void throwDuplicateExceptionForInput
            (String duplidateWinningNumberInput, int firstIndex, int nextIndex, int duplicateNumber) {
        assertThatThrownBy(() -> InputFormatValidator.validateWinningNumbers(duplidateWinningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(
                        ERROR_MESSAGE_HEAD + DUPLICATE_NUMBER_EXCEPTION
                                + firstIndex + NUMBER_INDICATION + duplicateNumber + ", "
                                + nextIndex + NUMBER_INDICATION + duplicateNumber
                );
    }

    private void throwDuplicateExceptionForInput(String bonusNumberInput, WinningNumbers winningNumbers, int index) {
        assertThatThrownBy(() -> InputFormatValidator
                .validateBonusNumber(bonusNumberInput, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE_HEAD + DUPLICATE_NUMBER_EXCEPTION + index + NUMBER_INDICATION + bonusNumberInput);
    }

    private void throwNotAscendingExceptionForInput
            (String notAscendingWinningNumberInput, int firstIndex, int nextIndex, int firstNumber, int secondNumber) {
        assertThatThrownBy(() -> InputFormatValidator.validateWinningNumbers(notAscendingWinningNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(
                        ERROR_MESSAGE_HEAD + INVALID_NUMBERS_ORDER_EXCEPTION
                                + firstIndex + NUMBER_INDICATION + firstNumber + ", "
                                + nextIndex + NUMBER_INDICATION + secondNumber
                );
    }
}
