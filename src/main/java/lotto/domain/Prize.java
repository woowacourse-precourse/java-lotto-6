package lotto.domain;

import java.math.BigDecimal;

public class Prize {
    private static final BigDecimal FIFTH_PRIZE = new BigDecimal("5000");
    private static final BigDecimal FOURTH_PRIZE = new BigDecimal("50000");
    private static final BigDecimal THIRD_PRIZE = new BigDecimal("1500000");
    private static final BigDecimal SECOND_PRIZE = new BigDecimal("30000000");
    private static final BigDecimal FIRST_PRIZE = new BigDecimal("2000000000");
    private final int fifth;
    private final int fourth;
    private final int third;
    private final int second;
    private final int first;

    public Prize(int fifth, int fourth, int third, int second, int first) {
        this.fifth = fifth;
        this.fourth = fourth;
        this.third = third;
        this.second = second;
        this.first = first;
    }

}
