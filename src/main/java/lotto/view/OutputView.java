package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningResult;

import java.util.List;

import static lotto.domain.WinningResult.*;
import static lotto.utils.OutputViewPhrase.*;

public class OutputView {

    public static void printLottoCnt(int lottoCnt) {
        System.out.println(lottoCnt+outputPurchaseLottoCnt);
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers());
    }

    public static void printLottoStatistics(float rateOfReturn) {
        System.out.println(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_1);
        System.out.println(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_2);
        for (WinningResult result : WinningResult.values()) {
            if (getMatchBonusNumber(result)) {
                System.out.printf(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_3_2, getMatchCount(result), getWinningMoney(result), 0);
            }
            else {
                System.out.printf(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_3_1, getMatchCount(result), getWinningMoney(result), 0);
            }
        }
        System.out.printf(OUTPUT_PHRASE_WINNING_RESULT_STATISTICS_4, rateOfReturn);
    }

}
