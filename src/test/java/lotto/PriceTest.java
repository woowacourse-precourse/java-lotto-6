package lotto;

import lotto.domain.lotto.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @Test
    @DisplayName("구매 금액이 100000을 넘어갈 수 없다.")
    void createPrice_Value_throwsIllegalArgumentException() {
        // given
        long value = 10000000;

        // when & then
        assertThatThrownBy(() -> new Price(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금액은 1000으로 나누어 떨어져야 한다. ")
    void createPrice_Value2_throwsIllegalArgumentException() {
        // given
        long value = 10003;

        // when & then
        assertThatThrownBy(() -> new Price(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
