package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @Test
    void 수익률_확인() {
        List<LottoRank> ranks = List.of(
                LottoRank.SECOND,
                LottoRank.FIFTH,
                LottoRank.FIFTH
        );

        int money = 6000;

        WinningResult winningResult = new WinningResult(ranks, money);
        assertEquals(500166.6666666667, winningResult.getProfitRate());  //출력 시 반올림
    }
}
