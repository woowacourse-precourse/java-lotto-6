package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {
    @DisplayName("수익률 계산")
    @Test
    void testCalculateRate() {
        List<Integer> result = List.of(1, 0, 0, 0, 0);
        int purchaseAmount = 8000;
        Calculation calculation = new Calculation(result, purchaseAmount);

        double rate = calculation.calculateRate();

        assertThat(rate).isEqualTo(62.5);
    }


}
