package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TotalProfitCalculatorTest {
    LottoStatistics lottoStatistics;
    TotalProfitCalculator totalProfitCalculator;

    @BeforeEach
    public void setUp() {
        List<Lotto> lottoRepository = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12))
        );
        Lottos lottos = new Lottos(lottoRepository);

        List<Integer> winningNumbersRepository = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        WinningNumbers winningNumbersObj = new WinningNumbers(winningNumbersRepository, bonusNumber);

        lottoStatistics = new LottoStatistics(lottos, winningNumbersObj);
        lottoStatistics.compareLottosWithWinningNumbers();
    }

    @DisplayName("10000원으로 6개 번호 맞췄을때 수익률 20,000,000%")
    @Test
    void testCalculateSixNumbersMatch() {
        totalProfitCalculator = new TotalProfitCalculator(10000);

        double expectResult = 20000000.0;
        double ActualResult = totalProfitCalculator.calculateTotalProfit(lottoStatistics);

        assertEquals(expectResult, ActualResult);
    }

    @DisplayName("5000원으로 6개 번호 맞췄을때 수익률 40,000,000%")
    @Test
    void testCalculateTotalProfit() {
        totalProfitCalculator = new TotalProfitCalculator(5000);

        double expectResult = 40000000.0;
        double ActualResult = totalProfitCalculator.calculateTotalProfit(lottoStatistics);

        assertEquals(expectResult, ActualResult);
    }
}