package lotto.view;

import static lotto.utils.InsertMessage.BONUS_NUMBER_INSERT_MESSAGE;
import static lotto.utils.InsertMessage.BUY_PRICE_INSERT_MESSAGE;
import static lotto.utils.InsertMessage.WINNING_NUMBER_INSERT_MESSAGE;
import static lotto.utils.OutputMessage.BONUS_MATCH_MESSAGE;
import static lotto.utils.OutputMessage.BRACKETS1;
import static lotto.utils.OutputMessage.BRACKETS2;
import static lotto.utils.OutputMessage.FIVE_MATCH_MESSAGE;
import static lotto.utils.OutputMessage.FOUR_MATCH_MESSAGE;
import static lotto.utils.OutputMessage.HYPHEN;
import static lotto.utils.OutputMessage.HYPHENS;
import static lotto.utils.OutputMessage.LOTTO_OUTPUT_MESSAGE;
import static lotto.utils.OutputMessage.RESULT_OUTPUT_BACK_MESSAGE;
import static lotto.utils.OutputMessage.RESULT_OUTPUT_FRONT_MESSAGE;
import static lotto.utils.OutputMessage.SIX_MATCH_MESSAGE;
import static lotto.utils.OutputMessage.THREE_MATCH_MESSAGE;
import static lotto.utils.OutputMessage.WINNING_STATISTIC_MESSAGE;

import java.util.Map;
import lotto.model.WinningStatistics;

public class OutputView {
    public void printLotto(String lottoNumber) {
        System.out.println(BRACKETS1.getMessage() + lottoNumber + BRACKETS2.getMessage());
    }

    public void printEarningRate(double earningRate) {
        System.out.println(RESULT_OUTPUT_FRONT_MESSAGE.getMessage() + Double.toString(earningRate)
                + RESULT_OUTPUT_BACK_MESSAGE.getMessage());
    }

    public void printInsertBuyPrice() {
        System.out.println(BUY_PRICE_INSERT_MESSAGE.getMessage());
    }

    public void printInsertWinningNumber() {
        System.out.println("\n" + WINNING_NUMBER_INSERT_MESSAGE.getMessage());
    }

    public void printInsertBonusNumber() {
        System.out.println("\n" + BONUS_NUMBER_INSERT_MESSAGE.getMessage());
    }

    public void printWinningStatisticMessage() {
        System.out.print("\n" + WINNING_STATISTIC_MESSAGE.getMessage() + HYPHENS.getMessage());
    }

    public void printWinningStatistic(Map<WinningStatistics, Long> winningStatistics) {
        System.out.println(
                THREE_MATCH_MESSAGE.getMessage() + HYPHEN.getMessage() + winningStatistics.getOrDefault(
                        WinningStatistics.THREE_MATCH, 0L)
                        + "개");
        System.out.println(
                FOUR_MATCH_MESSAGE.getMessage() + HYPHEN.getMessage() + winningStatistics.getOrDefault(
                        WinningStatistics.FOUR_MATCH,
                        0L)
                        + "개");
        System.out.println(
                FIVE_MATCH_MESSAGE.getMessage() + HYPHEN.getMessage() + winningStatistics.getOrDefault(
                        WinningStatistics.FIVE_MATCH,
                        0L)
                        + "개");
        System.out.println(
                BONUS_MATCH_MESSAGE.getMessage() + HYPHEN.getMessage() + winningStatistics.getOrDefault(
                        WinningStatistics.FIVE_MATCH_BONUS,
                        0L) + "개");
        System.out.println(
                SIX_MATCH_MESSAGE.getMessage() + HYPHEN.getMessage() + winningStatistics.getOrDefault(
                        WinningStatistics.SIX_MATCH,
                        0L) + "개");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println("\n" + lottoCount + LOTTO_OUTPUT_MESSAGE.getMessage());
    }

}
