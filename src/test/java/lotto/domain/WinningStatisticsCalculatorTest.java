package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.constants.WinningCriteria;
import lotto.utils.generator.FixedLottosGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsCalculatorTest {

    private WinningStatisticsCalculator winningStatisticsCalculator;
    private WinningLotto winningLotto;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(Arrays.asList(3, 5, 10, 15, 34, 37));
        Lotto lotto3 = new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(Arrays.asList(5, 21, 23, 41, 42, 45));
        lottos = Arrays.asList(lotto1, lotto2, lotto3, lotto4);

        Lotto winningNumbers = new Lotto(Arrays.asList(3, 5, 11, 16, 32, 39));
        BonusNumber bonusNumber = new BonusNumber(38, winningNumbers);
        PurchasedLottos purchasedLottos = new PurchasedLottos(4000, new FixedLottosGenerator(lottos));
        winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        winningStatisticsCalculator = new WinningStatisticsCalculator(purchasedLottos, winningLotto);
    }

    @DisplayName("꽝(6등)을 정상적으로 계산한다")
    @Test
    void testSixthPrize() {
        assertThat(winningStatisticsCalculator.calculateWinningStatistics().getWinningInfo()
                .get(WinningCriteria.LOSE)).isEqualTo(4);
    }

    @DisplayName("1등을 정상적으로 계산한다")
    @Test
    void testFirstPrize() {
        lottos.set(1, new Lotto(Arrays.asList(3, 5, 11, 16, 32, 39))); // 1등 번호로 변경
        assertThat(winningStatisticsCalculator.calculateWinningStatistics().getWinningInfo()
                .get(WinningCriteria.FIRST)).isEqualTo(1);
    }

    @DisplayName("2등을 정상적으로 계산한다")
    @Test
    void testSecondPrize() {
        lottos.set(1, new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38))); // 2등 번호로 변경
        assertThat(winningStatisticsCalculator.calculateWinningStatistics().getWinningInfo()
                .get(WinningCriteria.SECOND)).isEqualTo(1);
    }

    @DisplayName("3등을 정상적으로 계산한다")
    @Test
    void testThirdPrize() {
        lottos.set(1, new Lotto(Arrays.asList(3, 5, 11, 16, 32, 37))); // 3등 번호로 변경
        assertThat(winningStatisticsCalculator.calculateWinningStatistics().getWinningInfo()
                .get(WinningCriteria.THIRD)).isEqualTo(1);
    }

    @DisplayName("4등을 정상적으로 계산한다")
    @Test
    void testFourthPrize() {
        lottos.set(1, new Lotto(Arrays.asList(3, 5, 11, 16, 34, 37))); // 4등 번호로 변경
        assertThat(winningStatisticsCalculator.calculateWinningStatistics().getWinningInfo()
                .get(WinningCriteria.FOURTH)).isEqualTo(1);
    }

    @DisplayName("5등을 정상적으로 계산한다")
    @Test
    void testFifthPrize() {
        lottos.set(1, new Lotto(Arrays.asList(3, 5, 11, 15, 34, 37))); // 5등 번호로 변경
        assertThat(winningStatisticsCalculator.calculateWinningStatistics().getWinningInfo()
                .get(WinningCriteria.FIFTH)).isEqualTo(1);
    }
}
