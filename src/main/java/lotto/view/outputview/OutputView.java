package lotto.view.outputview;

import java.util.List;
import lotto.domain.lottoresult.EarningRate;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;

public class OutputView {
    private static final String BUY_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_STATISTIC_MESSAGE = "\n당첨 통계\n---";

    public static void printLotto(LottoTickets lottoTickets) {
        List<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.printf(BUY_COUNT_MESSAGE, tickets.size());

        LottoTicketOutputView.printLottoTickets(tickets);
    }

    public static void printResult(LottoCheckResult lottoCheckResult, EarningRate earningRate) {
        System.out.println(RESULT_STATISTIC_MESSAGE);
        LottoResultFormatOutputView.printLottoResultFormat(lottoCheckResult);
        EarningRateOutputView.printEarningRate(earningRate);
    }
}
