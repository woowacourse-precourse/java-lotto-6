package lotto.exception;

import lotto.model.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static lotto.exception.PriceException.*;

public class PriceExceptionTest {
    @DisplayName("가격 예외 테스트")
    @Test
    void checkPriceExceptionTest() {
        Assertions.assertThatThrownBy(() -> priceException(999)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> priceException(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천 원 단위가 아닌 가격 예외 테스트")
    @Test
    void thousandPriceExceptionTest() {
        Assertions.assertThatThrownBy(() -> thousandPriceException(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 가격 예외 테스트")
    @Test
    void checkRightPriceExceptionTest() {
        Price price = new Price(1000);
        Price resultPrice = priceException(1000);
        Assertions.assertThat(price.getPrice()).isEqualTo(resultPrice.getPrice());
    }
}
