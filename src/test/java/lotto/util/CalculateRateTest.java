package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateRateTest {
    private CalculateRate calculateRate;

    @BeforeEach
    void setUp() {
        calculateRate = new CalculateRate();
    }

    @Test
    @DisplayName("수익률을 계산해서 잘 반환 하는지 테스트")
    void calculateRate() {
        //given
        int purchaseAmount = 8000;
        int money = 5000;
        //when
        Double result = CalculateRate.getRate(purchaseAmount, money);
        //then
        assertEquals(result, 62.5);
    }


}