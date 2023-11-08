package lotto.service;

import lotto.exception.WinningNumberValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoServiceTest {
    @Test
    @DisplayName("로또 번호 포맷이 올바르지 않으면 예외를 발생시킨다")
    void whenLottoNumberFormatIsIncorrect_thenThrowsException() {
        String incorrectFormatInput = "01, 02, 03, 04, 05, 0a";
        assertThrows(WinningNumberValidationException.class, () ->
                WinningNumberValidationException.checkLottoNumberFormat(incorrectFormatInput));
    }

    @Test
    @DisplayName("당첨 번호의 길이가 올바르지 않으면 예외를 발생시킨다")
    void whenWinningNumberLengthIsIncorrect_thenThrowsException() {
        List<Integer> incorrectLengthNumbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(WinningNumberValidationException.class, () ->
                WinningNumberValidationException.checkWinningNumberLength(incorrectLengthNumbers));
    }

    @Test
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외를 발생시킨다")
    void whenWinningNumbersHaveDuplicates_thenThrowsException() {
        List<Integer> duplicateNumbers = Arrays.asList(1, 1, 3, 4, 5, 6);
        assertThrows(WinningNumberValidationException.class, () ->
                WinningNumberValidationException.checkDuplicateWinningNumbers(duplicateNumbers));
    }

    @Test
    @DisplayName("당첨 번호가 지정된 범위를 벗어나면 예외를 발생시킨다")
    void whenWinningNumbersAreOutOfBound_thenThrowsException() {
        List<Integer> outOfBoundNumbers = Arrays.asList(0, 1, 2, 3, 4, 5);
        assertThrows(WinningNumberValidationException.class, () ->
                WinningNumberValidationException.checkBoundaryOfWinningNumbers(outOfBoundNumbers));
    }
}