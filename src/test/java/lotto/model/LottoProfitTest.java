package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoProfitTest {
    @Test
    @DisplayName("수익률을 올바르게 계산하는지")
    void calculateProfit() {
        assertThat(new LottoProfit(Map.of("1st",0,"2nd",0,"3rd",0,"4th",0,"5th",1),new Money(8000))
                .getResult())
                .isEqualTo(62.5);
    }
}