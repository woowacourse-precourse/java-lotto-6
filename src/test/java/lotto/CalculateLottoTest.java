package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.Controller.CalculateLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateLottoTest {
    CalculateLotto calculateLotto;
    @BeforeEach
    void setUp(){
        calculateLotto = new CalculateLotto();
    }

    @Test
    void 일치하는_번호_갯수_확인(){
        assertEquals(6, calculateLotto.checkMatch(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(5, calculateLotto.checkMatch(List.of(11,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(1, calculateLotto.checkMatch(List.of(11,12,13,14,15,6), List.of(1,2,3,4,5,6)));
        assertEquals(3, calculateLotto.checkMatch(List.of(11,2,13,4,15,6), List.of(1,2,3,4,5,6)));
    }

    @Test
    void 수익률_계산_확인(){
        assertEquals(62.5, calculateLotto.roi(5000, 8000));
        assertEquals(285.7, calculateLotto.roi(20000, 7000));
        assertEquals(28571428.6, calculateLotto.roi(2_000_000_000, 7000));
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
        assertEquals(10000, calculateLotto.getProfit(matchMap));
        Map<Integer, Integer> matchMap2 = Map.of(
                3,2,
                4,0,
                5,1,
                6,0,
                55,0
        );
        assertEquals(1_510_000, calculateLotto.getProfit(matchMap2));

        Map<Integer, Integer> matchMap3 = Map.of(
                3,0,
                4,0,
                5,0,
                6,1,
                55,0
        );
        assertEquals(2_000_000_000, calculateLotto.getProfit(matchMap3));
    }
}
