package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;

import java.util.List;

public class GameView {
    private static final String PURCHASE_AMOUNT_INPUT = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT = "보너스 번호를 입력해주세요.";
    private static final String WINNING_STATISTICS = "당첨 통계\n---";
    private static final String PRIZE_MONEY_FORMAT = "%,d";
    private static final int DEFAULT_WINNING_COUNT = 0;
    private static final String RESULT_FORMAT = "%d개 일치%s (%s원) - %d개";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public String getPurchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_INPUT);
        String input = getInput();

        return input;
    }

    public void showLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + LOTTO_PURCHASE_QUANTITY);

        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getSortedNumbers();

            System.out.println(lottoNumbers);
        }
    }

    public String getWinningNumbersInput() {
        System.out.println(WINNING_NUMBER_INPUT);
        String input = getInput();

        return input;
    }

    public String getBonusNumberInput() {
        System.out.println(BONUS_NUMBER_INPUT);
        String input = getInput();

        return input;
    }

    public void showWinningStatistics(WinningStatistics winningStatistics) {
        System.out.println(WINNING_STATISTICS);

        for (Rank rank : Rank.values()) {
            if (rank== Rank.NONE) continue;

            String result = getResult(rank, winningStatistics);

            System.out.println(result);
        }

        String profitRate = getProfitRate(winningStatistics);

        System.out.println(profitRate);
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
        String prizeMoney = String.format(PRIZE_MONEY_FORMAT, rank.getPrizeMoney());
        Integer winningCount = winningStatistics.getRankCount().getOrDefault(rank, DEFAULT_WINNING_COUNT);

        String result = String.format(RESULT_FORMAT,
                matchCount,
                bonusMatch,
                prizeMoney,
                winningCount);

        return result;
    }

    private String getBonusMatch(Rank rank) {
        String bonusMatch = "";
        if (rank.isBonusMatch()) {
            bonusMatch = BONUS_MATCH;
        }
        return bonusMatch;
    }

    private String getProfitRate(WinningStatistics winningStatistics) {
        return String.format(PROFIT_RATE_FORMAT, winningStatistics.getProfitRate());
    }
}
