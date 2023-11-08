package lotto;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    @Test
    void 수익률_계산_테스트() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoStatistics statistics = new LottoStatistics(tickets, userLotto, 7);
        assertThat(statistics.getProfit()).isEqualTo(62.5f);
    }

    @Test
    void 결과_출력_테스트() {
        List<Lotto> tickets = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoStatistics statistics = new LottoStatistics(tickets, userLotto, 7);
        assertThat(statistics.toString()).contains(
                "3개 일치 (5,000원) - 1개\n" +
                "4개 일치 (50,000원) - 0개\n" +
                "5개 일치 (1,500,000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
                "6개 일치 (2,000,000,000원) - 0개");
    }
}
