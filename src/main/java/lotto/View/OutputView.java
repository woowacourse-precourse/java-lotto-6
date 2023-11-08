package lotto.View;

import lotto.Model.Lotto;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

import static lotto.Constants.*;
public class OutputView {
    public static void printPurchaseResult(List<Lotto> purchaseResult, int lottoCount) {
        System.out.println(lottoCount + PURCHASE_COUNT_MESSAGE);
        for(Lotto numbers : purchaseResult) {
            System.out.println(numbers.toString());
        }
    }

    public static void printWinningStatistics(List<Integer> winningStatistics, int BonusNumberMatchCount) {
        int fiveMatches = Collections.frequency(winningStatistics, Numbers.FIVE);
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(THREE_MATCHES_MESSAGE + Collections.frequency(winningStatistics, Numbers.THREE) + "개");
        System.out.println(FOUR_MATCHES_MESSAGE + Collections.frequency(winningStatistics, Numbers.FOUR) + "개");
        System.out.println(FIVE_MATCHES_MESSAGE + (fiveMatches - BonusNumberMatchCount) + "개");
        System.out.println(FIVE_MATCHES_WITH_BONUS_MESSAGE + BonusNumberMatchCount + "개");
        System.out.println(SIX_MATCHES_MESSAGE + Collections.frequency(winningStatistics, Numbers.SIX) + "개");
    }

    public static void printReturnRate(double returnRate) {
        DecimalFormat formatter = new DecimalFormat("#,###,###.0");
        System.out.println("총 수익률은 " + formatter.format(returnRate) + "%입니다.");
    }
}
