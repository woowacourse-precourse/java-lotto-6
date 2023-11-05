package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.constant.DisplayMessages.*;

public class OutputView {

    public static void purchaseCount(int count) {
        System.out.println();
        System.out.println(PURCHASE_QUANTITY
                .format(String.valueOf(count)));
    }

    public static void displayPurchaseNumbers(List<Lotto> lottoPapers) {
        for (Lotto lotto : lottoPapers) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public static void displayResults() {
        System.out.println(PRIZE_STATISTICS);
        System.out.println(SEPARATOR);
        System.out.println(MATCH_COUNT
                .format(FIFTH_PRIZE_MATCH_COUNT.getMessage(),
                        FIFTH_PRIZE_MONEY.getMessage(),
                        "1")); //각 등수에 해당하는 값 key, value로 찾기

    }
}
