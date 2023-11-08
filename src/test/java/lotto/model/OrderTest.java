package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    private final String expectCost = "11000";
    private final int expectBuyCount = 11;
    private final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력한 구매 금액이 1000원 단위여야 한다.")
    @Test
    void createOrderByMultipleOfThousand() {
        String cost = "4500";

        assertThatThrownBy(() -> new Order(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력한 금액이 숫자여야 한다.")
    @Test
    void createOrderByNumeric() {
        String cost = "400zero";

        assertThatThrownBy(() -> new Order(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("입력한 금액은 0보다 큰 정수여야 한다.")
    @Test
    void createOrderByPositive() {
        String cost = "0";

        assertThatThrownBy(() -> new Order(cost))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
        ;
    }

    @DisplayName("구매 금액을 1000원 나눈것과 로또 수량이 같아야 한다.")
    @Test
    void createOrderByCostEqualAmount() {
        Order order = new Order(expectCost);
        int result = order.getBuyCount();

        assertThat(result).isEqualTo(expectBuyCount);
    }

    @DisplayName("수익률 계산이 올바른지 확인.")
    @Test
    void verifyCorrectCalcProfitRate() {
        Order order = new Order(expectCost);
        WinStatistics winStatistics = new WinStatistics();

        winStatistics.pushRank(Rank.SECOND);
        winStatistics.pushRank(Rank.FOURTH);

        String result = order.getResult(winStatistics);

        System.out.println(result);

        assertThat(result).contains("273081.8%");
    }
}
