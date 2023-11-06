package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculateUtilTest {

    @DisplayName("백분율 계산")
    @Test
    void calculatePercentage(){
        double percentage = CalculateUtil.calculatePercentage(12, 100);
        assertThat(percentage).isEqualTo(12);
    }

    @DisplayName("소수 원하는 자리수 반올림")
    @Test
    void round(){
        double number = CalculateUtil.round(11.555, 2);
        assertThat(number).isEqualTo(11.6);
    }
}
