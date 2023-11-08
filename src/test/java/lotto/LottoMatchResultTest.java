package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Amount;
import lotto.domain.LottoMatchResult;
import lotto.domain.Rank;
import lotto.dto.LottoMatchResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMatchResultTest {
    @DisplayName("등수에 해당하는 로또가 몇개인지 확인 할 수 있다.")
    @Test
    public void testGetLottoRankCount() {
        List<Rank> lottoRanks = Arrays.asList(Rank.FIRST, Rank.FIRST, Rank.SECOND);
        Amount amount = new Amount("3000");
        LottoMatchResultDto lottoMatchResultDto  = LottoMatchResult.createLottoMatchResult(lottoRanks, amount).toDto();

        Map<Rank, Integer> rankCount = lottoMatchResultDto.getLottoRankCount();

        Map<Rank, Integer> expectedRankCount = new HashMap<>();
        expectedRankCount.put(Rank.FIRST, 2);
        expectedRankCount.put(Rank.SECOND, 1);
        expectedRankCount.put(Rank.THIRD, 0);
        expectedRankCount.put(Rank.FOURTH, 0);
        expectedRankCount.put(Rank.FIFTH, 0);
        expectedRankCount.put(Rank.NONE, 0);
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }

    @DisplayName("로또 수익률을 계산할 수 있다.")
    @Test
    public void testGetProfitRate() {
        List<Rank> lottoRanks = Arrays.asList(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.FIFTH);
        Amount amount = new Amount("5000");
        LottoMatchResultDto lottoMatchResultDto = LottoMatchResult.createLottoMatchResult(lottoRanks, amount).toDto();

        double profitRate = lottoMatchResultDto.getProfitRate();

        double expectedProfitRate = 100.0;
        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
