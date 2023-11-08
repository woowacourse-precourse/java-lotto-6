package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    private final String expectCost = "4000";
    private final int expectBuyCount = 4;
    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력한 구매 금액이 1000원 단위여야 한다.")
    @Test
    public void createOrderByMultipleOfThousand() {
        String cost = "4500";

        assertThatThrownBy(() -> new Order(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력한 금액이 숫자여야 한다.")
    @Test
    public void createOrderByNumeric() {
        String cost = "400zero";

        assertThatThrownBy(() -> new Order(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력한 금액은 0보다 큰 정수여야 한다.")
    @Test
    public void createOrderByPositive() {
        String cost = "0";

        assertThatThrownBy(() -> new Order(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);;
    }
}
