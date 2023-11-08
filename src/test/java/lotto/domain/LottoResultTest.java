package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.FOURTH);
        lottoResult.addRank(Rank.FIFTH);
        lottoResult.addRank(Rank.FIFTH);
        // Rank.NONE is implicitly tested by not adding it
    }

    @Test
    @DisplayName("각 등수별로 카운트가 정확히 증가하는지 확인하는 테스트")
    void testRanksCountIncrement() {
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(2);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.FIFTH)).isEqualTo(2);
        assertThat(lottoResult.getRankCount(Rank.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("총 상금이 올바르게 계산되는지 확인하는 테스트")
    void testTotalPrizeMoneyCalculation() {
        long expectedTotalPrizeMoney = Rank.FIRST.getPrizeMoney() * 2 +
                Rank.SECOND.getPrizeMoney() +
                Rank.FOURTH.getPrizeMoney() +
                Rank.FIFTH.getPrizeMoney() * 2;
        assertThat(lottoResult.calculateTotalPrizeMoney()).isEqualTo(expectedTotalPrizeMoney);
    }

    @Test
    @DisplayName("수익률이 올바르게 계산되는지 확인하는 테스트")
    void testProfitRateCalculation() {
        int purchaseAmount = 3000; // 3 tickets purchased
        double expectedProfitRate = ((double) lottoResult.calculateTotalPrizeMoney() / purchaseAmount) * 100;
        assertThat(lottoResult.calculateProfitRate(purchaseAmount)).isEqualTo(expectedProfitRate);
    }
}
