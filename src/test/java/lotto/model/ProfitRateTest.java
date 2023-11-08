package lotto.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ProfitRateTest {

    @Test
    void 수익률_계산() {
        int[] value = new int[]{1,0,0,0,0};
        String money = "8000";
        ProfitRate profitRate = new ProfitRate(value, money);

        assertThat(profitRate.calculate()).isEqualTo(0.625);
    }
}
