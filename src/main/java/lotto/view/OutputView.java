package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {

    private static final String LOTTO_TICKETS_COUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_TICKETS_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String LOTTO_TICKETS_EARNING_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottos(final List<Lotto> lottos) {
        printLottosCount(lottos);
        printLottosNumber(lottos);
    }

    private static void printLottosCount(List<Lotto> lottos) {
        final String ticketCountPrintFormat = String.format(LOTTO_TICKETS_COUNT_MESSAGE,
            lottos.size());
        System.out.println(ticketCountPrintFormat);
    }

    private static void printLottosNumber(List<Lotto> lottos) {
        for (final Lotto lotto : lottos) {
            System.out.println(lotto.numbersToString());
        }
    }

    public static void printLottoResult(final LottoResult result) {
        System.out.println(LOTTO_TICKETS_RESULT_MESSAGE);
        System.out.println(result.toOutputString());
    }

    public static void printEarningRate(final double earningRate) {
        final String earningRateMessage = String.format(LOTTO_TICKETS_EARNING_RATE_MESSAGE,
            earningRate);
        System.out.println(earningRateMessage);
    }

}