package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_LOTTO_AMOUNT = 1;

    @Test
    void 유효숫자_입력시_객체_정상_생성() {
        int quantity = 10;
        int buyAmount = LOTTO_PRICE * quantity;

        Order order = Order.create(buyAmount);

        Assertions.assertThat(order.getQuantity()).isEqualTo(quantity);
    }

    @Test
    void 금액이_나누어_떨어지지_않을시_예외_처리() {
        int buyAmount = LOTTO_PRICE * 10 + 1;

        Assertions.assertThatThrownBy(() -> Order.create(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("[ERROR] 구입 금액은 %d의 배수여야 합니다.", LOTTO_PRICE));
    }

    @Test
    void 최소_개수_미만_구입시_예외_처리() {
        int buyAmount = 0;

        Assertions.assertThatThrownBy(() -> Order.create(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("[ERROR] 구입할 로또 개수는 최소 %d개 이상이어야 합니다.", MIN_LOTTO_AMOUNT));
    }

    @Test
    void 구입_금액_음수_예외_처리() {
        int buyAmount = -5 * LOTTO_PRICE;

        Assertions.assertThatThrownBy(() -> Order.create(buyAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("[ERROR] 구입할 로또 개수는 최소 %d개 이상이어야 합니다.", MIN_LOTTO_AMOUNT));
    }


}