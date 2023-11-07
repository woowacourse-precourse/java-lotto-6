package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.Controller.Calculate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculateTest {
    Calculate calculate;
    @BeforeEach
    void setUp(){
        calculate = new Calculate();
    }
    @Test
    void 발행한_로또_수량_확인(){
        int output = calculate.getLottoCount(8000);
        assertEquals(8, output);
        int output2 = calculate.getLottoCount(16000);
        assertEquals(16, output2);
        int output3 = calculate.getLottoCount(12500);
        assertEquals(12, output3);
        int output4 = calculate.getLottoCount(12345);
        assertEquals(12, output4);
    }

    @Test
    void 일치하는_번호_갯수_확인(){
        assertEquals(6, calculate.getMatchCount(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(5, calculate.getMatchCount(List.of(11,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(1, calculate.getMatchCount(List.of(11,12,13,14,15,6), List.of(1,2,3,4,5,6)));
        assertEquals(3, calculate.getMatchCount(List.of(11,2,13,4,15,6), List.of(1,2,3,4,5,6)));
    }

    @Test
    void 수익률_계산_확인(){
        assertEquals("62.5", calculate.getProfitRate(5000, 8000));
        assertEquals("285.7", calculate.getProfitRate(20000, 7000));
        assertEquals("28,571,428.6", calculate.getProfitRate(2_000_000_000, 7000));
    }



    @Test
    void 수익금_계산_확인(){
        Map<Integer, Integer> matchMap = Map.of(
                3,2,
                4,0,
                5,0,
                6,0,
                55,0
        );
        assertEquals(10000, calculate.getProfitCost(matchMap));
        Map<Integer, Integer> matchMap2 = Map.of(
                3,2,
                4,0,
                5,1,
                6,0,
                55,0
        );
        assertEquals(1_510_000, calculate.getProfitCost(matchMap2));

        Map<Integer, Integer> matchMap3 = Map.of(
                3,0,
                4,0,
                5,0,
                6,1,
                55,0
        );
        assertEquals(2_000_000_000, calculate.getProfitCost(matchMap3));
    }
}
