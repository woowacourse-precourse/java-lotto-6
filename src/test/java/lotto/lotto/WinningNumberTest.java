package lotto.lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WinningNumberTest {

    @Test
    public void 일치하는_당첨번호_개수_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));

        Long matchingCount = winningNumber.countMatchingNumber(lotto);

        assertEquals(Long.valueOf(3), matchingCount);
    }

    @Test
    public void 보너스_당첨번호_매칭_검증() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 7));

        boolean bonusNumberMatch = winningNumber.checkBonusNumberMatch(lotto);

        assertTrue(bonusNumberMatch);
    }

    @Test
    public void 일치하는_당첨번호가_없다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        Long matchingCount = winningNumber.countMatchingNumber(lotto);

        assertEquals(Long.valueOf(0), matchingCount);
    }

    @Test
    public void 보너스_번호가_일치하지_않는다() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusNumber);
        Lotto lotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));

        boolean bonusNumberMatch = winningNumber.checkBonusNumberMatch(lotto);

        assertFalse(bonusNumberMatch);
    }

}