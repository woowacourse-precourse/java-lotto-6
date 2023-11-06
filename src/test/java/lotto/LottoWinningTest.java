package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoWinningTest {
    @ParameterizedTest
    @CsvSource({
            "6, false, 2000000000",
            "6, true, 2000000000",
            "5, true, 300000000",
            "5, false, 1500000",
            "4, true, 50000",
            "3, false, 5000",
            "2, true, 0",
            "2, false, 0",
            "1, true, 0",
            "0, true, 0",
    })
    void 로또_당첨(int match, boolean bonus, long expected) { //unittest
        long actual = LottoWinning.getWinningPlace(match, bonus).getReward();
        assertEquals(expected, actual);
    }


}