package lotto;

import lotto.Model.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PriceTest {

    @DisplayName("1000원 단위로 잘 나눠지는지 확인")
    @Test
    void 천원단위로나누기() {
        Price price = new Price(5000);

        Assertions.assertThat(price.divideWithOneThousands()).isEqualTo(5);
    }
}
