package lotto.support;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RevenueCalculatorTest {

    @DisplayName("6번의 로또를 뽑아 5등이 5개면 수익률이 500퍼센트인지")
    @Test
    void testRevenue() {
        RevenueCalculator revenueCalculator = new RevenueCalculator(List.of(Rate.FIFTH, Rate.FIFTH, Rate.FIFTH, Rate.FIFTH, Rate.FIFTH, Rate.FIFTH));
        revenueCalculator.calculate();
        Assertions.assertThat(revenueCalculator.getRevenue()).isEqualTo(500);
    }

    @DisplayName("2번의 로또를 뽑아 1등이 1개면 수익률이 100000000퍼센트인지")
    @Test
    void testRevenue2() {
        RevenueCalculator revenueCalculator = new RevenueCalculator(List.of(Rate.FIRST, Rate.MISS));
        revenueCalculator.calculate();
        Assertions.assertThat(revenueCalculator.getRevenue()).isEqualTo(100000000);
    }
}