package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoWinningChecker;
import lotto.domain.WinningNumber;

public class WinningResultOutputVieiw {
    private static final String PRIZE_STATISTICS = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String THREE_MATCH_PRIZE = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCH_PRIZE = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCH_PRIZE = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_AND_BONUS_MATCH_PRIZE = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCH_PRIZE = "6개 일치 (2,000,000,000원) - ";

    public static void printResult(List<Lotto> lottos, WinningNumber winningNumber) {
        System.out.println(PRIZE_STATISTICS);
        System.out.println(SEPARATOR);

        int[] matchCounts = calculateMatchCounts(lottos, winningNumber);

        printMatchResult(THREE_MATCH_PRIZE, matchCounts[3]);
        printMatchResult(FOUR_MATCH_PRIZE, matchCounts[4]);
        printMatchResult(FIVE_MATCH_PRIZE, matchCounts[5]);
        printMatchResult(FIVE_AND_BONUS_MATCH_PRIZE, matchCounts[7]);
        printMatchResult(SIX_MATCH_PRIZE, matchCounts[6]);
    }

    private static int[] calculateMatchCounts(List<Lotto> lottos, WinningNumber winningNumber) {
        int[] matchCounts = new int[8];

        for (Lotto lotto : lottos) {
            int matchingCount = LottoWinningChecker.checkWinningNumbers(lotto, winningNumber);
            matchCounts[matchingCount]++;
        }

        return matchCounts;
    }

    private static void printMatchResult(String description, int count) {
        System.out.println(description + " - " + count + "개");
    }
}
