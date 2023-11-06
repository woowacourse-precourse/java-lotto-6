package lotto.view;

import lotto.model.Lottos;
import lotto.model.Result;

public class OutputView {
    private static final String INSTRUCT_COUNT_OF_PURCHASE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String DIVIDER_LINE = "---";

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.size() + INSTRUCT_COUNT_OF_PURCHASE);
        System.out.println(lottos.getLottosNumbers());
    }

    public static void printResult(Result result) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(DIVIDER_LINE);
        System.out.println(result.getResult());
    }

    public static void printProfitPercentage(String result) {
        System.out.printf("총 수익률은 %s입니다.", result);
    }
}
