package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RoundTest {

    @DisplayName("1.333 -> 1.3 인지 테스트")
    @Test
    void round_내림하는_경우() {
        double rate = 1.333;

        double result = round(rate);

        assertThat(result).isEqualTo(1.3);
    }

    @DisplayName("1.666 -> 1.7 인지 테스트")
    @Test
    void round_올림하는_경우() {
        double rate = 1.666;

        double result = round(rate);

        assertThat(result).isEqualTo(1.7);
    }

    private double round(double rate) {
        BigDecimal decimal = BigDecimal.valueOf(rate);
        decimal = decimal.setScale(1, RoundingMode.HALF_UP);
        return decimal.doubleValue();
    }
}
