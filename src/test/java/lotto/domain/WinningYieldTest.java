package lotto.domain;

import lotto.dto.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningYieldTest {
    @DisplayName("수익률은 소수점 둘째 자리에서 반올림한다.")
    @Test
    void getYield() {
        Cash cash = new Cash(131000);
        Profit profit = new Profit();

        Ranks ranks = new Ranks(List.of(Rank.FIFTH, Rank.FOURTH, Rank.NONE));

        profit.calculateAmount(ranks);


        WinningYield winningYield = new WinningYield(cash, profit);

        assertThat(winningYield.getYield()).isEqualTo(42.0);
    }
}