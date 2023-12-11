package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class YieldTest {
    Yield yield = new Yield();

    @DisplayName("총 당첨금 5,000원 / 로또 구입 금액 8,000원 = 수익률 62.5%이다.")
    @Test
    void calculateTest() {
        double lottoYield = yield.calculate(5_000, 8_000);
        assertThat(lottoYield).isEqualTo(62.5);
    }

    @DisplayName("총 당첨 금액은 각 등수의 (상금 * 당첨 개수)를 모두 더한 값이다.")
    @Test
    void sumPrizeMoneyTest() {
        Map<Integer, Integer> theNumberOfWinningsByRank = new HashMap<>();
        theNumberOfWinningsByRank.put(1, 1); // 1등, 당첨 1회 (상금: 2,000,000,000)
        theNumberOfWinningsByRank.put(2, 1); // 2등, 당첨 1회 (상금: 30,000,000)
        theNumberOfWinningsByRank.put(3, 1); // 3등, 당첨 1회 (상금: 1,500,000)
        theNumberOfWinningsByRank.put(4, 1); // 4등, 당첨 1회 (상금: 50,000)
        theNumberOfWinningsByRank.put(5, 1); // 5등, 당첨 1회 (상금: 5,000)
        long totalPrizeMoney = yield.sumPrizeMoney(theNumberOfWinningsByRank);
        assertThat(totalPrizeMoney)
                .isEqualTo(2_031_555_000); // 등수별 상금 * 당첨 개수를 모두 합한 값
    }
}
