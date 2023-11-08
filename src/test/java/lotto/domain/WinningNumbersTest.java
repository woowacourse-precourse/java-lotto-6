package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private WinningNumbers winningNumbers;
    private Lotto winningLotto;
    private Lotto nonWinningLotto;

    @BeforeEach
    void setUp() {
        List<Integer> winningNums = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        winningNumbers = new WinningNumbers(winningNums, bonusNumber);

        winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        nonWinningLotto = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 13));
    }

    @Test
    void testMatchCount() {
        assertEquals(6, winningNumbers.matchCount(winningLotto));
        assertEquals(0, winningNumbers.matchCount(nonWinningLotto));
    }

    @Test
    void testMatchBonusNumber() {
        Lotto lottoWithBonus = new Lotto(Arrays.asList(8, 9, 10, 11, 12, 7));
        assertTrue(winningNumbers.matchBonusNumber(lottoWithBonus));
        assertFalse(winningNumbers.matchBonusNumber(winningLotto));
        assertFalse(winningNumbers.matchBonusNumber(nonWinningLotto));
    }
}