package lotto.view;

import java.util.List;

public class OutputView {
    private static final int MATCH_NONE = 0;

    public static void printPurchaseComplete(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }
}
