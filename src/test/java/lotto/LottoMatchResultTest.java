package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 당첨 결과 테스트")
class LottoMatchResultTest {
    @DisplayName("각 등수에 해당하는 로또가 몇개인지 확인할 수 있다.")
    @Test
    public void testGetLottoRankCount() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIRST, LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD);
        Money money = new Money("4000");
        LottoMatchResultDto lottoMatchResultDto = LottoMatchResult.createLottoMatchResult(lottoRanks, money).toDto();

        Map<LottoRank, Integer> rankCount = lottoMatchResultDto.getLottoRankCount();

        Map<LottoRank, Integer> expectedRankCount = new HashMap<>();
        expectedRankCount.put(LottoRank.FIRST, 2);
        expectedRankCount.put(LottoRank.SECOND, 1);
        expectedRankCount.put(LottoRank.THIRD, 1);
        expectedRankCount.put(LottoRank.FOURTH, 0);
        expectedRankCount.put(LottoRank.FIFTH, 0);
        expectedRankCount.put(LottoRank.LOSE, 0);
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }

    @DisplayName("로또 수익률을 계산할 수 있다.")
    @Test
    public void testGetProfitRate() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE, LottoRank.LOSE, LottoRank.FIFTH);
        Money money = new Money("5000");
        LottoMatchResultDto lottoMatchResultDto = LottoMatchResult.createLottoMatchResult(lottoRanks, money).toDto();

        double profitRate = lottoMatchResultDto.getProfitRate();

        double expectedProfitRate = 100.0;
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}