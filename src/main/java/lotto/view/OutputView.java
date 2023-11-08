package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.PrizeResult;

public class OutputView {
    public static final String TICKET_COUNT_MSG = "개를 구매했습니다.";
    public static final String STATISTICS_MSG = "당첨 통계";
    public static final String LINE_MSG = "---";
    public static final String PROFIT_RATE_MSG = "총 수익률은 %.1f%%입니다.";
    public static final String COUNT_MSG = "개";

    public static void printTicketCount(int lottoCount) {
        System.out.println(lottoCount + TICKET_COUNT_MSG);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printLottoNumbers(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printPrizeResult(PrizeResult prizeResult, int purchaseAmount) {
        System.out.println(STATISTICS_MSG);
        System.out.println(LINE_MSG);
        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                printPrize(prize, prizeResult);
            }
        }
        System.out.printf(PROFIT_RATE_MSG, prizeResult.calculateProfitRate(purchaseAmount));
    }

    private static void printPrize(Prize prize, PrizeResult prizeResult) {
        System.out.println(prize.getMessage() + prizeResult.getResult().get(prize) + COUNT_MSG);
    }
}
