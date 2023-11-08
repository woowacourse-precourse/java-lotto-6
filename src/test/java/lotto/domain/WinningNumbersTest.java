package lotto.domain;


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

        WinningNumbers winningNumbersInstance = new WinningNumbers(winningNumbers);

        List<Integer> result = winningNumbersInstance.getWinningNumbers();

        assertEquals(6, result.size());
        assertTrue(result.contains(3));
        assertTrue(result.contains(7));
        assertTrue(result.contains(12));
    }
}
