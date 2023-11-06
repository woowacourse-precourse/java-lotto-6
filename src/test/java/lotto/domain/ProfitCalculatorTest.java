package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.constants.WinningCriteria;
import lotto.utils.generator.FixedLottosGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {
    @DisplayName("수익률을 정확하게 계산한다")
    @Test
    void testCalculateProfitPercentage() {
        double expectedValue = 62.5;
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
        );
        PurchasedLottos purchasedLottos = new PurchasedLottos(8000, new FixedLottosGenerator(lottos));
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addResult(WinningCriteria.FIFTH);
        ProfitCalculator profitCalculator = new ProfitCalculator(winningStatistics, purchasedLottos);
        assertThat(profitCalculator.calculateProfitRate()).isEqualTo(expectedValue);
    }
}
