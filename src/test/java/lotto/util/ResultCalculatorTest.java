package lotto.util;

import lotto.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultCalculatorTest {
    @Test
    public void testCalculateWinningResults() {
        // Arrange
        ResultCalculator calculator = new ResultCalculator();
        UserLotto userLotto = createTestUserLotto();
        WinningLotto winningLotto = createTestWinningLotto();

        // Act
        List<Result> winningResults = calculator.calculateWinningResults(userLotto, winningLotto);

        // Assert
        assertEquals(3, calculator.countMatchingResults(winningResults, Rank.FIRST));
        assertEquals(1, calculator.countMatchingResults(winningResults, Rank.SECOND));
        assertEquals(0, calculator.countMatchingResults(winningResults, Rank.THIRD));
        assertEquals(0, calculator.countMatchingResults(winningResults, Rank.FOURTH));
        assertEquals(0, calculator.countMatchingResults(winningResults, Rank.FIFTH));
    }

    @Test
    public void testCalculateProfit() {
        // Arrange
        ResultCalculator calculator = new ResultCalculator();
        Amount purchaseAmount = new Amount("7000");
        List<Result> winningResults = createTestWinningResults();

        // Act
        double profit = calculator.calculateProfit(winningResults, purchaseAmount);

        // Assert
        assertEquals(2.9000785714285713E10, profit, 0.001);
    }

    private UserLotto createTestUserLotto() {
        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        userLottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        userLottos.add(new Lotto(List.of(13, 14, 15, 16, 17, 18)));
        return new UserLotto(userLottos);
    }

    private WinningLotto createTestWinningLotto() {
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus("7", winningNumbers);
        return new WinningLotto(winningNumbers, bonus);
    }

    private List<Result> createTestWinningResults() {
        List<Result> results = new ArrayList<>();
        results.add(Result.of(6, false));
        results.add(Result.of(5, true));
        results.add(Result.of(4, false));
        results.add(Result.of(3, false));
        results.add(Result.of(2, false));
        return results;
    }
}
