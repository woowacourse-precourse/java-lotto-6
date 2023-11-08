package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningChecker;
import lotto.domain.Prize;
import lotto.domain.WinningNumber;

public class WinningResultOutputView {
    private static final String PRIZE_STATISTICS = "당첨 통계";
    private static final String SEPARATOR = "---";

    public static void printResult(List<Lotto> lottos, WinningNumber winningNumberWithBonusNumber) {
        System.out.println(PRIZE_STATISTICS);
        System.out.println(SEPARATOR);

        int[] matchCounts = LottoWinningChecker.calculateMatchCounts(lottos, winningNumberWithBonusNumber);

        printMatchResult(Prize.THIRD_MATCH, matchCounts[Prize.THIRD_MATCH.getMatchingCount()]);
        printMatchResult(Prize.FOURTH_MATCH, matchCounts[Prize.FOURTH_MATCH.getMatchingCount()]);
        printMatchResult(Prize.FIFTH_MATCH, matchCounts[Prize.FIFTH_MATCH.getMatchingCount()]);
        printMatchResult(Prize.FIFTH_AND_BONUS_MATCH, matchCounts[Prize.FIFTH_AND_BONUS_MATCH.getMatchingCount()]);
        printMatchResult(Prize.SIXTH_MATCH, matchCounts[Prize.SIXTH_MATCH.getMatchingCount()]);
    }

    private static void printMatchResult(Prize prize, int count) {
        String formattedPrize = String.format("%s (%,d원)", prize.getDescription(), prize.getPrizeAmount());
        System.out.println(formattedPrize + " - " + count + "개");
    }
}
