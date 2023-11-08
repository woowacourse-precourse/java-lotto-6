package lotto.model;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPlayerTest {
    @Test
    void testRateOfReturn() {
        int initialAmount = 10000;
        LottoPlayer player = new LottoPlayer(initialAmount);

        int income = 20000;
        double expectedRateOfReturn = 200.0;

        double rateOfReturn = player.computeRateOfReturn(income);
        assertEquals(expectedRateOfReturn, rateOfReturn, 0.01);
    }

    @Test
    void testGetLottoNumberByIndex() {
        int initialAmount = 5000;
        LottoPlayer player = new LottoPlayer(initialAmount);

        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        player.lottoGeneration(lottoNumbers);

        List<Integer> retrievedNumbers = player.getLottoNumberByIndex(0);
        assertEquals(lottoNumbers, retrievedNumbers);
    }
}
