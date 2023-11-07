package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankTest {
    @DisplayName("당첨 숫자와 일치하는 숫자 및 보너스로 당첨 여부 및 상금을 확인한다.")
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
    void matchLottoReward(int match, boolean bonus, long expected) {
        long actual = LottoRank.getWinningRank(match, bonus).getReward();
        assertEquals(expected, actual);
    }
}
