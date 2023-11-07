package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoWinningRanking;
import lotto.domain.Lottos;
import lotto.vo.LottoWinningBonusNumber;
import lotto.vo.LottoWinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoWinningRankingServiceTest {
    LottoWinningRankingService winningRankingService;

    @BeforeEach
    void beforeEach() {
        winningRankingService = LottoWinningRankingService.getInstance();
    }

    @Test
    @DisplayName("당첨 통계 계산 테스트")
    void countWinningRankings() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 45));

        List<Lotto> userLottos = Arrays.asList(lotto1, lotto2, lotto3);
        Lottos lottos = new Lottos(userLottos);

        LottoWinningNumbers winningLotto = new LottoWinningNumbers(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 9)),
                new LottoWinningBonusNumber(7));

        // when
        EnumMap<LottoWinningRanking, Integer> rankingCountMap = winningRankingService.countWinningRankings(lottos, winningLotto);

        // then
        assertThat(rankingCountMap.getOrDefault(LottoWinningRanking.FIRST, 0)).isEqualTo(0);
        assertThat(rankingCountMap.getOrDefault(LottoWinningRanking.SECOND, 0)).isEqualTo(1);
        assertThat(rankingCountMap.getOrDefault(LottoWinningRanking.THIRD, 0)).isEqualTo(2);
        assertThat(rankingCountMap.getOrDefault(LottoWinningRanking.FOURTH, 0)).isEqualTo(0);
        assertThat(rankingCountMap.getOrDefault(LottoWinningRanking.FIFTH, 0)).isEqualTo(0);
        assertThat(rankingCountMap.getOrDefault(LottoWinningRanking.NONE, 0)).isEqualTo(0);
    }
}
