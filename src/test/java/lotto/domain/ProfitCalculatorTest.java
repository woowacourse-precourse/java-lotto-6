package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProfitCalculatorTest {

    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    @Test
    @DisplayName("Money두개를 입력 받아 백분률을 반환한다.")
    void returnProfitRateByTwoMoneyInput() {
        Money profit = Money.from(10000);
        Money purchaseAmount=Money.from(1000);

        assertThat(profitCalculator.calcRate(profit,purchaseAmount)).isEqualTo(profit.calcProfitRate(purchaseAmount));
    }

    @Test
    @DisplayName("Rank들을 입력받아 전체의 합을 반환한다.")
    void returnProfitByRanksInput() {
        assertThat(profitCalculator.calcProfit(List.of(Rank.SIX))).isEqualTo(Rank.SIX.getMoney());
    }
}
