package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    WinningResult winningResult;

    @BeforeEach
    void setUp() {
        winningResult = new WinningResult();
    }

    @DisplayName("당첨 결과에 1등을 1번 추가하면 1등이 1개이다.")
    @Test
    void addResultByFirst() {
        // given
        int expectedCount = 1;
        // when
        winningResult.addResult(Rank.FIRST);
        int actualCount = winningResult.getCount(Rank.FIRST);
        // then
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @DisplayName("당첨 결과가 저장된 대로 출력되는지 확인한다.")
    @Test
    void getCount() {
        // given
        int expectedFirstCount = 2;
        int expectedFourthCount = 3;
        int exptectedFifthCount = 1;
        // when
        winningResult.addResult(Rank.FIRST);
        winningResult.addResult(Rank.FIRST);
        int actualFirstCount = winningResult.getCount(Rank.FIRST);
        winningResult.addResult(Rank.FOURTH);
        winningResult.addResult(Rank.FOURTH);
        winningResult.addResult(Rank.FOURTH);
        int actualFourthCount = winningResult.getCount(Rank.FOURTH);
        winningResult.addResult(Rank.FIFTH);
        int actualFifthCount = winningResult.getCount(Rank.FIFTH);
        // then
        assertThat(actualFirstCount).isEqualTo(expectedFirstCount);
        assertThat(actualFourthCount).isEqualTo(expectedFourthCount);
        assertThat(actualFifthCount).isEqualTo(exptectedFifthCount);
    }

    @DisplayName("총합 로또 당첨금을 계산해서 반환한다.")
    @Test
    void calculateTotalPrizeMoney() {
        // given
        int expectedTotalPrizeMoney = Rank.FIFTH.getPrizeMoney() + Rank.THIRD.getPrizeMoney();
        // when
        winningResult.addResult(Rank.THIRD);
        winningResult.addResult(Rank.FIFTH);
        int actualTotalPrizeMoney = winningResult.calculateTotalPrizeMoney();
        // then
        assertThat(actualTotalPrizeMoney).isEqualTo(expectedTotalPrizeMoney);
    }

    @DisplayName("로또 당첨금 수익률을 계산해서 반환한다.")
    @Test
    void calculateYield() {
        // given
        int totalPurchaseAmount = 8_000;
        double expectedYield = 100 * (double) Rank.FIFTH.getPrizeMoney() / totalPurchaseAmount;
        // when
        winningResult.addResult(Rank.FIFTH);
        double actualYield = winningResult.calculateYield(totalPurchaseAmount);
        // then
        assertThat(actualYield).isEqualTo(expectedYield);
    }
}
