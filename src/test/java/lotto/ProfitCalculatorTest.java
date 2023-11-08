package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    @Test
    void 총상금_계산하기() {
        Map<LottoRank, Integer> winningResult = Map.of(
                LottoRank.NO_WIN, 3,
                LottoRank.FIFTH, 5,
                LottoRank.FOURTH, 4,
                LottoRank.THIRD, 3,
                LottoRank.SECOND, 2,
                LottoRank.FIRST, 1
        );

        int totalPrize = (LottoRank.NO_WIN.getPrizeMoney() * 3) + (LottoRank.FIFTH.getPrizeMoney() * 5) + (
                LottoRank.FOURTH.getPrizeMoney() * 4) + (LottoRank.THIRD.getPrizeMoney() * 3) + (
                LottoRank.SECOND.getPrizeMoney() * 2) + (LottoRank.FIRST.getPrizeMoney() * 1);

        assertThat(ProfitCalculator.calculateTotalPrize(winningResult)).isEqualTo(totalPrize);
    }
}