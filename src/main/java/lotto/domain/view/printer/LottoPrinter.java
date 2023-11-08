package lotto.domain.view.printer;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.entity.lotto.Lotto;

public class LottoPrinter {
    private static final String PURCHASED_SIZE_PRINT_MESSAGE = "개를 구매했습니다.";
    private static final String LEFT_SQUARE_BRACKETS = "[";
    private static final String RIGHT_SQUARE_BRACKETS = "]";
    private static final String SEPARATOR = ", ";

    private LottoPrinter() {
    }

    public static void printPurchased(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASED_SIZE_PRINT_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.print(LEFT_SQUARE_BRACKETS);
            System.out.print(arrayAscendingLottoWithComma(lotto));
            System.out.println(RIGHT_SQUARE_BRACKETS);
        }
        System.out.println();
    }

    private static String arrayAscendingLottoWithComma(Lotto lotto) {
        return lotto.getSortedAscending()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR));
    }
}
