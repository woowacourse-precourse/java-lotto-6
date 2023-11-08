package lotto.Model.Util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaffleUtilTest {

    private RaffleUtil raffleUtil = new RaffleUtil();

    @Test
    void parseWinningNumbers() {
        String winningNumber = "1,2,3,4,5,6";
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6};

        assertEquals(List.of(array), raffleUtil.parseWinningNumbers(winningNumber));
    }
}