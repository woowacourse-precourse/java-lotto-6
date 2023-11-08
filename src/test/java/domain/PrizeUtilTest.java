package domain;

import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeUtilTest {

    private final PrizeUtil prizeUtil;

    public PrizeUtilTest() {
        this.prizeUtil = new PrizeUtil();
    }

    @Test
    @DisplayName("수익률을 제대로 계산하는 지 확인하는 테스트")
    void calculateEarningRate() {
        Map<Integer, Integer> lottoScore = new java.util.HashMap<>(Map.of(
                0, 0,
                1, 0,
                2, 0,
                3, 1,
                4, 0,
                5, 0,
                6, 0
        ));
        String earningRate = prizeUtil.calculateEarningRate(8, lottoScore, 0);
        Assertions.assertEquals(earningRate, "62.5");
    }
}