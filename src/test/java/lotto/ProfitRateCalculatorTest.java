package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import lotto.domain.Money;
import lotto.domain.ProfitRateCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitRateCalculatorTest {
    @Test
    @DisplayName("수익률을 계산해주는 기능 테스트")
    void calculatingProfitTest() {
        ProfitRateCalculator profitRateCalculator = new ProfitRateCalculator();
        assertThat(profitRateCalculator.calculateProfitRate(List.of(Rank.FIFTH, Rank.FIFTH), new Money(2000)))
                .isEqualTo(10000 / 2000);
    }
}
