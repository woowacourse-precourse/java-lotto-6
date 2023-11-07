package lotto.config;

import static lotto.config.LottoConfig.PRICE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoConfigTest {
    @Test
    void 숫자_얻기() {
        assertThat(PRICE.getNumber()).isEqualTo(1000);
    }
}