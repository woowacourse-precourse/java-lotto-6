package lotto.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoWinningTest {

    @Test
    public void testWinningCheck() {
        LottoWinning lottoWinning = new LottoWinning();

        // Creating purchased lottos
        List<Lotto> purchasedLottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 13)));

        // Winning numbers and bonus number
        List<Integer> winningNumbers = Arrays.asList(3, 4, 5, 6, 7, 8);
        int bonusNumber = 13;

        List<LottoRanking> expectedRankings = Arrays.asList(
                LottoRanking.FOURTH,
                LottoRanking.SECOND);

        List<LottoRanking> actualRankings = lottoWinning.winningCheck(purchasedLottos, winningNumbers, bonusNumber);

        assertEquals(expectedRankings, actualRankings);
    }
}
