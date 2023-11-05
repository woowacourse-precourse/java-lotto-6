package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoService;
import lotto.domain.LottoStatistics;
import lotto.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatisticsTest {

    private LottoService lottoService;
    private LottoStatistics lottoStatistics;
    private List<Integer> winningNumbers;
    private int bonusNumber;
    private List<Lotto> userLottos;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
        winningNumbers = Arrays.asList(3, 12, 21, 25, 38, 42);
        bonusNumber = 45;
        userLottos = Arrays.asList(
                new Lotto(Arrays.asList(3, 12, 21, 25, 38, 42)), // First prize
                new Lotto(Arrays.asList(3, 12, 21, 25, 38, 45)), // Second prize
                new Lotto(Arrays.asList(3, 12, 21, 25, 38, 1)),  // Third prize
                new Lotto(Arrays.asList(3, 12, 21, 25, 1, 2)),   // Fourth prize
                new Lotto(Arrays.asList(3, 12, 21, 1, 2, 4))     // Fifth prize
        );
        lottoStatistics = new LottoStatistics(userLottos, winningNumbers, bonusNumber);
    }

    @Test
    @DisplayName("각 등수별로 당첨 횟수를 계산한다.")
    void calculateWinsPerCategory() {
        List<Integer> winsPerCategory = lottoStatistics.calculateWinsPerCategory();
        assertThat(winsPerCategory).containsExactly(1, 1, 1, 1, 1);
    }

    @Test
    @DisplayName("당첨 복권에서 총 당첨 금액을 계산한다.")
    void calculateTotalRevenue() {
        long totalRevenue = lottoStatistics.calculateTotalRevenue();
        assertEquals(2030505000,
                totalRevenue); // The sum of the prize money for first, second, third, fourth, and fifth prizes.
    }

    @Test
    @DisplayName("총 당첨금액을 이용해 수익률을 계산한다.")
    void calculateRateOfReturn() {
        double purchaseAmount = userLottos.size() * Constants.LOTTO_PRICE;
        double rateOfReturn = lottoStatistics.calculateRateOfReturn();
        assertThat(rateOfReturn).isEqualTo(Math.round((2030505000 / purchaseAmount - 1) * 10) / 10.0);
    }
}
