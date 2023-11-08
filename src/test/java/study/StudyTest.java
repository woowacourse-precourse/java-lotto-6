package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class StudyTest {
    @DisplayName("반올림 테스트")
    @Test
    void roundsTest() {
        assertThat(rounds(1.23, 1)).isEqualTo(1.2);
        assertThat(rounds(1.25, 1)).isEqualTo(1.3);
        assertThat(rounds(1.254, 2)).isEqualTo(1.25);
    }

    double rounds(double number, int decimalPoint) {
        return new BigDecimal(number).setScale(decimalPoint, RoundingMode.HALF_UP).doubleValue();
    }

}
