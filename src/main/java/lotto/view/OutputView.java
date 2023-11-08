package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static final int GRADE_3_MATCH = 5_000;
    public static final int GRADE_4_MATCH = 50_000;
    public static final int GRADE_5_MATCH = 1_500_000;
    public static final int GRADE_5_MATCH_WITH_BONUS = 30_000_000;
    public static final int GRADE_6_MATCH = 2_000_000_000;

    public static final String PURCHASE = "%s개를 구매했습니다%n";
    public static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    public static final String SEPARATOR = "---";
    public static final String GRADE_3_MATCH_MESSAGE = "3개 일치 (%,d원) - %d개%n";
    public static final String GRADE_4_MATCH_MESSAGE = "4개 일치 (%,d원) - %d개%n";
    public static final String GRADE_5_MATCH_MESSAGE = "5개 일치 (%,d원) - %d개%n";
    public static final String GRADE_5_MATCH_WITH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개%n";
    public static final String GRADE_6_MATCH_MESSAGE = "6개 일치 (%,d원) - %d개%n";

    public void printLottoTickets(List<Lotto> lottoSets) {
        int count = lottoSets.size();
        System.out.printf(PURCHASE, count);
        for (Lotto lotto : lottoSets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningState(int[] prizeGradeCounts) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(SEPARATOR);
        System.out.printf(GRADE_3_MATCH_MESSAGE, GRADE_3_MATCH, prizeGradeCounts[5]);
        System.out.printf(GRADE_4_MATCH_MESSAGE, GRADE_3_MATCH, prizeGradeCounts[4]);
        System.out.printf(GRADE_5_MATCH_MESSAGE, GRADE_3_MATCH, prizeGradeCounts[3]);
        System.out.printf(GRADE_5_MATCH_WITH_BONUS_MESSAGE, GRADE_3_MATCH, prizeGradeCounts[2]);
        System.out.printf(GRADE_6_MATCH_MESSAGE, GRADE_3_MATCH, prizeGradeCounts[1]);
    }
}
