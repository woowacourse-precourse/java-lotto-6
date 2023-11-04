package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CostTest {
    @DisplayName("금액으로 수량을 계산한다.")
    @Test
    void calculateQuantity() {
        //given
        Cost cost = new Cost(3000);

        //when
        int quantity = cost.calculateQuantity();

        //then
        assertThat(quantity)
                .isEqualTo(3);
    }

    @DisplayName("주어진 금액이 1000 단위가 아니면 예외가 발생한다.")
    @Test
    void test() {
        //given //when //then
        assertThatThrownBy(() -> new Cost(2500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1000 단위여야 한다.");
    }

}