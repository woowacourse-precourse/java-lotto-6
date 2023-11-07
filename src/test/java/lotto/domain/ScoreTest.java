package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {
    @DisplayName("얻은 수익률 이 잘 계산 되는지 검증 한다.")
    @Test
    public void testTotalProfit() {
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                new Lotto(List.of(13, 14, 15, 16, 17, 18))
        );

        WinningNumber winningNumber = new WinningNumber(
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                6
        );

        Lotties lotties = new Lotties(lottos);

        Map<Result, Integer> scoreMap = Score.calculate(winningNumber, lotties);
        int totalProfit = Score.profit(scoreMap);

        int expectedTotalProfit = 0;
        for (Result result : scoreMap.keySet()) {
            expectedTotalProfit += result.getWinnings() * scoreMap.get(result);
        }
        assertEquals(expectedTotalProfit, totalProfit);
    }

}
