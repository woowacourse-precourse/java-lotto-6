package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @DisplayName("당첨 결과에 1등을 1번 추가하면 1등이 1개이다.")
    @Test
    void addResultByFirst() {
        // given
        WinningResult winningResult = new WinningResult();
        // when
        winningResult.addResult(Rank.FIRST);
        // then
        assertThat(winningResult.getCount(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 결과가 저장된 대로 출력되는지 확인한다.")
    @Test
    void getCount() {
        // given
        WinningResult winningResult = new WinningResult();
        // when
        winningResult.addResult(Rank.FIRST);
        winningResult.addResult(Rank.FIRST);
        winningResult.addResult(Rank.SECOND);
        winningResult.addResult(Rank.THIRD);
        winningResult.addResult(Rank.FOURTH);
        winningResult.addResult(Rank.FIFTH);
        // then
        assertThat(winningResult.getCount(Rank.FIRST)).isEqualTo(2);
        assertThat(winningResult.getCount(Rank.SECOND)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.THIRD)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.FOURTH)).isEqualTo(1);
        assertThat(winningResult.getCount(Rank.FIFTH)).isEqualTo(1);
    }

    @DisplayName("총합 로또 당첨금을 계산해서 반환한다.")
    @Test
    void calculateTotalPrizeMoney() {
        // given
        WinningResult winningResult = new WinningResult();
        // when
        winningResult.addResult(Rank.THIRD);
        winningResult.addResult(Rank.FOURTH);
        winningResult.addResult(Rank.FIFTH);
        // then
        assertThat(winningResult.calculateTotalPrizeMoney()).isEqualTo(1_555_000);
    }

    @DisplayName("로또 당첨금 수익률을 계산해서 반환한다.")
    @Test
    void calculateYield() {
        // given
        int totalPurchaseAmount = 8_000;
        double expectedYield = 100 * (double) Rank.THIRD.getPrizeMoney() / totalPurchaseAmount;
        // when
        WinningResult winningResult = new WinningResult();
        winningResult.addResult(Rank.THIRD);
        double actualYield = winningResult.calculateYield(totalPurchaseAmount);
        // then
        assertThat(actualYield).isEqualTo(expectedYield);
    }
}
