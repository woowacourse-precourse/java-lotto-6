package lotto.domain;

import lotto.message.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoDrawMachineTest {
    @Test
    @DisplayName("보너스 숫자는 1미만인 경우 예외를 발생시킨다.")
    void bonusNumberTooLow() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoDrawMachine(lotto, bonusNumber);
        });

        assertEquals(ErrorMessage.NUMBER_OUT_OF_RANGE_LOW.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자는 45초과인 경우 예외를 발생시킨다.")
    void bonusNumberTooHigh() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 46;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoDrawMachine(lotto, bonusNumber);
        });

        assertEquals(ErrorMessage.NUMBER_OUT_OF_RANGE_HIGH.getMessage(), exception.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자의 범위가 1~45인 경우 예외를 발생시키지 않는다.")
    void validBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 45;

        assertDoesNotThrow(() -> {
            new LottoDrawMachine(lotto, bonusNumber);
        });
    }
}