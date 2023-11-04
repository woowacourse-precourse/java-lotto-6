package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QuantityTest {

    @DisplayName("가격에 맞는 로또 수를 반환한다.")
    @Test
    void createQuantityTest() {
        Assertions.assertEquals(100, new Quantity(new Price(100000)).getQuantity());
    }
}