package lotto.domain.answer.check;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningMoneyCalculatorTest {

    @Test
    @DisplayName("모든 등수:빈도수에 대해 총 상금액을 계산합니다")
    void 모든_등수_빈도수_총상금액() {
    }

    @Test
    @DisplayName("해당 등수와 빈도수에 따른 해당 상금액을 계산합니다.")
    void 해당_등수_빈도수_해당상금액() {
        // GIVEN
        Integer rank = 1;
        Integer count = 2;

        // WHEN
        Long price = WinningMoneyCalculator.getPrice(rank, count);

        // THEN
        assertEquals(price, 4000000000L);
    }
}