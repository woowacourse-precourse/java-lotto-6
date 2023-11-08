package lotto.view;

import lotto.domain.Ranking;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTicket;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {

    public static final String RESULT_RANK_MESSAGE = "%d개 일치%s(%s원) - %d개" + System.lineSeparator();

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }

    public static void printPurchaseLottoResult(final LottoTicket ticket) {
        List<Lotto> lottos = ticket.getLottos();
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            printLottoNumbers(lotto);
        }
    }
    public static void printLottoNumbers(Lotto lotto){
        System.out.println(lotto.getLottoNumbers());
    }

    public static void printWinningResult(final WinningResult winningResult) {
        printHeader();
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        for (Ranking ranking : Ranking.rankingWithoutDefault()) {
            System.out.printf(RESULT_RANK_MESSAGE, ranking.getCorrectCount(), printIfSecond(ranking),
                    decimalFormat.format(ranking.getPrize()), winningResult.getWinningCount(ranking));
        }
        System.out.printf("총 수익률은 %.1f%%입니다.\n", winningResult.getRateOfReturnPercent());
    }

    private static String printIfSecond(Ranking ranking) {
        if (ranking == Ranking.SECOND) {
            return ", 보너스 볼 일치 ";
        }
        return " ";
    }

    private static void printHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
