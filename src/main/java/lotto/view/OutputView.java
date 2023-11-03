package lotto.view;

import java.util.Collection;
import java.util.List;
import lotto.domain.lottoresult.EarningRate;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;

public class OutputView {
    private static final String BUY_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_STATISTIC_MESSAGE = "\n당첨 통계\n---";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public static void printLotto(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.printf(BUY_COUNT_MESSAGE, tickets.size());

        tickets.stream()
                .map(Lotto::getLotto)
                .forEach(lotto -> printLottoNumbers(lotto));
    }

    public static void printResult(LottoCheckResult lottoCheckResult, EarningRate earningRate) {
        System.out.println(RESULT_STATISTIC_MESSAGE);
        LottoResultFormatOutputView.printLottoResultFormat(lottoCheckResult);
        printEarningRate(earningRate);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static void printLottoNumbers(List<Integer> lotto) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int idx = 0; idx < lotto.size(); idx++) {
            sb.append(lotto.get(idx));
            if (idx < lotto.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.printf(EARNING_RATE_FORMAT, earningRate.getRate());
    }
}
