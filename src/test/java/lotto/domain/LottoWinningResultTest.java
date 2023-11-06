package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LottoWinningResultTest {

    @Test
    public void 수익률을_계산할_수_있다() throws Exception {
        // given
        Map<LottoPrize, Integer> prizeCountMap = new HashMap<>();
        prizeCountMap.put(LottoPrize.FIFTH_PRIZE, 1);
        prizeCountMap.put(LottoPrize.FOURTH_PRIZE, 1);

        LottoWinningResult lottoWinningResult = new LottoWinningResult(new LottoPurchase(5000L), prizeCountMap);

        // when
        double ratio = lottoWinningResult.calculateRewardRatio();

        // then
        assertThat(ratio).isEqualTo((double) (5000L + 50000L) / 5000L);
    }

}