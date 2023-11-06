package lotto.View;

import lotto.model.Lotto;
import lotto.model.LottoRanking;
import lotto.model.LottoTickets;
import lotto.model.WinningResult;

import java.text.NumberFormat;
import java.util.Map;

public class OutputView {

    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String HYPHEN = "---";
    private static final String WINNING_STATS = "당첨 통계";

    public static void printLottoPurchaseAmountMessage() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_PURCHASE_MESSAGE);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        for (Lotto lotto : lottoTickets.getTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printEnterWinningNumber() {
        System.out.println(ENTER_WINNING_MESSAGE);
    }

    public static void printEnterBonusNumber() {
        System.out.println(ENTER_BONUS_MESSAGE);
    }

    public static void printWinningResult(WinningResult winningResult) {
        System.out.println(HYPHEN);
        System.out.println(WINNING_STATS);

        NumberFormat numberFormat = NumberFormat.getInstance();
        Map<LottoRanking, Integer> results = winningResult.getWinningResult();
        for (LottoRanking ranking : LottoRanking.values()) {
            if (ranking != LottoRanking.NONE_MATCH) {
                System.out.printf("%d개 일치%s (%s원) - %d개\n",
                        ranking.getMatchCount(),
                        (ranking.isHasBonusNumber() ? ", 보너스 볼 일치" : ""),
                        numberFormat.format(ranking.getPrize()),
                        results.getOrDefault(ranking, 0));
            }
        }
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", earningRate);
    }
}
