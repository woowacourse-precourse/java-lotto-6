package lotto.domain;

import lotto.dto.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {
    @DisplayName("수익은 0원으로 초기화 된다.")
    @Test
    void createProfit() {
        Profit profit = new Profit();
        assertThat(profit.getAmount()).isEqualTo(0);
    }

    @DisplayName("주어진 당첨 내역으로 총 수익을 계산한다.")
    @Test
    void calculateAmount() {
        // given
        Profit profit = new Profit();
        Ranks ranks = new Ranks(List.of(Rank.FIFTH, Rank.FOURTH, Rank.NONE));

        // when
        profit.calculateAmount(ranks);

        // then
        assertThat(profit.getAmount()).isEqualTo(55000);
    }
}