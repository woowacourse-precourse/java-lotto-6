package lotto;

import lotto.domain.BuyPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.Config.PRICE_PER_LOTTO;
import static lotto.constant.ErrorMessage.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyPriceTest {
    @Test
    @DisplayName("구입 금액이 숫자가 아닐 경우 예외 발생")
    void priceNotNumeric() {
        assertThatThrownBy(() -> BuyPrice.from("천원"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PRICE_NOT_NUMERIC);
    }

    @Test
    @DisplayName("구입 금액이 음수일 경우 예외 발생")
    void priceNegative() {
        assertThatThrownBy(() -> BuyPrice.from("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PRICE_NEGATIVE);
    }

    @Test
    @DisplayName("잔돈이 발생할 때 예외 발생")
    void priceNotDivided() {
        assertThatThrownBy(() -> BuyPrice.from(String.valueOf((int) (PRICE_PER_LOTTO * 1.1))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PRICE_NOT_DIVIDED);
    }
}
