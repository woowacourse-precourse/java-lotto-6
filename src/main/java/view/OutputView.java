package view;

import java.util.List;
import lotto.Lotto;
import lotto.Money;

public class OutputView {
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String NOTICE_STATISTIC_MESSAGE = "당첨 통계";
    private static final String NOTICE_LINE = "---";
    private static final String MATCH_THREE = "3개 일치 (5,000원) - ";
    private static final String MATCH_FOUR = "4개 일치 (50,000원) - ";
    private static final String MATCH_FIVE_NO_BONUS = "5개 일치 (1,500,000원) - ";
    private static final String MATCH_FIVE_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String MATCH_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String COUNT = "개";

    private static final String TOTAL_REVENUE_RATE_START = "총 수익률은 ";
    private static final String TOTAL_REVENUE_RATE_FINISH = "%입니다.";

    public void printLottoCount(Money money) {
        System.out.print("\n" + money.getLottoCount());
        System.out.println(LOTTO_COUNT_MESSAGE);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    public void printRank(int first, int second, int third, int fourth, int fifth) {
        System.out.println("\n" + NOTICE_STATISTIC_MESSAGE);
        System.out.println(NOTICE_LINE);
        System.out.println(MATCH_THREE + fifth + COUNT);
        System.out.println(MATCH_FOUR + fourth + COUNT);
        System.out.println(MATCH_FIVE_NO_BONUS + third + COUNT);
        System.out.println(MATCH_FIVE_WITH_BONUS + second + COUNT);
        System.out.println(MATCH_SIX + first + COUNT);
    }

    public void printRate(double rate) {
        System.out.println(TOTAL_REVENUE_RATE_START + rate + TOTAL_REVENUE_RATE_FINISH);
    }
}
