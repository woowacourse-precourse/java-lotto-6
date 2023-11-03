package lotto.view;

import java.util.Collection;
import lotto.domain.lottoresult.EarningRate;
import lotto.domain.lottoresult.LottoCheckResult;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;

public class OutputView {

    public static void printLotto(LottoTickets lottoTickets) {
        Collection<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.printf("\n%d개를 구매했습니다.\n", tickets.size());

        tickets.stream()
                .map(Lotto::getLotto)
                .forEach(lotto -> System.out.println(lotto));
    }

    public static void printResult(LottoCheckResult lottoCheckResult, EarningRate earningRate) {
        System.out.println("\n당첨 통계\n---");
        LottoResultFormatOutputView.printLottoResultFormat(lottoCheckResult);
        printEarningRate(earningRate);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private static void printEarningRate(EarningRate earningRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate.getRate());
    }
}
