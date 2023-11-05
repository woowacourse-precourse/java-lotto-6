package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;

public class Output {
    private static final String PURCHASE_COUNT_COMMAND = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String COMMA_DELIMITER = ", ";
    private static final String NEXT_LINE = "\n";

    public static void printPurchaseCount(int count) {
        System.out.println(NEXT_LINE + count + PURCHASE_COUNT_COMMAND);
    }

    public static void printLottoBundle(LottoBundle lottoBundle) {
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            printSingleLotto(lotto);
        }
        System.out.println();
    }

    private static void printSingleLotto(Lotto lotto) {
        final List<String> singleLottoBought = lotto.getLotto()
                .stream()
                .map(String::valueOf)
                .toList();

        System.out.println(OPEN_BRACKET + String.join(COMMA_DELIMITER, singleLottoBought) + CLOSE_BRACKET);
    }
}
