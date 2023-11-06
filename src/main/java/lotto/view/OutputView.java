package lotto.view;

import java.util.List;
import lotto.domain.LottoList;

public class OutputView {
    private static final String CHECK_PURCHASE_COUNT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DASHES = "---";

    public static final String REVENUE_MESSAGE = "총 수익률은 %d입니다.";

    public void printPurchasedResult(int count) {
        System.out.println(String.format(CHECK_PURCHASE_COUNT, count));
    }

    public void printLottoList(LottoList lottoList) {
        printPurchasedResult(lottoList.getLottoList().size());
        lottoList.getLottoList()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public void printTotalResult(List<String> result, float revenue) {
        printResultMessage();
        result.forEach(System.out::println);
        printTotalRevenue(revenue);
    }

    public void printResultMessage() {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DASHES);
    }


    public void printTotalRevenue(float revenue) {
        System.out.println(String.format(REVENUE_MESSAGE, revenue));
    }
}
