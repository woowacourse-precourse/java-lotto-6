package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank1;
import lotto.domain.WinningResult1;

public class OutputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_WINNING_STATICS_MESSAGE = "당첨 통계";
    private static final String LINE_SEPARATE = "---";
    private static final String COUNT_MESSAGE = "%d개 일치";
    private static final String PRIZE_MESSAGE = " (%s원) ";
    private static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String WINNING_COUNT_MESSAGE = "- %d개";
    private static final DecimalFormat decFormat = new DecimalFormat("###,###");

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + LOTTO_AMOUNT_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public static void printWinningStatics(WinningResult1 winningResult) {
        System.out.println(LOTTO_WINNING_STATICS_MESSAGE);
        System.out.println(LINE_SEPARATE);
        for (Rank1 rank : Rank1.values()) {
            System.out.println(createWinningStaticsString(rank, winningResult));
        }
    }

    private static String createWinningStaticsString(Rank1 rank, WinningResult1 winningResult) {
        if (rank == Rank1.SECOND) {
            return String.format(COUNT_MESSAGE, rank.getMatchCount()) + BONUS_MESSAGE
                    + String.format(PRIZE_MESSAGE, decFormat.format(rank.getPrize()))
                    + String.format(WINNING_COUNT_MESSAGE, winningResult.getWinningCount(rank));
        }

        return String.format(COUNT_MESSAGE, rank.getMatchCount())
                + String.format(PRIZE_MESSAGE, decFormat.format(rank.getPrize()))
                + String.format(WINNING_COUNT_MESSAGE, winningResult.getWinningCount(rank));
    }
}
