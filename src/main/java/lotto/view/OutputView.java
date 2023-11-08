package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;

import java.util.Map;

import static lotto.domain.WinningResult.*;
import static lotto.utils.OutputViewPhrase.*;

public class OutputView {

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printLottoCnt(int lottoCnt) {
        System.out.println(lottoCnt+outputPurchaseLottoCnt);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    public static void printLottoStatistics(Map<WinningResult, Integer> result, float rateOfReturn) {
        System.out.println(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_1);
        System.out.println(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_2);

        for (WinningResult winningResult : WinningResult.values()) {
            if (winningResult == NOTHING) continue;

            int matchCount = getMatchCount(winningResult);
            int winningMoney = getWinningMoney(winningResult);
            int winningCnt = result.getOrDefault(winningResult, 0);

            if (getMatchBonusNumber(winningResult)) {
                System.out.printf(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_3_2, matchCount, winningMoney, winningCnt);
            }
            else {
                System.out.printf(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_3_1, matchCount, winningMoney, winningCnt);
            }
        }

        System.out.printf(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_4, rateOfReturn);
    }

}
