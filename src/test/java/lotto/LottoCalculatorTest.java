package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {
    LottoCalculator lottoCalculator;
    @BeforeEach
    void setUp(){
        lottoCalculator = new LottoCalculator();
    }

    @Test
    void 일치하는_번호_갯수_확인(){
        assertEquals(6, lottoCalculator.checkMatch(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(5, lottoCalculator.checkMatch(List.of(11,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(1, lottoCalculator.checkMatch(List.of(11,12,13,14,15,6), List.of(1,2,3,4,5,6)));
        assertEquals(3, lottoCalculator.checkMatch(List.of(11,2,13,4,15,6), List.of(1,2,3,4,5,6)));
    }

    @Test
    void 수익률_계산_확인(){
        assertEquals(62.5, lottoCalculator.roi(5000, 8000));
        assertEquals(285.71, lottoCalculator.roi(20000, 7000));
    }

    @Test
    void 수익금_계산(){
        Map<Integer, Integer> matchMap = Map.of(
                3,2,
                4,0,
                5,0,
                6,0,
                55,0
        );
        assertEquals(10000, lottoCalculator.getProfit(matchMap));
        Map<Integer, Integer> matchMap2 = Map.of(
                3,2,
                4,0,
                5,1,
                6,0,
                55,0
        );
        assertEquals(1_510_000, lottoCalculator.getProfit(matchMap2));
    }
}
