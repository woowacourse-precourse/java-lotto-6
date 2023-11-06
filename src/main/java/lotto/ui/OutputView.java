package lotto.ui;

import java.util.List;

public class OutputView {
    private static String LOTTO_QUANTITY_NOTIFY_MESSAGE = "%d개를 구매했습니다.";

    public static void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void printLottoQuantity(int lottoQuantity) {
        System.out.println();
        System.out.printf((LOTTO_QUANTITY_NOTIFY_MESSAGE) + "%n", lottoQuantity);
    }
}