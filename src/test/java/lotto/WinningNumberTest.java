package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumberTest {

    @Test
    @DisplayName("WinningNumber가 유효한 당첨 번호와 보너스 번호로 정상 생성되는지 테스트")
    void testWinningNumberCreationWithValidNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        WinningNumber winningNumber = new WinningNumber(lotto, bonusNumber);

        assertEquals(lotto.getNumbers(), winningNumber.getLotto().getNumbers());
        assertEquals(bonusNumber, winningNumber.getBonusNumber());
    }

    @Test
    @DisplayName("WinningNumber 생성 시 당첨 번호에 보너스 번호가 포함되어 있는 경우 예외 발생 테스트")
    void testWinningNumberCreationWithBonusNumberInWinningNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 6;

        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(lotto, bonusNumber);
        });
    }

    @Test
    @DisplayName("WinningNumber 생성 시 보너스 번호가 유효 범위를 벗어나는 경우 예외 발생 테스트")
    void testWinningNumberCreationWithInvalidBonusNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int invalidBonusNumber = 46;

        assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumber(lotto, invalidBonusNumber);
        });
    }

}
