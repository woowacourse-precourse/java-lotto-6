package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RankDeterminerTest {
    @Test
    void 구매한_로또의_순위_결과() {
        List<Lotto> userLottos = Arrays.asList(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),  //1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),  //2등
                new Lotto(List.of(1, 2, 3, 4, 5, 8)),  //3등
                new Lotto(List.of(1, 2, 3, 4, 8, 9)),  //4등
                new Lotto(List.of(1, 2, 3, 9, 10, 11))  //5등
        );

        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(winningNumber);
        BonusNumber bonusNumber = new BonusNumber("7", winningNumber);

        RankDeterminer rankDeterminer = new RankDeterminer(winningLotto, bonusNumber);
        List<LottoRank> actualRanks = rankDeterminer.determineAllRank(userLottos);

        List<LottoRank> expectedRanks = List.of(
                LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.FOURTH,
                LottoRank.FIFTH
        );

        assertEquals(expectedRanks, actualRanks);
    }


}
