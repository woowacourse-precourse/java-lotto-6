package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTierTest {
    @DisplayName("각 PrizeTier에 대한 상금 테스트")
    @Test
    void prizeMoneyTest() {
        int[] prizeMoneys = {0, 5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};

        PrizeTier[] prizeTiers = PrizeTier.values();

        for (int i = 0; i < prizeTiers.length; i++) {
            Assertions.assertEquals(prizeMoneys[i], prizeTiers[i].getPrizeMoney());
        }
    }
}
