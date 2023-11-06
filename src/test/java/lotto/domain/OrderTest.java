package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    private static final int LOTTO_PRICE = 1000;

    @Test
    void 유효숫자_입력시_객체_정상_생성() {
        int quantity = 10;
        int buyAmount = LOTTO_PRICE * quantity;

        Order order = new Order(buyAmount);

        Assertions.assertThat(order.getQuantity()).isEqualsTo(quantity);
    }

    @Test
    void 금액이_나누어_떨어지지_않을시_예외_처리() {
        int buyAmount = LOTTO_PRICE * 10 + 1;

        Assertions.assertThatThrownBy(() -> new Order(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("[ERROR] 구입 금액은 %d의 배수여야 합니다.", LOTTO_PRICE));
    }
}