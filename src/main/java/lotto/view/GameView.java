package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.List;

public class GameView {


    public String getPurchaseAmountInput() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {

            System.out.println(lotto.getSortedNumbers());
        }
    }

    public String getWinningNumbersInput() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = getInput();

        return input;
    }

    public String getBonusNumberInput() {
        System.out.println("보너스 번호를 입력해주세요.");
        String input = getInput();

        return input;
    }

    public void showWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println("당첨 통계\n---");

        for (Rank rank : Rank.values()) {
            if (rank== Rank.NONE) continue;

            String result = getResult(rank, winningStatistics);

            System.out.println(result);
        }

        System.out.println(getProfitRate(winningStatistics));

    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    private String getInput() {
        return Console.readLine();
    }

    private String getResult(Rank rank, WinningStatistics winningStatistics) {
        int matchCount = rank.getMatchCount();
        String bonusMatch = getBonusMatch(rank);
        String prizeMoney = String.format("%,d", rank.getPrizeMoney());
        Integer winningCount = winningStatistics.getRankCount().getOrDefault(rank, 0);

        String result = String.format(("%d개 일치%s (%s원) - %d개"),
                matchCount,
                bonusMatch,
                prizeMoney,
                winningCount);

        return result;
    }

    private String getBonusMatch(Rank rank) {
        String bonusMatch = "";
        if (rank.isBonusMatch()) {
            bonusMatch = ", 보너스 볼 일치";
        }
        return bonusMatch;
    }

    private String getProfitRate(WinningStatistics winningStatistics) {
        return String.format("총 수익률은 %.1f%%입니다.", winningStatistics.getProfitRate());
    }
}
