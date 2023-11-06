package lotto.Exception;

import lotto.model.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.exception.PriceException.checkPriceException;

public class PriceExceptionTest {
    @DisplayName("가격 예외 테스트")
    @Test
    void checkPriceExceptionTest() {
        //Assertions.assertThatThrownBy(() -> checkPriceException("a")).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPriceException(999)).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> checkPriceException(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 가격 예외 테스트")
    @Test
    void checkRightPriceExceptionTest() {
        Price price = new Price(1000);
        Price resultPrice = checkPriceException(1000);

        Assertions.assertThat(price.getPrice()).isEqualTo(resultPrice.getPrice());
    }
}
