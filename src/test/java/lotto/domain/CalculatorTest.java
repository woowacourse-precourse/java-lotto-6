package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @DisplayName("수익률은 소수점 둘째 자리에서 반올림해서 계산한다.")
    @Test
    void 수익률_계산() {
        //given
        long prize = 5000;
        Amount amount = new Amount(8000);

        //when
        String roi = calculator.calculateROI(prize, amount);

        //then
        assertThat(roi).isEqualTo("62.5");
    }

}
