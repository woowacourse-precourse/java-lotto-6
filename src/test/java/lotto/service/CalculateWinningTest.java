package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculateWinningTest {
    @DisplayName("일등 했을 때, 통계 - 수익률 확인")
    @Test
    void generateStatisticTest_FirstEarnRate() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(CalculateWinning.generateStatistic(
                        new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7), lottoList)
                .getTotalEarnRate()).isEqualTo(200000000.0);
    }

    @DisplayName("이등 했을 때, 통계 - 수익률 확인")
    @Test
    void generateStatisticTest_SecondEarnRate() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)));

        assertThat(CalculateWinning.generateStatistic(
                        new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7), lottoList)
                .getTotalEarnRate()).isEqualTo(3000000.0);
    }

    @DisplayName("삼등 했을 때, 통계 - 수익률 확인")
    @Test
    void generateStatisticTest_ThirdEarnRate() {
        List<Lotto> lottoList = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 8)));

        assertThat(CalculateWinning.generateStatistic(
                        new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7), lottoList)
                .getTotalEarnRate()).isEqualTo(150000.0);
    }
}