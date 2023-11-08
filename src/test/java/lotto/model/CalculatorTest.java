package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private List<Lotto> playerLottos;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        playerLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 14, 17, 18)),
                new Lotto(Arrays.asList(11, 6, 3, 4, 17, 18)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 17, 18)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 17, 18)),
                new Lotto(Arrays.asList(41, 42, 43, 44, 37, 38))
        );

        winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
    }

    @DisplayName("당첨 내역을 계산하는 기능 테스트")
    @Test
    public void testCalculateStatistics() {
        Calculator calculator = new Calculator(playerLottos, winningNumbers);

        Map<Rank, Integer> winningStatistics = calculator.calculateStatistics();

        assertEquals(1, winningStatistics.get(Rank.FIRST));
        assertEquals(1, winningStatistics.get(Rank.SECOND));
        assertEquals(0, winningStatistics.get(Rank.THIRD));
        assertEquals(2, winningStatistics.get(Rank.FOURTH));
        assertEquals(2, winningStatistics.get(Rank.FIFTH));
    }

    @DisplayName("총 수익률을 계산하는 기능 테스트")
    @Test
    public void testCalculateWinningRate() {
        Calculator calculator = new Calculator(playerLottos, winningNumbers);
        Map<Rank, Integer> winningStatistics = calculator.calculateStatistics();

        int money = 7000;
        double winningRate = calculator.calculateWinningRate(winningStatistics, money);

        assertEquals(29001500, winningRate, 100);
    }
}
