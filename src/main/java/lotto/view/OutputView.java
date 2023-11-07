package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.lottoGame.rank.Rank;
import lotto.lottoGame.rank.RankCounter;

public class OutputView {
    private static final String ISSUANCE_NUMBER_VIEW = "%d개를 구매했습니다.\n";
    private static final String RESULT_RANK_COUNT_VIEW = "당첨 통계\n"
        + "---\n"
        + "3개 일치 (5,000원) - %d개\n"
        + "4개 일치 (50,000원) - %d개\n"
        + "5개 일치 (1,500,000원) - %d개\n"
        + "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"
        + "6개 일치 (2,000,000,000원) - %d개";
    private static final String RESULT_INCOME_VIEW = "총 수익률은 %s입니다.\n";

    public static void outputIssuance(int index, List<Lotto> lottos) {
        System.out.printf((ISSUANCE_NUMBER_VIEW), index);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void resultOutput(RankCounter rankCounter, double incomeRate) {
        String resultString = String.format(RESULT_RANK_COUNT_VIEW,
            rankCounter.getRankCount(Rank.FIFTH)
            , rankCounter.getRankCount(Rank.FOURTH)
            , rankCounter.getRankCount(Rank.THIRD)
            , rankCounter.getRankCount(Rank.SECOND)
            , rankCounter.getRankCount(Rank.FIRST));

        System.out.println(resultString);
        System.out.printf(RESULT_INCOME_VIEW, doubleToString(incomeRate));
    }

    private static String doubleToString(double incomeRate) {
        return String.format("%.1f", incomeRate) + "%";
    }
}
