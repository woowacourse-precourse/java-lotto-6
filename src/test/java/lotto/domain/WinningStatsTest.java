package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.system.LottoRankConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatsTest {

    @DisplayName("총 수익 계산")
    @Test
    void getTotalProfit() {
        assertEquals(WinningStats.of(
                        PurchasedLottos.of(List.of(
                                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                                Lotto.of(List.of(3, 4, 5, 6, 1, 2)),
                                Lotto.of(List.of(6, 5, 4, 3, 2, 1)))),
                        WinningNumbersWithBonus.of(Lotto.of(List.of(1, 2, 3, 4, 12, 13))
                                , Ball.from(15))).getProfit(),
                LottoRankConstant.FOURTH_PRIZE.getPrize() * 4);
    }
}
