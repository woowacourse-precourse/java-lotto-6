package lotto.domain;

import lotto.view.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class WinningNumbersTest {
    private final String ERROR_PHRASES = "[ERROR]";

    @DisplayName("당첨 번호의 갯수가 6미만일 경우 예외 처리")
    @Test
    void winningNumbersLengthLessThanSize() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 3, 4, 5);

        //then
        assertThatThrownBy(() -> winningNumbers.validateWinningNumberInputSize(winningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SIX_NUMBER.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("당첨 번호의 갯수가 6초과일 경우 예외 처리")
    @Test
    void winningWinningNumbersLengthOverThanSize() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 3, 4, 5, 6, 7);

        //then
        assertThatThrownBy(() -> winningNumbers.validateWinningNumberInputSize(winningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SIX_NUMBER.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("당첨 번호에 중복된 값이 존재할 경우 예외 처리")
    @Test
    void duplicatedNumberInWinningNumbers() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 3, 4, 5, 5);

        //then
        assertThatThrownBy(() -> winningNumbers.validateDuplicateWinningNumber(winningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_NUMBER.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("당첨 번호가 범위를 초과한 경우 예외 처리")
    @Test
    void winningNumberOverRange() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 3, 4, 5, 46);

        //then
        assertThatThrownBy(() -> winningNumbers.validateWinningNumberRange(winningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("당첨 번호가 범위에 미달일 경우 예외 처리")
    @Test
    void winningNumberLessRange() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(0, 2, 3, 4, 5, 6);

        //then
        assertThatThrownBy(() -> winningNumbers.validateWinningNumberRange(winningNumbersInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("당첨 번호 생성 후 저장")
    @Test
    void generateWinningNumber() {
        //given
        WinningNumbers winningNumber = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 6, 7, 43, 21);
        winningNumber.generateWinningNumbers(winningNumbersInput);
        List<Integer> expectedWinningNumbers = List.of(1, 2, 6, 7, 43, 21);

        //then
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();
        assertThat(winningNumbers.size()).isEqualTo(6);
        assertThat(winningNumbers).containsAnyElementsOf(expectedWinningNumbers);
    }

    @DisplayName("보너스 번호가 범위를 초과할 경우 예외 처리")
    @Test
    void bonusNumberOverRange() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 6, 7, 43, 21);
        winningNumbers.generateWinningNumbers(winningNumbersInput);

        int bonusNumberInput = 46;

        //then
        assertThatThrownBy(() -> winningNumbers.validateBonusNumber(bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("보너스 번호가 범위 미달일 경우 예외 처리")
    @Test
    void bonusNumberLessRange() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 6, 7, 43, 21);
        winningNumbers.generateWinningNumbers(winningNumbersInput);

        int bonusNumberInput = 0;

        //then
        assertThatThrownBy(() -> winningNumbers.validateBonusNumber(bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("보너스 번호가 당첨 번호에 존재할 경우 예외 처리")
    @Test
    void winningNumbersContainBonusNumber() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 6, 7, 43, 21);
        winningNumbers.generateWinningNumbers(winningNumbersInput);

        int bonusNumberInput = 43;

        //then
        assertThatThrownBy(() -> winningNumbers.validateBonusNumber(bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WINNING_NUM_CONTAIN_BONUS_NUM.errorMessage)
                .hasMessageContaining(ERROR_PHRASES);
    }

    @DisplayName("보너스 번호 생성 후 저장")
    @Test
    void generateBonusNumber() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers();

        //when
        List<Integer> winningNumbersInput = List.of(1, 2, 6, 7, 43, 21);
        winningNumbers.generateWinningNumbers(winningNumbersInput);

        int bonusNumber = 45;
        winningNumbers.generateBonusNumber(bonusNumber);

        //then
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(bonusNumber);
    }
}