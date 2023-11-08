package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderCalculatorTest {
    @Test
    void checkThousandsFalse(){
        String value = "1230";
        OrderCalculator calc = new OrderCalculator(value);
        assertFalse(calc.checkThousands());
    }

    @Test
    void checkThousandsTrue(){
        String value = "123000";
        OrderCalculator calc = new OrderCalculator(value);
        assertTrue(calc.checkThousands());
    }

    @DisplayName("로또 판매 개수 제한")
    @Test
    void tooMuchValue(){
        String value = "1230000000";
        OrderCalculator calc = new OrderCalculator(value);
        assertTrue(calc.checkThousands());
    }

    @DisplayName("돈에 맞게 로또 개수를 결정하는지 확인하기")
    @Test
    void compute(){
        String value = "9000";
        OrderCalculator calc = new OrderCalculator(value);
        assertEquals(9, calc.compute());
    }
}