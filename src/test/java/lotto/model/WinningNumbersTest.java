package lotto.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class WinningNumbersTest {

    @Test
    @DisplayName("로또와 당첨번호를 비교하여 일치하는 숫자의 개수를 올바르게 계산하는지 테스트")
    void countMatchNumbers() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        int matchCount = winningNumbers.countMatchNumbers(lotto);

        assertEquals(3, matchCount);
    }

    @Test
    @DisplayName("로또가 보너스 번호를 포함하는지 올바르게 판별하는지 테스트")
    void hasBonusNumber() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Lotto lottoWithBonusNumber = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lottoWithoutBonusNumber = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertTrue(winningNumbers.hasBonusNumber(lottoWithBonusNumber));
        assertFalse(winningNumbers.hasBonusNumber(lottoWithoutBonusNumber));
    }
}
