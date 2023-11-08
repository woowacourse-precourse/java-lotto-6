package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.constant.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultsTest {

    private LottoResults lottoResults;

    @BeforeEach
    void createLottoResults() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(2, 3, 4, 5, 6, 7));
        Lotto lotto3 = new Lotto(List.of(2, 4, 8, 13, 35, 41));
        Lotto lotto4 = new Lotto(List.of(9, 10, 15, 19, 35, 41));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2, lotto3, lotto4));
        lottoResults = LottoResults.createLottoResults(lottos, winningNumbers);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateRevenueRate() {
        Money money = new Money(5000);
        assertThat(lottoResults.getRevenueRate(money))
                .isEqualTo((double) (2000000000 + 30000000) / 5000 * 100);
    }

    @Test
    @DisplayName("Rank 계산 테스트")
    void calculateRankCount() {
        assertThat(lottoResults.getRankCount(Rank.FIRST_RANK)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(Rank.SECOND_RANK)).isEqualTo(1);
        assertThat(lottoResults.getRankCount(Rank.NOTHING)).isEqualTo(2);
    }

}