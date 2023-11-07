package lotto.model;

import lotto.model.user.LottoResults;
import lotto.model.user.OrderAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderAmountTest {
    @Test
    @DisplayName("로또 금액을 정상적인 가격으로 입력")
    void orderNormalPrice(){
        OrderAmount order = new OrderAmount("8000");
        int orderAmount = order.amountOfLotto();
        assertThat(orderAmount).isEqualTo(8);
    }

    @Test
    @DisplayName("로또 수익률 계산")
    void calculateProfit(){
        OrderAmount order = new OrderAmount("8000");
        LottoResults results = new LottoResults( 0, 0, 0, 0, 1);
        assertThat(order.calculateProfit(results)).isEqualTo(62.5);
    }

    @Test
    @DisplayName("구입 금액 입력시 문자를 입력하면 예외가 발생한다.")
    void createOrderAmountByLetter(){
        assertThatThrownBy(() -> new OrderAmount("letter"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}