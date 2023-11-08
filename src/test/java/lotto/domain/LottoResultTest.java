package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoResultTest {
    private LottoResult lottoResult;
    private final int purchaseAmount = 14000; // 테스트에서 사용할 구매 금액

    @BeforeEach
    void setUp() {
        lottoResult = new LottoResult(purchaseAmount);
    }

    @Test
    @DisplayName("로또 결과를 업데이트하고, 올바르게 결과가 반영되는지 검증한다.")
    void updateResult() {
        // given
        LottoRank rank = LottoRank.FIRST; // 1등

        // when
        lottoResult.updateResult(rank);

        // then
        Map<LottoRank, Integer> results = lottoResult.getResults();
        assertEquals(1, results.get(rank));
        results.forEach((key, value) -> {
            if (key != rank) {
                assertEquals(0, value);
            }
        });
    }

    @Test
    @DisplayName("수익률을 계산하고, 올바른 수익률이 계산되는지 검증한다.")
    void calculateProfitRatio() {
        // given
        lottoResult.updateResult(LottoRank.FIRST); // 1등, 상금 2,000,000,000원
        lottoResult.updateResult(LottoRank.THIRD); // 3등, 상금 1,500,000원
        lottoResult.updateResult(LottoRank.THIRD); // 3등, 또 한 번

        // when
        double profitRatio = lottoResult.calculateProfitRatio();

        // then
        long expectedTotalPrize = LottoRank.FIRST.getPrizeMoney() + (LottoRank.THIRD.getPrizeMoney() * 2);
        double expectedProfitRatio = ((double) expectedTotalPrize)  / purchaseAmount * 100;
        assertEquals(expectedProfitRatio, profitRatio);
    }
}
