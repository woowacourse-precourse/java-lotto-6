package lotto.view;

import static lotto.domain.Prize.NONE;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Prize;
import lotto.domain.Result;

public class Output {

    private static final String BUY_MESSAGE = "%d개를 구매했습니다.\n";

    private static final String LOTTO_MESSAGE = "[%s]\n";

    private static final String RESULT_HEADER = "당첨 통계\n---";

    private static final String PRIZE_MESSAGE = "%s - %d개\n";

    private static final String EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public static void printBoughtLotto(final Lottos lottos) {
        System.out.printf(BUY_MESSAGE, lottos.getLottoCount());
        for (final String numberString : lottos.getNumberStrings()) {
            System.out.printf(LOTTO_MESSAGE, numberString);
        }
        System.out.println();
    }

    public static void printResult(final Result result, final Money moneyForBuy) {
        System.out.println(RESULT_HEADER);
        for (final Prize prize : Prize.values()) {
            if (prize == NONE) {
                continue;
            }
            System.out.printf(PRIZE_MESSAGE, prize.getDescription(), result.getPrizeCount(prize));
        }
        final float rate = moneyForBuy.getRate(result.getWinMoney());
        System.out.printf(EARNING_RATE_MESSAGE, rate * 100);
    }
}
