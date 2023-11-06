package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    private Profit profit;
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        profit = new Profit();
        gameResult = new GameResult();

        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 9, 10));
        boolean hasBonusNumber = true;
        gameResult.setRankingNumbers(winningLotto, lotto1, hasBonusNumber);
        gameResult.setRankingNumbers(winningLotto, lotto2, hasBonusNumber);
    }

    @DisplayName("FIVE_PLUS_BONUS(30000000) 와 FOUR_WINS(50000) 를 합친 수익은 30050000 이다")
    @Test
    void calculateProfit() {
        profit.setProfit(gameResult);

        assertThat(profit.getProfit()).isEqualTo(30050000);
    }

    @DisplayName("총 수익률은 수익(30050000)을 구입금액(5000)으로 나누고 100으로 곱한 값(601000.0)이다")
    @Test
    void calculateProfitRate() {
        Money money = new Money("5000");

        profit.setProfit(gameResult);
        profit.setProfitRate(money);

        assertThat(profit.getProfitRate()).isEqualTo(601000.0f);
    }
}