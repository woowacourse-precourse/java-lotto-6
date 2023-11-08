package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.Result;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))
        );
        lottos = new Lottos(lottoList);
        winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    }

    @DisplayName("당첨 결과에 따라 당첨 금액을 계산할 수 있다.")
    @Test
    void calculateResult() {
        Result result = new Result(lottos, winningLotto);
        assertEquals(1, result.getRankCount(Rank.FIRST));
        assertEquals(1, result.getRankCount(Rank.SECOND));
        assertEquals(1, result.getRankCount(Rank.FOURTH));
        assertEquals(0, result.getRankCount(Rank.MISS));

        int totalWinnings = result.getWinnings();
        assertEquals(2_000_000_000 + 30_000_000 + 50_000, totalWinnings);
    }
}

