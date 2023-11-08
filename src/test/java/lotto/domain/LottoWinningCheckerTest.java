package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningCheckerTest {
    @Test
    public void testCheckWinningNumbers() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), 6);

        int result = LottoWinningChecker.checkWinningNumbers(lotto, winningNumber);

        // 5개 일치 + bonus 일치 => 7 return
        assertEquals(7, result);
    }

    @Test
    public void testCalculateMatchCounts() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26))
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        int[] matchCounts = LottoWinningChecker.calculateMatchCounts(lottos, winningNumber);

        // 꽝 2개, 6개 일치 1개
        int[] expectedMatchCounts = {2, 0, 0, 0, 0, 0, 1, 0};

        assertArrayEquals(expectedMatchCounts, matchCounts);
    }

    @Test
    public void testCalculateTotalPrize() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)),
                new Lotto(Arrays.asList(21, 22, 23, 24, 25, 26))
        );
        WinningNumber winningNumber = new WinningNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        long totalPrize = LottoWinningChecker.calculateTotalPrize(lottos, winningNumber);

        // 6개 일치 2,000,000,000원 당첨
        assertEquals(2000000000, totalPrize);
    }
}