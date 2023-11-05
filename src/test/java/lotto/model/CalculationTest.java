package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculationTest {
    @Test
    void testCalculateAll() {
        List<Integer> result = List.of(1, 0, 0, 0, 0);
        int purchaseAmount = 8000;
        Calculation calculation = new Calculation(result, purchaseAmount);

        double rate = calculation.calculateAll();

        assertThat(rate).isEqualTo(62.5);
    }


}
