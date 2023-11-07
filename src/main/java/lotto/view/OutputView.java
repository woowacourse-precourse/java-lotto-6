package lotto.view;

import java.text.DecimalFormat;
import lotto.model.PlayerLotto;
import lotto.model.PlayerLottos;
import lotto.model.WinningRank;
import lotto.model.WinningResult;
import lotto.util.NumberConst;

public class OutputView {

    public static final String ISSUE_COUNT_MSG = "개를 구매했습니다.";
    public static final String STATISTICS_MSG = "당첨 통계";
    public static final String CONTOUR_MSG = "---";
    public static final String WINNING_DETAILS_MSG = "%s (%s원) - %d개";
    public static final String PROFIT_MSG = "총 수익률은 %s%%입니다.";

    public void printIssueCount(int money) {
        int issueCount = money / NumberConst.DENOMINATION;
        System.out.println();
        System.out.println(issueCount + ISSUE_COUNT_MSG);

    }

    public void printPlayerLottos(PlayerLottos playerLottos) {
        for (PlayerLotto playerLotto : playerLottos.getPlayerLottos()) {
            System.out.println(playerLotto.toString());
        }
    }

    public void printWinningResult(WinningResult winningResult) {
        System.out.println();
        System.out.println(STATISTICS_MSG);
        System.out.println(CONTOUR_MSG);
        WinningRank[] winningRanks = WinningRank.values();
        for (int i = winningRanks.length - 2; i >= 0; i--) {
            System.out.println(String.format(WINNING_DETAILS_MSG, winningRanks[i].getMessage(),
                    rewardDecimalFormat(winningRanks[i].getReward()),
                    getWinningRankCount(winningResult, winningRanks[i])));
        }
    }

    private static Integer getWinningRankCount(WinningResult winningResult, WinningRank winningRanks) {
        Integer winningRankCount = winningResult.getWinningResult().get(winningRanks);
        if (winningRankCount == null) {
            return 0;
        }
        return winningRankCount;
    }

    public String rewardDecimalFormat(int reward) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(reward);
    }

    public String profitDecimalFormat(double profit) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.0");
        return decimalFormat.format(profit);
    }

    public void printProfit(int money, double totalRevenue) {
        double profit = (totalRevenue / money) * 100;
        System.out.println(String.format(PROFIT_MSG, profitDecimalFormat(profit)));
    }

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
