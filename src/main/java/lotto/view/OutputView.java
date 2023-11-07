package lotto.view;

import java.util.List;
import lotto.Lotto;
import lotto.lottoGame.rank.Rank;
import lotto.lottoGame.rank.RankCounter;

public class OutputView {

    public static void outputIssuance(int index, List<Lotto> lottos) {
        OutputFormat issuanceFormat = OutputFormat.ISSUANCE_NUMBER_VIEW;

        System.out.printf((issuanceFormat.getFormat()), index);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void resultOutput(RankCounter rankCounter, double incomeRate) {
        OutputFormat resultRankCountView = OutputFormat.RESULT_RANK_COUNT_VIEW;
        OutputFormat resultIncomeView = OutputFormat.RESULT_INCOME_VIEW;

        String resultString = String.format(resultRankCountView.getFormat(),
            rankCounter.getRankCount(Rank.FIFTH)
            , rankCounter.getRankCount(Rank.FOURTH)
            , rankCounter.getRankCount(Rank.THIRD)
            , rankCounter.getRankCount(Rank.SECOND)
            , rankCounter.getRankCount(Rank.FIRST));

        System.out.println(resultString);
        System.out.printf(resultIncomeView.getFormat(), doubleToString(incomeRate));
    }

    private static String doubleToString(double incomeRate) {
        return String.format("%.1f", incomeRate) + "%";
    }
}
