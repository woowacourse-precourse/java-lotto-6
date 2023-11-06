package lotto.view;

import java.text.DecimalFormat;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningResult;

public class OutputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_WINNING_STATICS_MESSAGE = "당첨 통계";
    private static final String LINE_SEPARATE = "---";
    private static final String WINNING_STATICS_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_WINNING_STATICS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String RATE_MESSAGE = "총 수익률은 %s%%입니다.";

    private final DecimalFormat integerDecFormat = new DecimalFormat("###,###");
    private final DecimalFormat floatDecFormat = new DecimalFormat("###,###.0");

    public void printLottos(Lottos lottos) {
        System.out.printf(LOTTO_AMOUNT_MESSAGE, lottos.getAmount());

        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }

        System.out.println();
    }

    public void printWinningStatics(WinningResult winningResult) {
        System.out.println(LOTTO_WINNING_STATICS_MESSAGE);
        System.out.println(LINE_SEPARATE);
        for (Rank rank : Rank.values()) {
            System.out.println(formatWinningStaticsMessage(rank, winningResult));
        }
    }

    private String formatWinningStaticsMessage(Rank rank, WinningResult winningResult) {
        if (rank == Rank.SECOND) {
            return String.format(SECOND_WINNING_STATICS_MESSAGE, rank.getMatchCount()
                    , toIntegerFormat(rank.getPrize()), winningResult.getWinningCount(rank));
        }

        return String.format(WINNING_STATICS_MESSAGE, rank.getMatchCount()
                , toIntegerFormat(rank.getPrize()), winningResult.getWinningCount(rank));
    }

    private String toIntegerFormat(int prize) {
        return integerDecFormat.format(prize);
    }

    public void printRate(float rate) {
        System.out.println(formatRate(rate));
    }

    private String formatRate(float rate) {
        return String.format(RATE_MESSAGE, toFloatFormat(rate));
    }

    private String toFloatFormat(float rate) {
        return floatDecFormat.format(rate);
    }
}
