package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StatisticianTest {
    @Test
    void 로또통계가_정상적으로_생성되는지_테스트() {
        LottoAmount lottoAmount = new LottoAmount(2000);
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );

        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        assertThat(new Statistician().makeLottoStatistics(lottoAmount, lottoList, winningLotto))
                .isEqualTo(new WinningStatistics(lottoAmount, Map.of(Ranking.FIRST, 1, Ranking.SECOND, 1)));
    }
}
