package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    private List<LottoRank> ranks;
    private int money;

    @BeforeEach
    void 초기_설정() {
        ranks = List.of(
                LottoRank.SECOND,
                LottoRank.FIFTH,
                LottoRank.FIFTH
        );

        money = 6000;
    }

    @Test
    void 로또의_당첨_순위와_횟수_확인() {
        WinningResult winningResult = new WinningResult(ranks, money);

        assertEquals(0, winningResult.getWinningResult().get(LottoRank.FIRST));
        assertEquals(1, winningResult.getWinningResult().get(LottoRank.SECOND));
        assertEquals(0, winningResult.getWinningResult().get(LottoRank.THIRD));
        assertEquals(0, winningResult.getWinningResult().get(LottoRank.FOURTH));
        assertEquals(2, winningResult.getWinningResult().get(LottoRank.FIFTH));
    }

    @Test
    void 수익률_확인() {
        WinningResult winningResult = new WinningResult(ranks, money);
        assertEquals(500166.6666666667, winningResult.getProfitRate());  //출력 시 반올림
    }
}
