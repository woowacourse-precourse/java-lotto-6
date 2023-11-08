package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import lotto.utils.constant.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {
    @Test
    @DisplayName("수익률을 올바르게 계산하는지")
    void calculateProfit() {
        assertThat(new LottoProfit(Map.of(Rank.FIRST,0,
                Rank.SECOND,0, Rank.THIRD,0, Rank.FOURTH,0, Rank.FIFTH,1)
                ,new Money(8000))
                .getResult())
                .isEqualTo(62.5);
    }
}