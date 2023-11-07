package lotto.view;

import java.util.List;
import lotto.model.LottoResult;
import lotto.model.WinningInfo;

public class OutputView {
    private static final String PURCAHSE_AMOUNT_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String WINNING_STATS_HEADER = "\n당첨 통계";
    private static final String DASH_LINE = "---";
    private static final String WINNING_STATS_FORMAT = "%s (%,d원) - %d개\n";
    private static final String TOTAL_RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";
    private static final int PERCENTAGE_CONVERSION = 100;

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf(PURCAHSE_AMOUNT_FORMAT, purchaseAmount);
    }

    public void printLottos(List<String> lottos) {
        lottos.forEach(System.out::println);
        System.out.println();
    }

    public void printWinningHeader() {
        System.out.println(WINNING_STATS_HEADER);
        System.out.println(DASH_LINE);
    }

    public void printWinnerStatus(LottoResult lottoResult) {
        List<WinningInfo> winningInfos = List.of(WinningInfo.THREE_MATCH, WinningInfo.FOUR_MATCH,
                WinningInfo.FIVE_MATCH,
                WinningInfo.FIVE_AND_BONUS_MATCH, WinningInfo.SIX_MATCH);

        winningInfos.forEach(winningInfo -> {
            int count = lottoResult.getCount(winningInfo);
            System.out.printf(WINNING_STATS_FORMAT, winningInfo.matchedInfo, winningInfo.price, count);
        });
    }

    public void printTotalRateOfReturn(double rateOfReturn) {
        System.out.printf(TOTAL_RATE_OF_RETURN_FORMAT, rateOfReturn * PERCENTAGE_CONVERSION);
    }
}
