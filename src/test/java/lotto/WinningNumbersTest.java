package lotto;


import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningNumbersTest {

    @Test
    void testWinningNumbers() {

        List<Integer> winningNumbers = new ArrayList<>();
        winningNumbers.add(3);
        winningNumbers.add(7);
        winningNumbers.add(9);
        winningNumbers.add(12);
        winningNumbers.add(14);
        winningNumbers.add(17);
        int bonusNumber = 20;

        WinningNumbers winningNumbersInstance = new WinningNumbers(winningNumbers, bonusNumber);

        List<Integer> result = winningNumbersInstance.getWinningNumbersWithBonus();

        assertEquals(7, result.size());
        assertTrue(result.contains(3));
        assertTrue(result.contains(7));
        assertTrue(result.contains(12));
        assertTrue(result.contains(20));
    }
}
