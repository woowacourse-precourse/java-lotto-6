package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

class OutputTest {
    Output out = new Output();

    @Test
    void name() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 26, 34, 5, 6));
        List<Lotto> lottos = Arrays.asList(lotto1, lotto2, lotto3);
        out.printLotto(3, lottos);
    }

    @Test
    void winning() {
        Map<Integer, Integer> winningByRank = Map.of(1, 2, 2, 4, 3, 3, 4, 2, 5, 5);
        out.printWinning(winningByRank);
    }

    @Test
    void nam22e() {
        out.printYeild(64.99);
    }
}