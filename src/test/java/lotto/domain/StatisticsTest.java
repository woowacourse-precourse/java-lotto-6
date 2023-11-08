package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class StatisticsTest {

    @DisplayName("당첨 순위별 통계를 계산한다.")
    @Test
    public void statisticsCreation() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7))
        );
        WinningLotto winningLotto = new WinningLotto((List.of(1, 2, 3, 4, 5, 6)));
        int bonus = 7;

        Statistics statistics = new Statistics(lottos, winningLotto, bonus);
        String actual = statistics.toString();

        String expected = "3개 일치 (5,000원) - 0개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
                "6개 일치 (2,000,000,000원) - 1개\n";
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("총 수익률을 계산한다.")
    @Test
    void calculateRevenueRate() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(8, 9, 10, 11, 12, 13))
        );
        WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        Statistics statistics = new Statistics(lottos, winningLotto, bonus);
        Buyer buyer = new Buyer(2000);
        String actual = statistics.calculateRevenueRate(buyer);

        Assertions.assertThat(actual).isEqualTo("1,500,000.0");
    }
}