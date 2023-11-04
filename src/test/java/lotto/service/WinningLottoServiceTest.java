package lotto.service;

import lotto.exception.WinningNumberValidationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoServiceTest {
    @Test
    @DisplayName("로또 번호 포맷이 올바르지 않으면 예외를 발생시킨다")
    void whenLottoNumberFormatIsIncorrect_thenThrowsException() {
        String incorrectFormatInput = "01, 02, 03, 04, 05, 0a";
        assertThrows(WinningNumberValidationException.class, () ->
                WinningNumberValidationException.checkLottoNumberFormat(incorrectFormatInput));
    }
}