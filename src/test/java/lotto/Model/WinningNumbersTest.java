package lotto.Model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningNumbersTest {

    @Test
    public void testWinningNumbersCreation() {
        Lotto expectedLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int expectedBonusNumber = 7;

        WinningNumbers winningNumbers = new WinningNumbers(expectedLotto, expectedBonusNumber);

        assertEquals(expectedLotto, winningNumbers.getWinningLotto());
        assertEquals(expectedBonusNumber, winningNumbers.getBonusNumber());
    }
}
