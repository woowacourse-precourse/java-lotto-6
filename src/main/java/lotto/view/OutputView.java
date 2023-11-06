package lotto.view;

import java.text.DecimalFormat;
import lotto.model.PlayerLotto;
import lotto.model.PlayerLottos;
import lotto.model.WinningRank;
import lotto.model.WinningResult;
import lotto.util.MessageConst;
import lotto.util.NumberConst;

public class OutputView {

    public static final String ISSUE_COUNT_MSG = "개를 구매했습니다.";

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
        System.out.println("당첨 통계");
        System.out.println("---");
        WinningRank[] winningRanks = WinningRank.values();
        for (int i = winningRanks.length - 2; i >= 0; i--) {
            System.out.print(winningRanks[i].getMessage());
            System.out.print(MessageConst.BLANK);
            System.out.print("(" + decimalFormat(winningRanks[i].getReward()) + "원)");
            System.out.print(" - ");
            System.out.print(getWinningRankCount(winningResult, winningRanks[i]));
            System.out.println("개");
        }
    }

    private static Integer getWinningRankCount(WinningResult winningResult, WinningRank winningRanks) {
        Integer winningRankCount = winningResult.getWinningResult().get(winningRanks);
        if (winningRankCount == null) {
            return 0;
        }
        return winningRankCount;
    }

    public String decimalFormat(int reward) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(reward);
    }

}
