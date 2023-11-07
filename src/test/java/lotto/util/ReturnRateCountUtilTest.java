package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ReturnRateCountUtilTest {

    @DisplayName("수익과 투자 금액을 입력하면, 수익률을 계산한다.")
    @Test
    void countReturnRate() throws Exception {
        // Given
        int returnAmount = 5000;
        int investValue = 8000;

        // When
        double returnRate = ReturnRateCountUtil.countReturnRate(returnAmount, investValue);

        // Then
        assertThat(returnRate).isEqualTo(62.5);
    }
}
