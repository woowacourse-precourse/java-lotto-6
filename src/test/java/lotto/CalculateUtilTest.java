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
}
