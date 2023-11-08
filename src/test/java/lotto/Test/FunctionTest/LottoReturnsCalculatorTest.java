package lotto.Test.FunctionTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import lotto.model.lottoResultChecker.LottoRank;
import lotto.model.lottoResultChecker.LottoReturnsCalculator;
import java.util.EnumMap;
import java.util.Map;

public class LottoReturnsCalculatorTest {

    private LottoReturnsCalculator returnsCalculator;

    @BeforeEach
    void setUp() {
        returnsCalculator = new LottoReturnsCalculator();
    }

    @Test
    @DisplayName("총 수익이 구매 금액보다 클 때 올바른 수익률을 계산해야 한다")
    void WhenProfitsgreaterTest() {
        Map<LottoRank, Integer> rankResults = new EnumMap<>(LottoRank.class);
        rankResults.put(LottoRank.FIRST, 1);

        long totalCost = 100000;
        double expectedReturnRate = ((double) LottoRank.FIRST.getWinningMoney() / totalCost) * 100;
        expectedReturnRate = Math.round(expectedReturnRate * 10.0) / 10.0;

        double actualReturnRate = returnsCalculator.calculateReturnRate(rankResults, totalCost);
        assertEquals(expectedReturnRate, actualReturnRate, "수익률 계산이 올바르게 이루어져야 한다");
    }

    @Test
    @DisplayName("총 수익이 구매 금액보다 작을 때 올바른 수익률을 계산해야 한다")
    void WhenLossgreatTest() {
        Map<LottoRank, Integer> rankResults = new EnumMap<>(LottoRank.class);
        rankResults.put(LottoRank.FOURTH, 5);

        long totalCost = 100000;
        double expectedReturnRate = ((double) LottoRank.FOURTH.getWinningMoney() * 5 / totalCost) * 100;
        expectedReturnRate = Math.round(expectedReturnRate * 10.0) / 10.0;

        double actualReturnRate = returnsCalculator.calculateReturnRate(rankResults, totalCost);
        assertEquals(expectedReturnRate, actualReturnRate, "수익률 계산이 올바르게 이루어져야 한다");
    }

}
