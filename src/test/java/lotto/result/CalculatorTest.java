package lotto.result;

import java.util.HashMap;
import java.util.Map;
import lotto.Grade;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static lotto.util.Constant.PERCENT_BASE;
import static lotto.util.Constant.RATE;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @DisplayName("당첨 통계와 구입 금액으로 수익률을 계산할 수 있다.")
    @Test
    void calculateProfitRate() {
        Map<Grade, Integer> map = new HashMap<>();
        int purchasedPrice = 8000;
        map.put(Grade.FIFTH, 2);
        map.put(Grade.FIRST, 1);

        long sum = map.get(Grade.FIFTH) * Grade.FIFTH.getPrice() + map.get(Grade.FIRST) * Grade.FIRST.getPrice();
        double expectedProfitRate = Math.round((sum * PERCENT_BASE / purchasedPrice) * RATE) / RATE;

        double profitRate = calculator.calculateProfitRate(map, purchasedPrice);

        assertThat(profitRate).isEqualTo(expectedProfitRate);
    }
}
