package lotto.view;

import lotto.model.MatchStatus;
import lotto.constant.OutputConstants;
import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    public static void printLottos(List<Lotto> lottos) {
        printPurchasedLottoCount(lottos.size());

        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(number -> System.out.println(number));
    }

    public static void printPurchasedLottoCount(int count) {
        System.out.println();
        System.out.println(String.format(OutputConstants.PURCHASE_MESSAGE_FORMAT, count));
    }

    public static void printCountResult(int[] result) {
        MatchStatus[] values = MatchStatus.values();

        for (int i = 0; i < values.length; i++) {
            System.out.println(String.format(OutputConstants.RESULT_MESSAGE_FORMAT
                    , values[i].getName(), result[i]));
        }
    }

    public static void printTotalPricePercentage(String pricePercentage) {
        System.out.println(String.format(OutputConstants.PROFIT_PERCENTAGE, pricePercentage));
    }

    public static void printResultMessage() {
        System.out.println();
        System.out.println(OutputConstants.WINNING_RESULT_MESSAGE);
        System.out.println(OutputConstants.DASH);
    }
}