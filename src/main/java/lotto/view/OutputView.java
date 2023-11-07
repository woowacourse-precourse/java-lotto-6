package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.ResultCalculator;

public class OutputView {
    public static final String ISSUED_LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    public static final String WINNING_STATISTICS_TITLE = "\n당첨 통계\n---";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.\n";

    public static void printIssuedLotto(List<Lotto> lottos) {
        System.out.printf((ISSUED_LOTTO_COUNT_MESSAGE), lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printResult(ResultCalculator resultCalculator) {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(resultCalculator);
        System.out.printf(PROFIT_RATE_MESSAGE, resultCalculator.getProfitRate());
    }
}
