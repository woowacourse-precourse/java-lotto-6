package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    @DisplayName("올바른 금액 생성 테스트")
    @Test
    void rightPriceTest() {
        Price price = new Price(1000);
        Assertions.assertThat(1000).isEqualTo(price.getPrice());
    }
}
