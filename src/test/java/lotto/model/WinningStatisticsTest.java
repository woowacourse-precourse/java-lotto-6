package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.controller.handler.BonusNumberHandler;
import lotto.controller.handler.PurchaseAmountHandler;
import lotto.controller.handler.WinningNumberHandler;
import lotto.utils.WinningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WinningStatisticsTest {
    private WinningStatistics winningStatistics;
    private ArrayList<Lotto> lottos;
    private PrizeNumbers prizeNumbers;
    private int purchaseAmount;
    int expectedTotalWinningAmount;
    double expectedProfitRate;

    @BeforeEach
    void setUp() {
        PurchaseAmountHandler purchaseAmountHandler = new PurchaseAmountHandler("6000");
        purchaseAmountHandler.handle();
        purchaseAmount = purchaseAmountHandler.getHandledResult();
        winningStatistics = new WinningStatistics(purchaseAmount);

        expectedTotalWinningAmount = 2031555000;
        expectedProfitRate = ((double) (expectedTotalWinningAmount)) / purchaseAmount * 100;

        WinningNumberHandler winningNumberHandler = new WinningNumberHandler("1,2,3,4,5,6");
        winningNumberHandler.handle();
        Set<Integer> sequencedNumbers = winningNumberHandler.getHandledResult();

        BonusNumberHandler bonusNumberHandler = new BonusNumberHandler("7");
        bonusNumberHandler.handle();
        int bonusNumber = bonusNumberHandler.getHandledResult();
        prizeNumbers = new PrizeNumbers(sequencedNumbers, bonusNumber);

        lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 37)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 35, 37)));
        lottos.add(new Lotto(List.of(1, 2, 3, 34, 35, 37)));
        lottos.add(new Lotto(List.of(1, 2, 33, 34, 35, 37)));
    }

    @Test
    void testCalculateStatistics() {
        winningStatistics.calculateStatistics(prizeNumbers, lottos.iterator());

        Map<WinningRank, Integer> expectedWinningRecords = new HashMap<>();
        expectedWinningRecords.put(WinningRank.OUT_OF_RANK, 1);
        expectedWinningRecords.put(WinningRank.FIFTH, 1);
        expectedWinningRecords.put(WinningRank.FOURTH, 1);
        expectedWinningRecords.put(WinningRank.SECOND, 1);
        expectedWinningRecords.put(WinningRank.THIRD, 1);
        expectedWinningRecords.put(WinningRank.FIRST, 1);

        Assertions.assertThat(winningStatistics.getWinningRecords()).isEqualTo(expectedWinningRecords);
        Assertions.assertThat(winningStatistics.getTotalWinningAmount()).isEqualTo(expectedTotalWinningAmount);
        Assertions.assertThat(winningStatistics.getProfitRate()).isEqualTo(expectedProfitRate);
    }

    @Test
    void testToString() {

        double roundedProfitRate = Math.round(expectedProfitRate) / 10.0;
        String expected = "3개 일치 (5,000원) - 1개\n"
                + "4개 일치 (50,000원) - 1개\n"
                + "5개 일치 (1,500,000원) - 1개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n"
                + "6개 일치 (2,000,000,000원) - 1개\n"
                + "총 수익률은 " + roundedProfitRate + "%입니다. ";
        winningStatistics.calculateStatistics(prizeNumbers, lottos.iterator());

        Assertions.assertThat(winningStatistics.toString()).isEqualTo(expected);
    }
}