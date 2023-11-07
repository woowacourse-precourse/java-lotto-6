package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> userLottos;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(3, 12, 21, 25, 38, 42);
        bonusNumber = 45;
        userLottos = Arrays.asList(
                new Lotto(Arrays.asList(3, 12, 21, 25, 38, 42)), // 1위
                new Lotto(Arrays.asList(3, 12, 21, 25, 38, 45)), // 2위
                new Lotto(Arrays.asList(3, 12, 21, 25, 38, 1)),  // 3위
                new Lotto(Arrays.asList(3, 12, 21, 25, 1, 2)),   // 4위
                new Lotto(Arrays.asList(3, 12, 21, 1, 2, 4))     // 5위
        );
        lottoStatistics = new LottoStatistics(userLottos, winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("각 등수별로 당첨 횟수를 계산한다.")
    void calculateWinsPerCategory() {
        Map<LottoRank, Long> winsPerCategory = lottoStatistics.getWinsPerCategory();

        assertThat(winsPerCategory.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(winsPerCategory.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(winsPerCategory.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(winsPerCategory.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(winsPerCategory.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(winsPerCategory.getOrDefault(LottoRank.NONE, 0L)).isZero();
    }

    @Test
    @DisplayName("총 당첨금액을 이용해 수익률을 계산한다.")
    void calculateRateOfReturn() {
        double purchaseAmount = userLottos.size() * Constants.LOTTO_PRICE;

        double rateOfReturn = lottoStatistics.getTotalRate();
        assertThat(rateOfReturn).isEqualTo(2031555000 / purchaseAmount);
    }
}
