package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @DisplayName("당첨 통계를 계산하는 기능 테스트")
    @Test
    public void testCalculateStatistics() {
        // Arrange
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> playerLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 14, 17, 18))
        );

        Calculator calculator = new Calculator(playerLottos, winningNumbers);

        Map<Rank, Integer> statistics = calculator.calculateStatistics();

        assertEquals(1, statistics.get(Rank.FIRST));
        assertEquals(1, statistics.get(Rank.SECOND));
        assertEquals(0, statistics.get(Rank.THIRD));
        assertEquals(0, statistics.get(Rank.FOURTH));
        assertEquals(1, statistics.get(Rank.FIFTH));
    }
}
