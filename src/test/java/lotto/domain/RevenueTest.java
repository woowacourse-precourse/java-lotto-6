package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RevenueTest {

    private int payment;
    private String result;
    private Map<Integer, Integer> winningTicketsCount;
    private Revenue revenue;

    @BeforeEach
    void setUp() {
        revenue = new Revenue();
        winningTicketsCount = new HashMap<>();
    }

    @Test
    void 수익률_100_계산_기능_테스트() {
        payment = 1550000;
        winningTicketsCount.put(1, 0);
        winningTicketsCount.put(2, 0);
        winningTicketsCount.put(3, 1);
        winningTicketsCount.put(4, 1);
        winningTicketsCount.put(5, 0);

        result = revenue.calculateRevenue(payment, winningTicketsCount);
        assertThat(result).isEqualTo("100.0");
    }

    @Test
    void 수익률_50_계산_기능_테스트() {
        payment = 3400000;
        winningTicketsCount.put(1, 0);
        winningTicketsCount.put(2, 0);
        winningTicketsCount.put(3, 1);
        winningTicketsCount.put(4, 4);
        winningTicketsCount.put(5, 0);

        result = revenue.calculateRevenue(payment, winningTicketsCount);
        assertThat(result).isEqualTo("50.0");
    }

    @Test
    void 수익률_33_계산_기능_테스트() {
        payment = 180000;
        winningTicketsCount.put(1, 0);
        winningTicketsCount.put(2, 0);
        winningTicketsCount.put(3, 0);
        winningTicketsCount.put(4, 1);
        winningTicketsCount.put(5, 2);

        result = revenue.calculateRevenue(payment, winningTicketsCount);

        assertThat(result).isEqualTo("33.3");
    }

    @Test
    void 수익률_10_계산_기능_테스트() {
        payment = 700000;
        winningTicketsCount.put(1, 0);
        winningTicketsCount.put(2, 0);
        winningTicketsCount.put(3, 0);
        winningTicketsCount.put(4, 1);
        winningTicketsCount.put(5, 4);

        result = revenue.calculateRevenue(payment, winningTicketsCount);

        assertThat(result).isEqualTo("10.0");
    }
}
