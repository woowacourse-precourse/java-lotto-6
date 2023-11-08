package lotto.Test.FunctionTest;

import lotto.model.lottoResultChecker.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class LottoWinningStatisticsTest {

    @Test
    @DisplayName("당첨 통계 계산을 위한 테스트")
    void CalculateStatisticsTest() {
        LottoWinningStatistics stats = new LottoWinningStatistics(new LottoRankChecker());
        List<Integer> winningNumbers = Arrays.asList(3, 6, 9, 12, 15, 18);
        Lotto winningLotto = new Lotto(winningNumbers);
        LottoBonus bonus = new LottoBonus("19", winningNumbers);
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(3, 6, 9, 12, 15, 18)),
                new Lotto(Arrays.asList(3, 6, 9, 12, 15, 19))
        );
        Map<LottoRank, Integer> statistics = stats.calculateStatistics(lottos, winningLotto, bonus);
        assertEquals(1, statistics.getOrDefault(LottoRank.FIRST, 0), "1등 당첨 통계가 올바르지 않습니다.");
        assertEquals(1, statistics.getOrDefault(LottoRank.SECOND, 0), "2등 당첨 통계가 올바르지 않습니다.");
    }
}