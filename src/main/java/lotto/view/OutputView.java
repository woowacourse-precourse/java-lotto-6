package lotto.view;

import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;

public class OutputView {
    private static final String DIVIDER = "---";
    private static final String RESULT_HEADER_MESSAGE = "당첨 통계";

    public void outputPurchasedLottos(PurchasedLottos purchasedLottos) {
        outputPurchasedLottosCount(purchasedLottos);

        purchasedLottos.getCurrentPurchasedLottosList()
                .stream()
                .map(lotto -> lotto.stream().collect(Collectors.joining(",", "[","]")))
                .forEach(System.out::println);
    }

    public static void printResult(Map<Rank, Integer> result, double yield) {
        StringBuilder stringBuilder = new StringBuilder();
        appendResultHeaderToStringBuilder(stringBuilder);
        System.out.print(stringBuilder);
        printYield(yield);
    }


    private static void appendResultHeaderToStringBuilder(StringBuilder stringBuilder) {
        stringBuilder.append(RESULT_HEADER_MESSAGE)
                .append(System.lineSeparator())
                .append(DIVIDER)
                .append(System.lineSeparator());
    }

    private static void printYield(double yield) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ")
                .append(yield)
                .append("입니다.");
    }

    public void outputPurchasedLottosCount(PurchasedLottos purchasedLottos) {
        System.out.printf("%d개를 구매했습니다.%n", purchasedLottos.purchasedLottosCount());
    }

}
