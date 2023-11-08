package lotto.module.result;

import lotto.module.domain.TotalPrize;
import lotto.module.rank.LottoPrizeTable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    void setLottoResult() {
        lottoResult = LottoResult.newInstance();
    }

    @Test
    void 당첨_금액_계산_성공_테스트() {
        // given
        int loopCount = 3;

        int secondPlacePrize = 0;
        for (int i = 0; i < loopCount; i++) {
            lottoResult.add(LottoPrizeTable.SECOND_PLACE.getRank());
            secondPlacePrize += LottoPrizeTable.SECOND_PLACE.getPrize();
        }

        // when
        TotalPrize totalPrize = lottoResult.getTotalPrize();
        long money = totalPrize.money();

        // then
        Assertions.assertThat(money)
                .isEqualTo(secondPlacePrize);
    }

    @Test
    void 당첨_등수_횟수_계산_성공_테스트() {
        // given
        int loopCount = 3;

        for (int i = 0; i < loopCount; i++) {
            lottoResult.add(LottoPrizeTable.SECOND_PLACE.getRank());
        }

        // when
        int rankCount = lottoResult.getRankCount(LottoPrizeTable.SECOND_PLACE.getRank());

        // then
        Assertions.assertThat(rankCount)
                .isEqualTo(loopCount);
    }

}