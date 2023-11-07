package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("Score 클래스 의 Calculate 테스트 로또 결과를 합산 하여 결과 생성")
    @Test
    public void testCalculate() {
        List<Lotto> lottos = List.of(
                // 6개 매치 7, 8, 9, 10, 11, 12
                new Lotto(List.of(7, 8, 9, 10, 11, 12)),
                // 5개 + 보너스 7, 8, 9, 10, 11, 12 /  보너스 : 6
                new Lotto(List.of(6, 7, 8, 9, 11, 12)),
                // 5개  7, 8, 9, 10, 11, 12
                new Lotto(List.of(7, 8, 9, 10, 11, 13)),
                // 4개 7, 8, 9, 10, 11, 12
                new Lotto(List.of(7, 8, 9, 10, 17, 18)),
                // 3개
                new Lotto(List.of(7, 8, 9, 16, 17, 18))
        );

        WinningNumber winningNumber = new WinningNumber(new Lotto(List.of(7, 8, 9, 10, 11, 12)), 6);
        Lotties lotties = new Lotties(lottos);
        Map<Result, Integer> scoreMap = Score.calculate(winningNumber, lotties);

        assertAll(
                () -> assertEquals(1, scoreMap.get(Result.SIX_MATCH)),
                () -> assertEquals(1, scoreMap.get(Result.FIVE_AND_BONUS_MATCH)),
                () -> assertEquals(1, scoreMap.get(Result.FIVE_MATCH)),
                () -> assertEquals(1, scoreMap.get(Result.FOUR_MATCH)),
                () -> assertEquals(1, scoreMap.get(Result.THREE_MATCH))
        );
    }

}
