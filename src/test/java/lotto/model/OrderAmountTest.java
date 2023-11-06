package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderAmountTest {
    @Test
    @DisplayName("로또 금액을 정상적인 가격으로 입력")
    void orderNormalPrice(){
        OrderAmount order = new OrderAmount(8000);
        int orderAmount = order.amountOfLotto();
        assertThat(orderAmount).isEqualTo(8);
    }
}