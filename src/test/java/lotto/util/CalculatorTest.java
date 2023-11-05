package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.LottoGame;
import lotto.util.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private static final int TEST_NUM1 = 15000;
    private static final int TEST_NUM2 = 1000;
    private static final int TEST_NUM3 = 999;
    private static final Double TEST_AMOUNT = Double.valueOf(10000);
    private static final Double TEST_EARNING = Double.valueOf(150000);
    private static Calculator calculator;


    @DisplayName("나눗셈 계산 확인")
    @Test
    void divide() {
        assertThat(calculator.divide(TEST_NUM1, TEST_NUM2))
                .isEqualTo(TEST_NUM1/TEST_NUM2);
    }

    @DisplayName("배수 확인")
    @Test
    void isMultiple() {
        assertThat(calculator.isMultiple(TEST_NUM1, TEST_NUM2))
                .isTrue();
        assertThat(calculator.isMultiple(TEST_NUM1, TEST_NUM3))
                .isFalse();
    }


    @DisplayName("백분율, 퍼센티지 계산 확인")
    @Test
    void percentage() {
        assertThat(calculator.percentage(TEST_EARNING, TEST_AMOUNT))
                .isEqualTo((TEST_EARNING / TEST_AMOUNT) * 100);

    }

    @DisplayName("첫째 자리까지 반올림 정상 확인")
    @Test
    void rounds() {
        double rate = 46.123123;
        String expect = String.format(LottoGame.DECIMAL_FORMAT, rate);
        System.out.println(expect);

        assertThat(calculator.rounds(rate))
                .isEqualTo(expect);
    }
}
