package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {
    WinningNumbers winningNumbers = new WinningNumbers();

    @DisplayName("당첨 번호 입력값이 null이면 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    void createWinningLottoByNullString(String input) {
        //given
        final String nullString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initWinningLotto(nullString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("당첨 번호 입력값이 비어있으면 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    void createWinningLottoByEmptyString(String input) {
        //given
        final String emptyString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initWinningLotto(emptyString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("쪼개진 당첨 번호 입력값이 null이거나 비어있으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"", ",", ",,", ", ", " , ", " ,", "1,", ",1", "1,,", ",1,", ",,1", "1,2,3,4,5,6,,"})
    void createWinningLottoByNullOrEmptyString(String input) {
        //given
        final String nullOrEmptyString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initWinningLotto(nullOrEmptyString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("쪼개진 당첨 번호 입력값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1, a", "1,+", "1,-", "a,1", "+,1", "-,1", "a1"})
    void createWinningLottoByNotNumber(String input) {
        //given
        final String notNumberString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initWinningLotto(notNumberString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.WINNING_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("쪼개진 당첨 번호 입력값이 6개의 중복없는 숫자로 이루어져 있으면 정상적으로 작동한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void createWinningLottoByValidNumbers(String input) {
        //given
        final String validNumbers = input;

        // when, then
        assertThatCode(() -> winningNumbers.initWinningLotto(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호 입력값이 null이면 예외가 발생한다.")
    @ParameterizedTest
    @NullSource
    void createBonusNumberByNullString(String input) {
        //given
        final String nullString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initBonusNumber(nullString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.BONUS_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("보너스 번호 입력값이 비어있으면 예외가 발생한다.")
    @ParameterizedTest
    @EmptySource
    void createBonusNumberByEmptyString(String input) {
        //given
        final String emptyString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initBonusNumber(emptyString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.BONUS_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("보너스 번호 입력값이 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "+", "-", "1a", "1+", "1-", "a1"})
    void createBonusNumberByNotNumber(String input) {
        //given
        final String notNumberString = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initBonusNumber(notNumberString));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.BONUS_LOTTO_NOT_NUMBER_EXCEPTION);
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void createBonusNumberByOutOfRangeNumber(String input) {
        //given
        final String outOfRangeNumber = input;

        //when
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initBonusNumber(outOfRangeNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.BONUS_NUMBER_RANGE_INVALID_EXCEPTION);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void createBonusNumberByDuplicateNumber() {
        //given
        final String winningLotto = "1,2,3,4,5,6";
        final String duplicateNumber = "1";

        //when
        winningNumbers.initWinningLotto(winningLotto);
        final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> winningNumbers.initBonusNumber(duplicateNumber));

        //then
        assertThat(exception.getMessage()).isEqualTo(WinningNumbers.BONUS_NUMBER_DUPLICATE_EXCEPTION);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자면 정상적으로 작동한다.")
    @Test
    void createBonusNumberByValidNumber() {
        //given
        final String winningLotto = "1,2,3,4,5,6";
        final String validNumber = "7";

        // when, then
        winningNumbers.initWinningLotto(winningLotto);
        assertThatCode(() -> winningNumbers.initBonusNumber(validNumber))
                .doesNotThrowAnyException();
    }
}
