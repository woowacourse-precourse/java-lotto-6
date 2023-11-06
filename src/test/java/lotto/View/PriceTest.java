package lotto.View;

import lotto.model.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {
    @DisplayName("잘못된 금액 생성 테스트. 에러 발생")
    @Test
    void wrongPriceTest() {
        Assertions.assertThatThrownBy(() -> new Price(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 금액 생성 테스트. 에러 발생")
    @Test
    void rightPriceTest() {
        Price price = new Price(1000);
        Assertions.assertThat(1000).isEqualTo(price.getPrice());
    }
}
