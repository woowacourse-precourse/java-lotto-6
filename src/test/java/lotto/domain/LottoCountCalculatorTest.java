package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LottoCountCalculatorTest {

    @Test
    public void lottoCountCalculatorTest() {
        List<Lotto> myLottoTickets = new ArrayList<>();
        List<Integer> winLottoNumbers;

        winLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        myLottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        LottoCountCalculator calculator = new LottoCountCalculator(myLottoTickets, winLottoNumbers, 7);

        Map<Integer, Integer> countResult = calculator.getCountResult();

        assertEquals(1, countResult.get(6).intValue());
    }
}