package lotto.domain;

import static lotto.constants.Rank.FOURTH;
import static lotto.constants.Rank.SECOND;
import static lotto.constants.Rank.THIRD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constants.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    List<WinningCount> winningCounts;

    @Test
    @DisplayName("당첨 숫자의 개수와 보너스 숫자 일치여부가 담긴 결과가 담긴 리스트를 받아 순위의 개수가 담긴 해시맵으로 반환")
    void classifyTest() {
        Map<Rank, Integer> winningResult = Calculator.classify(winningCounts);
        assertThat(winningResult.get(SECOND)).isEqualTo(1);
        assertThat(winningResult.get(THIRD)).isEqualTo(1);
        assertThat(winningResult.get(FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 됐을 경우 구매금액 대비 수익을 퍼센트로 환산한 값 계산")
    void calculateProfitRateTest() {
        Map<Rank, Integer> winningResult = Calculator.classify(winningCounts);
        int purchaseAmount = 100000;
        double profitRate = Calculator.calculateProfitRate(winningResult, purchaseAmount);
        assertThat(profitRate).isEqualTo(
                (SECOND.getPrize() + THIRD.getPrize() + FOURTH.getPrize()) * 100.0 / purchaseAmount);
    }

    @BeforeEach
    void setUp() {
        winningCounts = new ArrayList<>();
        winningCounts.add(new WinningCount(5, true));
        winningCounts.add(new WinningCount(5, false));
        winningCounts.add(new WinningCount(4, false));
    }


}