package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoCalculatorTest {
    @Test
    void 일치하는_번호_갯수_확인(){
        LottoCalculator lottoCalculator = new LottoCalculator();
        assertEquals(6, lottoCalculator.checkMatch(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(5, lottoCalculator.checkMatch(List.of(11,2,3,4,5,6), List.of(1,2,3,4,5,6)));
        assertEquals(1, lottoCalculator.checkMatch(List.of(11,12,13,14,15,6), List.of(1,2,3,4,5,6)));
        assertEquals(3, lottoCalculator.checkMatch(List.of(11,2,13,4,15,6), List.of(1,2,3,4,5,6)));
    }
}
