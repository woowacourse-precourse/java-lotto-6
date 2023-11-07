package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.domain.WinningChecker;
import org.junit.jupiter.api.Test;

public class WinningCheckerTest {
    @Test
    void testWinningChecker() {
        WinningChecker winningChecker = new WinningChecker();

        List<Integer> winningNumbers = Arrays.asList(3, 7, 12, 19, 24, 30);
        int bonusNumber = 5;

        List<Integer> userTicket1 = Arrays.asList(3, 7, 12, 19, 24, 30);
        List<Integer> userTicket2 = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<List<Integer>> userTickets = Arrays.asList(userTicket1, userTicket2);

        List<Integer> result = winningChecker.checkWinning(userTickets, winningNumbers, bonusNumber);

        assertEquals(Arrays.asList(1, 0), result);
    }
}
