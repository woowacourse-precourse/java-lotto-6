package lotto.view;

import java.util.List;

public class PurchasedLottoOutputView {
    private static final String PURCHASED_COUNT = "\n%d개를 구매했습니다.\n";


    public static void outputPurchasedCount(int count) {
        System.out.printf(String.format(PURCHASED_COUNT, count));
    }

    public static void outputPurchasedLottos(List<List<Integer>> purchasedLottos) {
        purchasedLottos.forEach(System.out::println);
    }
}
