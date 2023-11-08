package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("당첨 등수 개수 증가")
    void 당첨_등수_개수_증가() {
        LottoResult result = new LottoResult();
        result.addWinningRank(LottoRank.FIRST);
        assertEquals(1, result.getCountOfRank(LottoRank.FIRST));
    }

    @Test
    @DisplayName("총 수익 계산")
    void 총_수익_계산() {
        LottoResult result = new LottoResult();
        result.addWinningRank(LottoRank.FIRST);
        result.addWinningRank(LottoRank.FOURTH);
        double expectedEarnings = LottoRank.FIRST.getWinningAmount() + LottoRank.FOURTH.getWinningAmount();
        assertEquals(expectedEarnings, result.getTotalEarnings());
    }
}