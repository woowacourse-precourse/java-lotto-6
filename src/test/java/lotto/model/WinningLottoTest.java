package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLottoTest {

    @Test
    public void testCalculateWinningResults() {
        Lotto winningNumbers = new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30));
        Bonus bonus = new Bonus("35", winningNumbers);
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);

        List<Lotto> userLottos = new ArrayList<>();
        userLottos.add(new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30)));
        userLottos.add(new Lotto(Arrays.asList(5, 10, 15, 20, 25, 40)));
        userLottos.add(new Lotto(Arrays.asList(5, 10, 15, 20, 30, 35)));
        userLottos.add(new Lotto(Arrays.asList(5, 10, 15, 20, 30, 40)));
        userLottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));

        List<Result> winningResults = winningLotto.calculateWinningResults(userLottos, winningLotto);

        List<Result> expectedResults = Arrays.asList(
                Result.of(6, false), Result.of(5, false), Result.of(6, true), Result.of(5, false), Result.of(1, false)
        );

        for (int i = 0; i < expectedResults.size(); i++) {
            Result expected = expectedResults.get(i);
            Result actual = winningResults.get(i);
            assertEquals(expected.getMatchCount(), actual.getMatchCount());
            assertEquals(expected.isHasBonus(), actual.isHasBonus());
        }
    }
}
