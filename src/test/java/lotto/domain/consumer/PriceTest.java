package lotto.domain.consumer;

import lotto.exception.Price.PriceNot1KsException;
import lotto.exception.Price.PriceNotPositiveIntegerException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

    private static final int VALUE_100 = 100;
    private static final int VALUE_1001 = 1001;

    private static final int VALUE_0 = 0;
    private static final int VALUE_MINUS_1 = -1;

    @DisplayName("로또 구매 금액은 1,000원 단위이어야 함")
    @Test
    void testPriceNot1Ks() {
        Assertions.assertThatThrownBy(() -> new Price(VALUE_100)).isInstanceOf(PriceNot1KsException.class);
        Assertions.assertThatThrownBy(() -> new Price(VALUE_1001)).isInstanceOf(PriceNot1KsException.class);
    }

    @DisplayName("로또 구매 금액은 양의 정수이어야 함")
    @Test
    void testPriceNotPositiveInteger() {
        Assertions.assertThatThrownBy(() -> new Price(VALUE_0)).isInstanceOf(PriceNotPositiveIntegerException.class);
        Assertions.assertThatThrownBy(() -> new Price(VALUE_MINUS_1)).isInstanceOf(PriceNotPositiveIntegerException.class);
    }
}