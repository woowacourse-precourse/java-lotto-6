package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfitTest {

    @Test
    public void testCalculateProfit() {
        Profit profitCalculator = new Profit(0);

        List<Result> winningResults = new ArrayList<>();
        winningResults.add(new Result(3, true));
        winningResults.add(new Result(4, true));
        winningResults.add(new Result(5, false));
        winningResults.add(new Result(6, false));

        int purchaseAmount = 10000;
        boolean hasBonus = true;
        double calculatedProfit = profitCalculator.calculateProfit(winningResults, purchaseAmount);

        // Expected profit calculation: (5000 + 10000) / 10000 = 15000 / 10000 = 1.5
        assertEquals(2.001555E7, calculatedProfit, 0.001);
    }
}
