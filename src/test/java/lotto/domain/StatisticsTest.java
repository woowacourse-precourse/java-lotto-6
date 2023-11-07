package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatisticsTest {

    @Test
    @DisplayName("당첨 통계 결과 확인")
    void getStat() {
        Statistics statistics = getStatistics();
        assertThat(statistics.getStat(Rank.OTHER)).isEqualTo(7);
        assertThat(statistics.getStat(Rank.FIFTH)).isEqualTo(1);
        assertThat(statistics.getStat(Rank.FOURTH)).isEqualTo(0);
        assertThat(statistics.getStat(Rank.THIRD)).isEqualTo(0);
        assertThat(statistics.getStat(Rank.SECOND)).isEqualTo(0);
        assertThat(statistics.getStat(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    @DisplayName("수익률 확인")
    void getProfitRate() {
        Statistics statistics = getStatistics();
        assertThat(statistics.getProfitRate()).isEqualTo(62.5);
    }

    private Statistics getStatistics() {
        Money money = new Money(8000L);
        LottoBundle lottoBundle = getLottoBundle();
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);

        return new Statistics(money, lottoBundle, winningNumbers, bonusNumber);
    }

    private LottoBundle getLottoBundle() {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        return new LottoBundle(List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8));
    }
}