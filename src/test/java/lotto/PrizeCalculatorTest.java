package lotto;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PrizeCalculatorTest {

    private PrizeCalculaor prizeCalculator = new PrizeCalculaor();

    @Test
    void testCalculateTotalPrize() {
        List<Integer> countsOfWonLotto = List.of(0, 1, 2, 0, 1);
        int totalPrize = prizeCalculator.calculateTotalPrize(countsOfWonLotto);
        int expectedTotal = 50_000 + 2 * 15_000_000 + 2_000_000_000;
        assertEquals(expectedTotal, totalPrize);
    }

    @Test
    void testCalculateProfitRate() {
        int totalPrize = 2_065_000_000;
        int purchasingPrice = 5_000_000;
        float profitRate = prizeCalculator.calculateProfitRate(totalPrize, purchasingPrice);
        assertEquals(41300.0, profitRate);
    }
}
