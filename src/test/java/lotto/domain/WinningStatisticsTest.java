package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {

    @DisplayName("로또 등수 확인")
    @Test
    void countLottoPrize() {
        List<Lotto> inputLottos = new ArrayList<>() {{
            add(new Lotto("1,2,3,4,5,6"));
            add(new Lotto("1,2,3,4,5,7"));
            add(new Lotto("1,2,3,4,5,8"));
            add(new Lotto("1,2,3,4,8,9"));
            add(new Lotto("1,2,3,8,9,10"));
        }};
        Lotto winningNumbers = new Lotto("1,2,3,4,5,6");
        int bonusNumber = 7;
        HashMap<PrizeType, Integer> result = new HashMap<>() {{
            put(PrizeType.FIRST, 1);
            put(PrizeType.SECOND, 1);
            put(PrizeType.THIRD, 1);
            put(PrizeType.FOURTH, 1);
            put(PrizeType.FIFTH, 1);
            put(PrizeType.NONE, 0);
        }};

        WinningStatistics statistics = new WinningStatistics();
        statistics.calculateNumberOfWins(inputLottos, winningNumbers, bonusNumber);

        assertEquals(result, statistics.getLottoRecords());
    }

    @DisplayName("로또 수익률 계산 - 수익 없음")
    @Test
    void calculateRateOfReturnWhenTotalPrizeIsZero() {
        int amount = 3000;
        List<Lotto> lottos = new ArrayList<>() {{
            add(new Lotto("45,44,43,42,41,40"));
            add(new Lotto("39,38,37,36,35,34"));
            add(new Lotto("33,32,30,29,28,27"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;

        WinningStatistics statistics = new WinningStatistics();
        statistics.calculateNumberOfWins(lottos, lotto, bonus);
        assertEquals("0.0", statistics.calculateRewardRate(amount));
    }

}