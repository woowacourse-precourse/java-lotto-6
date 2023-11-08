package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @DisplayName("로또 당첨 통계를 검증한다.")
    @Test
    void calculatePrizeStatistics() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 15)),
                new Lotto(List.of(1, 2, 3, 4, 14, 15)),
                new Lotto(List.of(1, 2, 3, 13, 14, 15)),
                new Lotto(List.of(10, 11, 12, 13, 14, 15))
        );
        Lottos lottos = new Lottos(lottoList);
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 7);

        PrizeStatistics prizeStatistics = lottos.calculatePrizeStatistics(winningLotto);

        assertThat(prizeStatistics.getCountForPrize(Prize.FIRST)).isEqualTo(1);
        assertThat(prizeStatistics.getCountForPrize(Prize.SECOND)).isEqualTo(1);
        assertThat(prizeStatistics.getCountForPrize(Prize.THIRD)).isEqualTo(1);
        assertThat(prizeStatistics.getCountForPrize(Prize.FOURTH)).isEqualTo(1);
        assertThat(prizeStatistics.getCountForPrize(Prize.FIFTH)).isEqualTo(1);
        assertThat(prizeStatistics.getCountForPrize(Prize.NO_PRIZE)).isEqualTo(1);
    }

}