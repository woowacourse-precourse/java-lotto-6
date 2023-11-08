package lotto.domain;

import lotto.domain.BonusNumber;
import lotto.domain.Prize;
import lotto.domain.WinningChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningCheckerTest {

    private WinningChecker winningChecker;
    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningChecker = new WinningChecker(winningNumbers);
    }

    @Test
    void testCheckWinningPrize() {
        assertEquals(Prize.WinningPrize.FIRST_RANK.getPrizeAmount(), winningChecker.checkWinningPrize(6, false));
        assertEquals(Prize.WinningPrize.SECOND_RANK.getPrizeAmount(), winningChecker.checkWinningPrize(5, true));
        assertEquals(Prize.WinningPrize.THIRD_RANK.getPrizeAmount(), winningChecker.checkWinningPrize(5, false));
        assertEquals(Prize.WinningPrize.FOURTH_RANK.getPrizeAmount(), winningChecker.checkWinningPrize(4, false));
        assertEquals(Prize.WinningPrize.FIFTH_RANK.getPrizeAmount(), winningChecker.checkWinningPrize(3, false));
    }

    @Test
    void testCheckMachingCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        int matchingCount = winningChecker.checkMachingCount(numbers);
        assertEquals(3, matchingCount);
    }

    @Test
    void testHasBonusNumber() {
        BonusNumber bonusNumber = new BonusNumber(7);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        assertTrue(winningChecker.hasBonusNumber(bonusNumber, numbers));
    }
}
