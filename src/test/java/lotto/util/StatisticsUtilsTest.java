package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsUtilsTest {

    @Test
    void 보너스_번호_일치_테스트() {
        // given
        int bonusNumber = 12;
        Lotto lotto = new Lotto(List.of(7, 12, 4, 6, 1, 9));

        // when, then
        assertTrue(StatisticsUtils.isMatchBonusNumber(lotto, bonusNumber));
    }

    @Test
    void 당첨_번호와_로또_번호_일치_테스트() {
        // given
        Lotto prize = new Lotto(List.of(1, 3, 5, 6, 7, 9));

        Lotto target1 = new Lotto(List.of(8, 1, 5, 12, 3, 24));
        Lotto target2 = new Lotto(List.of(17, 34, 12, 6, 2, 36));

        // when
        int matchingCount = StatisticsUtils.calculateMatchingCount(prize, target1);
        int matchingCount2 = StatisticsUtils.calculateMatchingCount(prize, target2);

        // then
        assertEquals(3, matchingCount);
        assertEquals(1, matchingCount2);
    }

    @Test
    void 등수에_따른_당첨_개수_테스트() {
        // given
        int bonusNumber = 7;
        Lotto prize = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(3, 5, 10, 4, 12, 13)));
        lottos.add(new Lotto(List.of(6, 5, 3, 4, 12, 8)));
        lottos.add(new Lotto(List.of(7, 1, 2, 3, 4, 5)));
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));

        // when
        Prize[] calculatedPrizes = StatisticsUtils.calculatePrize(prize, lottos, bonusNumber);

        // then
        assertEquals(1, calculatedPrizes[0].getMatchedCount());
        assertEquals(1, calculatedPrizes[1].getMatchedCount());
        assertEquals(1, calculatedPrizes[2].getMatchedCount());
        assertEquals(1, calculatedPrizes[3].getMatchedCount());
        assertEquals(1, calculatedPrizes[4].getMatchedCount());
    }

    @Test
    void 총_수익_테스트() {
        // given
        int bonusNumber = 7;
        Lotto prize = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(3, 5, 10, 4, 12, 13)));
        lottos.add(new Lotto(List.of(6, 5, 3, 4, 12, 8)));
        lottos.add(new Lotto(List.of(7, 1, 2, 3, 4, 5)));
        lottos.add(new Lotto(List.of(6, 5, 4, 3, 2, 1)));

        // when
        Prize[] calculatedPrizes = StatisticsUtils.calculatePrize(prize, lottos, bonusNumber);
        long totalReturn = StatisticsUtils.calculateTotalReturn(calculatedPrizes);

        // then
        assertEquals(2031555000, totalReturn);
    }

    @Test
    void 수익률_계산_테스트() {
        // given
        int earned1 = 5000;
        int paid1 = 8000;

        int earned2 = 14000;
        int paid2 = 13000;

        // when
        double returnRate1 = StatisticsUtils.calculateReturnRate(paid1, earned1);
        double returnRate2 = StatisticsUtils.calculateReturnRate(paid2, earned2);

        String formatted1 = String.format("%.1f", returnRate1);
        String formatted2 = String.format("%.1f", returnRate2);

        // then
        assertEquals("62.5", formatted1);
        assertEquals("107.7", formatted2);
    }
}