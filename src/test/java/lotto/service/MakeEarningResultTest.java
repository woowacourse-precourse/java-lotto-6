package lotto.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
public class MakeEarningResultTest {
    @DisplayName("수익률 계산 테스트")
    @Test
    void testCalRate() {
        assertThat(MakeEarningResult.calRate(1000, 10000)).contains("10.0%");
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void testCalRate2() {
        assertThat(MakeEarningResult.calRate(5000, 8000)).contains("62.5%");
    }
}
