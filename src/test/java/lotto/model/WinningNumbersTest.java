package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumbersTest {
    @DisplayName("당첨번호 6개 잘 들어갔는지 확인")
    @Test
    void testGetWinningNumbers() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonusNumber);

        List<Integer> actualWinningNumbers = winningNumbersObj.getWinningNumbers();

        assertEquals(winningNumbers, actualWinningNumbers);
    }

    @DisplayName("보너스 번호 잘 들어갔는지 확인")
    @Test
    void testGetBonusNumber() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbers, bonusNumber);

        int actualBonusNumber = winningNumbersObj.getBonusNumber();

        assertEquals(bonusNumber, actualBonusNumber);
    }
}