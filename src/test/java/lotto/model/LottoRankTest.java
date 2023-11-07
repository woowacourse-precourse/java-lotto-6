package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import lotto.model.rank.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {
    @DisplayName("당첨 번호와 일치하는 번호의 개수와 보너스 번호를 통해 등수를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "0, false, NONE",
            "3, false, FIFTH",
            "4, false, FOURTH",
            "5, false, THIRD",
            "5, true, SECOND",
            "6, false, FIRST"
    })
    void testLottoRankByMatchCountAndBonusNumber(
            int matchCount,
            boolean bonusNumberExists,
            LottoRank expected
    ) {
        //when, then
        LottoRank result = LottoRank.findRankByMatchCount(matchCount, bonusNumberExists);
        assertEquals(expected, result);
    }

    /*
     * 1등이 두 번 당첨되는 등 상금이 int 최대 범위인 21억보다 커지면 예외가 발생하는 것을 발견.
     * BigInteger 를 통해 따로 처리를 해주어야 할지 고민하게 됨.
     */
    @DisplayName("당첨된 등수의 개수만큼 상금을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "NONE, 3, 0",
            "FIFTH, 2, 10000",
            "FOURTH, 5, 250000",
            "THIRD, 2, 3000000",
            "SECOND, 1, 30000000",
            "FIRST, 3, 6000000000"
    })
    void testReturnPrizeByWinningRankCount(LottoRank rank, int count, BigInteger expected) {
        //when, then
        BigInteger result = LottoRank.calculatePrizeByCount(rank, count);
        assertEquals(expected, result);
    }
}
