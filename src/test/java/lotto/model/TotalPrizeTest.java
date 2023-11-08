package lotto.model;

import lotto.model.constants.LottoWinningRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalPrizeTest {
    @Test
    @DisplayName("총_당첨_내역_객체_생성")
    void createLotto() {
        LottoTotalPrize lottoTotalPrize = new LottoTotalPrize();
        lottoTotalPrize.prizeCountPlus(LottoWinningRank.FIRST);
        lottoTotalPrize.prizeCountPlus(LottoWinningRank.THIRD);

        assertThat(lottoTotalPrize.getPrizeCounts().get(LottoWinningRank.FIRST))
                .isEqualTo(1);
        assertThat(lottoTotalPrize.getPrizeCounts().get(LottoWinningRank.SECOND))
                .isEqualTo(0);
        assertThat(lottoTotalPrize.getPrizeCounts().get(LottoWinningRank.THIRD))
                .isEqualTo(1);
    }
}
