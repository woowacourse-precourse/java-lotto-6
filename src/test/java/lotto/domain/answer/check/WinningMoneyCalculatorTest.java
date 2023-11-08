package lotto.domain.answer.check;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningMoneyCalculatorTest {

    @Test
    @DisplayName("모든 등수:빈도수에 대해 총 상금액을 계산합니다")
    void 모든_등수_빈도수_총상금액() {
        // GIVEN
        Integer rank1 = 1;
        Integer count1 = 1;
        Integer rank2 = 2;
        Integer count2 = 1;
        Integer rank3 = 3;
        Integer count3 = 1;
        Map<Integer, Integer> rankToCount = new HashMap<>();
        rankToCount.put(rank1, count1);
        rankToCount.put(rank2, count2);
        rankToCount.put(rank3, count3);

        // WHEN
        Long winnigPrice = WinningMoneyCalculator.calculateWinnigPrice(rankToCount);

        // THEN
        assertEquals(2000000000 + 30000000 + 1500000, winnigPrice);
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